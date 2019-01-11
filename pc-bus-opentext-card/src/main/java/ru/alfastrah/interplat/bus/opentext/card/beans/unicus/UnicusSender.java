package ru.alfastrah.interplat.bus.opentext.card.beans.unicus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alfastrah.interplat.bus.opentext.card.db.UnicusDLO;
import ru.alfastrah.interplat.bus.opentext.card.entities.DocumentType;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.UnicusRequest;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.UnicusResponse;

import static ru.alfastrah.interplat.bus.opentext.card.entities.DocumentType.*;

@Component
public class UnicusSender {
    @Autowired
    private UnicusDLO unicusDLO;

    public UnicusResponse execute(UnicusRequest request) throws Exception {
        UnicusResponse response = new UnicusResponse();
        DocumentType documentType = request.getDocumentType();
        if (ACT.equals(documentType)) {
            response.setAct(unicusDLO.getActById(request.getIntegrationDocId()));
        } else if (AGREEMENT.equals(documentType)) {
            response.setAgreement(unicusDLO.getAgreementById(request.getIntegrationDocId()));
        } else if (CONTRACT.equals(documentType)) {
            response.setContract(unicusDLO.getContractById(request.getIntegrationDocId()));
        }
        return response;
    }
}
