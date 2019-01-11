package ru.alfastrah.interplat.bus.opentext.card.entities.unicus;

import ru.alfastrah.interplat.bus.opentext.card.entities.DocumentType;

import java.math.BigInteger;
import java.util.Objects;

public class UnicusRequest {
    private BigInteger integrationDocId;
    private DocumentType documentType;


    public UnicusRequest(BigInteger integrationDocId, DocumentType documentType) {
        this.integrationDocId = integrationDocId;
        this.documentType = documentType;
    }

    public BigInteger getIntegrationDocId() {
        return integrationDocId;
    }

    public void setIntegrationDocId(BigInteger integrationDocId) {
        this.integrationDocId = integrationDocId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnicusRequest request = (UnicusRequest) o;
        return Objects.equals(integrationDocId, request.integrationDocId) &&
                documentType == request.documentType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(integrationDocId, documentType);
    }

    @Override
    public String toString() {
        return "UnicusRequest{" +
                "integrationDocId=" + integrationDocId +
                ", documentType=" + documentType +
                '}';
    }
}
