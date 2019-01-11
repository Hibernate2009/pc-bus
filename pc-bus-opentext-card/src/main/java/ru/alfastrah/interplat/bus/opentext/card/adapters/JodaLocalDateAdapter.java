package ru.alfastrah.interplat.bus.opentext.card.adapters;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Адаптер для преобразования между объектным (joda-time) и XML-представлением
 * локальной даты без времени
 */
public class JodaLocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private static final DateTimeFormatter DTF_DZ = DateTimeFormat
            .forPattern("yyyy-MM-dd'Z");

    /**
     * Производит преобразование из текста/XML в LocalDate<br>
     * Использует формат даты, с указанной TZ всегда == 'Z' (UTC), которую нужно
     * игнорировать
     */
    @Override
    public LocalDate unmarshal(String v) {
        return DTF_DZ.parseLocalDate(v);
    }

    /**
     * Производит преобразование из LocalDate в текст для XML<br>
     * Использует формат даты, со указанной постоянной "TZ UTC"<br>
     */
    @Override
    public String marshal(LocalDate v) {
        // форматируем c Z на конце
        return DTF_DZ.print(v);
    }

}
