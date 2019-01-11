package ru.alfastrah.interplat.bus.opentext.card.adapters;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Адаптер для преобразования между объектным (joda-time) и XML-представлением
 * локальной даты+времени (без часового поясом)
 */
public class JodaLocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    private static final DateTimeFormatter DTF_XML = ISODateTimeFormat
            .dateTimeNoMillis().withOffsetParsed();

    /**
     * Производит преобразование из текста/XML в LocalDateTime<br>
     * Использует полный ISODateTimeFormat, со смещением, но без миллисекунд<br>
     * Так как ЮНИКУС отдаёт всегда "как бы UTC", то в местное время переводится
     * без каких-либо изменений TZ, по сути "отсекая" временной пояс
     */
    @Override
    public LocalDateTime unmarshal(String v) {
        return DTF_XML.parseDateTime(v).toLocalDateTime();
    }

    /**
     * Производит преобразование из LocalDateTime в текст для XML<br>
     * Использует полный ISODateTimeFormat, со смещением, но без миллисекунд<br>
     * Так как ЮНИКУС ожидает представление во временной зоне UTC, то
     * производится "декорирование" локальной даты переводом "под UTC"
     */
    @Override
    public String marshal(LocalDateTime v) {
        // декорируем для ЮНИКУСа "под UTC"
        DateTime dtD = v.toDateTime(DateTimeZone.UTC);
        // форматируем по ISO
        return DTF_XML.print(dtD);
    }

}
