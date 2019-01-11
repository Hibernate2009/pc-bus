package ru.alfastrah.interplat.bus.opentext.card.entities.opentext;

import com.opentext.livelink.service.otintegration.CardADType;
import com.opentext.livelink.service.otintegration.CardDSType;
import com.opentext.livelink.service.otintegration.CardReportActType;
import ru.alfastrah.interplat.bus.opentext.card.entities.DocumentType;

public class OpentextRequest {
    private CardReportActType cardReportActType;
    private CardDSType cardDSType;
    private CardADType cardADType;

    public CardReportActType getCardReportActType() {
        return cardReportActType;
    }

    public void setCardReportActType(CardReportActType cardReportActType) {
        this.cardReportActType = cardReportActType;
    }

    public CardDSType getCardDSType() {
        return cardDSType;
    }

    public void setCardDSType(CardDSType cardDSType) {
        this.cardDSType = cardDSType;
    }

    public CardADType getCardADType() {
        return cardADType;
    }

    public void setCardADType(CardADType cardADType) {
        this.cardADType = cardADType;
    }

    //todo
    public DocumentType getType() {
        return null;
    }
}
