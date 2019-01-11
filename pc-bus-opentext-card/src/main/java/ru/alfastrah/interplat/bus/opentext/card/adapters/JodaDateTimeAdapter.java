package ru.alfastrah.interplat.bus.opentext.card.adapters;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.ISODateTimeFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Адаптер для преобразования между объектным (joda-time) и XML-представлением
 * даты+времени с часовым поясом
 */
public class JodaDateTimeAdapter extends XmlAdapter<String, DateTime> {
    /**
     * Временная зона <source>"Europe/Moscow"</source>, которая "на самом деле"
     * используется в ЮНИКУСе, хотя передаётся "декорированная" под UTC
     */
    private static final DateTimeZone TZ_UNICUS = DateTimeZone
            .forID("Europe/Moscow");

    private static final DateTimeFormatter DTF_XML = ISODateTimeFormat
            .dateTimeNoMillis().withOffsetParsed();

    private static final DateTimeFormatter DTF_XML_NO_ZONE = ISODateTimeFormat
            .dateHourMinuteSecond().withZoneUTC();
    private final DateTimeFormatter dateTimeFormatter;

    /**
     * Может принимать два формата: с временной зоной и без нее. При этом в Юникусе хранитя время Московское, но
     * 'как бы' в зоне UTC (т.е. числовое значение Московское, а обозначено как UTC).
     */
    public JodaDateTimeAdapter() {
        DateTimeParser[] parsers = new DateTimeParser[]{DTF_XML.getParser(), DTF_XML_NO_ZONE.getParser()};
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        builder.append(DTF_XML.getPrinter(), parsers);
        dateTimeFormatter = builder.toFormatter().withZoneUTC();
    }

    /**
     * Производит преобразование из текста/XML в DateTime<br>
     * Использует полный ISODateTimeFormat, со смещением, но без миллисекунд
     *
     * @return
     */
    @Override
    public DateTime unmarshal(String v) {
        return dateTimeFormatter.parseDateTime(v).withZoneRetainFields(TZ_UNICUS);
    }

    /**
     * Производит преобразование из DateTime в текст для XML<br>
     * Использует полный ISODateTimeFormat, со смещением, но без миллисекунд<br>
     * Считает, что ЮНИКУС на самом деле использует временную зону
     * UnicusConstants.TZ_UNICUS, хотя декорирует передаваемое "под UTC"<br>
     *
     * @return
     */
    @Override
    public String marshal(DateTime v) {
        // переводим в "реальную зону" ЮНИКУСа
        DateTime dtU = v.withZone(TZ_UNICUS);
        // декорируем "под UTC"
        DateTime dtD = dtU.withZoneRetainFields(DateTimeZone.UTC);
        // форматируем по ISO
        return dateTimeFormatter.print(dtD);
    }

}
