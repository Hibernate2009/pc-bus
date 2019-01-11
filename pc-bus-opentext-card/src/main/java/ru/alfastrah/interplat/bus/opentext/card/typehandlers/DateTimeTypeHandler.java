package ru.alfastrah.interplat.bus.opentext.card.typehandlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;

import java.sql.*;

public class DateTimeTypeHandler implements TypeHandler {

    /**
     * Константа - временная зона, принимаемая как родная для использования БД
     */
    private static final org.joda.time.DateTimeZone TZ_DATABASE = org.joda.time.DateTimeZone.forID("Europe/Moscow");
    /**
     * Константа - временная зона UTC, принимаемая как промежуточная для
     * пересчётов
     */
    private static final org.joda.time.DateTimeZone TZ_UTC = org.joda.time.DateTimeZone.UTC;

    /**
     * Константа - календарь в зоне UTC для установки и считывания jdbc
     * TIMESTAMP из/в переменных java.sql.Timestamp без сдвига часового пояса
     */
    private final java.util.Calendar calendarUtc = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));

    @Override
    public void setParameter(PreparedStatement setter, int i, Object parameter, JdbcType jt) throws SQLException {
        DateTime dateTime = (DateTime) parameter;
        if (dateTime == null) {
            setter.setTimestamp(i, null);
        } else {
            DateTime dateTimeInDataBase = dateTime.withZone(TZ_DATABASE);
            DateTime dateTimeInPseudoUTC = dateTimeInDataBase
                    .withZoneRetainFields(TZ_UTC);
            Timestamp timeStampInPseudoUTC = new Timestamp(
                    dateTimeInPseudoUTC.getMillis());
            setter.setTimestamp(i, timeStampInPseudoUTC, calendarUtc);
        }
    }

    @Override
    public Object getResult(ResultSet rs, String column) throws SQLException {
        Timestamp timeStampInPseudoUTC = rs.getTimestamp(column, calendarUtc);
        return getDateTimeFromTimestamp(timeStampInPseudoUTC);
    }

    @Override
    public Object getResult(ResultSet rs, int column) throws SQLException {
        Timestamp timeStampInPseudoUTC = rs.getTimestamp(column, calendarUtc);
        return getDateTimeFromTimestamp(timeStampInPseudoUTC);
    }

    @Override
    public Object getResult(CallableStatement cs, int column) throws SQLException {
        Timestamp timeStampInPseudoUTC = cs.getTimestamp(column, calendarUtc);
        return getDateTimeFromTimestamp(timeStampInPseudoUTC);
    }

    private DateTime getDateTimeFromTimestamp(Timestamp timestamp) {
        if (timestamp != null) {
            return new DateTime(timestamp.getTime(), TZ_UTC).withZoneRetainFields(TZ_DATABASE);
        } else return null;
    }

}