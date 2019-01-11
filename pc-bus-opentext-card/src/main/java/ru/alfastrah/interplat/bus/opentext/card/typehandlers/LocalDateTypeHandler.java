package ru.alfastrah.interplat.bus.opentext.card.typehandlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

import java.sql.*;
import java.util.Calendar;
import java.util.TimeZone;

public class LocalDateTypeHandler implements TypeHandler {

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        LocalDate ld = (LocalDate) parameter;
        if (ld != null) {
            DateTime dtUTC = ld.toDateTimeAtStartOfDay(DateTimeZone.UTC);
            Timestamp timestamp = new Timestamp(dtUTC.getMillis());
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            ps.setTimestamp(i, timestamp, calendar);
        } else {
            ps.setTimestamp(i, null);
        }
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        Timestamp ts = rs.getTimestamp(columnName, calendar);
        return getLocalDateFromTimestamp(ts);
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        Timestamp ts = cs.getTimestamp(columnIndex, calendar);
        return getLocalDateFromTimestamp(ts);
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        Timestamp ts = rs.getTimestamp(columnIndex, calendar);
        return getLocalDateFromTimestamp(ts);
    }

    private LocalDate getLocalDateFromTimestamp(Timestamp timestamp) {
        if (timestamp != null) {
            return new DateTime(timestamp.getTime(), DateTimeZone.UTC).toLocalDate();
        } else return null;
    }

}