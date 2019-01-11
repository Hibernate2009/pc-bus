package ru.alfastrah.interplat.bus.opentext.card.entities.unicus;

import org.joda.time.LocalDate;

public class ActInfoDoc {
    private String numberPaymentOrderKV;
    private LocalDate datePaymentOrderKV;

    public String getNumberPaymentOrderKV() {
        return numberPaymentOrderKV;
    }

    public void setNumberPaymentOrderKV(String numberPaymentOrderKV) {
        this.numberPaymentOrderKV = numberPaymentOrderKV;
    }

    public LocalDate getDatePaymentOrderKV() {
        return datePaymentOrderKV;
    }

    public void setDatePaymentOrderKV(LocalDate datePaymentOrderKV) {
        this.datePaymentOrderKV = datePaymentOrderKV;
    }

    @Override
    public String toString() {
        return "ActInfoDoc{" +
                "numberPaymentOrderKV='" + numberPaymentOrderKV + '\'' +
                ", datePaymentOrderKV=" + datePaymentOrderKV +
                '}';
    }
}
