package ru.alfastrah.interplat.bus.opentext.card.beans.opentext;

import com.opentext.livelink.service.otintegration.ADService;
import com.opentext.livelink.service.otintegration.CardResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alfastrah.interplat.bus.opentext.card.entities.DocumentType;
import ru.alfastrah.interplat.bus.opentext.card.entities.opentext.OpentextRequest;

import static ru.alfastrah.interplat.bus.opentext.card.entities.DocumentType.*;

@Component
public class OpentextSender {

    @Autowired
    private ADService adService;

    public CardResponseType send(OpentextRequest request) throws Exception {
        CardResponseType response = null;
        DocumentType type = request.getType();
        if (ACT.equals(type)) {
            response = adService.updateAD(request.getCardADType());
        } else if (AGREEMENT.equals(type)) {
            response = adService.updateDS(request.getCardDSType());
        } else if (CONTRACT.equals(type)) {
            response = adService.updateReportAct(request.getCardReportActType());
        }
        return response;
    }
}
