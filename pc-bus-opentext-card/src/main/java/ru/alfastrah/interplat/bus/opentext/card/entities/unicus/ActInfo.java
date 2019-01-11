package ru.alfastrah.interplat.bus.opentext.card.entities.unicus;

import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class ActInfo {
    private String idRK;
    private String filial;
    private String executiveReportAct;
    private String contractNumber;
    private LocalDate contractDate;
    private BigInteger idAD;
    private String agentStatus;
    private String agentName;
    private String surname;
    private String name;
    private String patronymic;
    private BigInteger agentId;
    private String activityType;
    private String brokerLicenseNumber;
    private LocalDate brokerLicenseDate;
    private LocalDate birthDate;
    private String inn;
    private String ogrnip;
    private String taxTreatment;
    private String mediatorType;
    private String actNumber;
    private LocalDate actDate;
    private BigDecimal agentWithheldKV;
    private BigDecimal agentPayKV;
    private BigInteger idAct;
    private String urlDocument;
    private String status;
    private String idBarcode;
    private String signInsPhone;
    private String signAgentPhone;
    private byte[] printDoc;
    private String userEmail;
    private String versionID;
    private String supervisorDept;
    private String DocumentKind;
    private String agentEmail;
    private String insSignerEmail;
    private String channelSale;
    private String executiveEmail;

    private BigInteger digitSign;

    public String getIdRK() {
        return idRK;
    }

    public void setIdRK(String idRK) {
        this.idRK = idRK;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getExecutiveReportAct() {
        return executiveReportAct;
    }

    public void setExecutiveReportAct(String executiveReportAct) {
        this.executiveReportAct = executiveReportAct;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public BigInteger getIdAD() {
        return idAD;
    }

    public void setIdAD(BigInteger idAD) {
        this.idAD = idAD;
    }

    public String getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(String agentStatus) {
        this.agentStatus = agentStatus;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public BigInteger getAgentId() {
        return agentId;
    }

    public void setAgentId(BigInteger agentId) {
        this.agentId = agentId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getBrokerLicenseNumber() {
        return brokerLicenseNumber;
    }

    public void setBrokerLicenseNumber(String brokerLicenseNumber) {
        this.brokerLicenseNumber = brokerLicenseNumber;
    }

    public LocalDate getBrokerLicenseDate() {
        return brokerLicenseDate;
    }

    public void setBrokerLicenseDate(LocalDate brokerLicenseDate) {
        this.brokerLicenseDate = brokerLicenseDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrnip() {
        return ogrnip;
    }

    public void setOgrnip(String ogrnip) {
        this.ogrnip = ogrnip;
    }

    public String getTaxTreatment() {
        return taxTreatment;
    }

    public void setTaxTreatment(String taxTreatment) {
        this.taxTreatment = taxTreatment;
    }

    public String getMediatorType() {
        return mediatorType;
    }

    public void setMediatorType(String mediatorType) {
        this.mediatorType = mediatorType;
    }

    public String getActNumber() {
        return actNumber;
    }

    public void setActNumber(String actNumber) {
        this.actNumber = actNumber;
    }

    public LocalDate getActDate() {
        return actDate;
    }

    public void setActDate(LocalDate actDate) {
        this.actDate = actDate;
    }

    public BigDecimal getAgentWithheldKV() {
        return agentWithheldKV;
    }

    public void setAgentWithheldKV(BigDecimal agentWithheldKV) {
        this.agentWithheldKV = agentWithheldKV;
    }

    public BigDecimal getAgentPayKV() {
        return agentPayKV;
    }

    public void setAgentPayKV(BigDecimal agentPayKV) {
        this.agentPayKV = agentPayKV;
    }

    public BigInteger getIdAct() {
        return idAct;
    }

    public void setIdAct(BigInteger idAct) {
        this.idAct = idAct;
    }

    public String getUrlDocument() {
        return urlDocument;
    }

    public void setUrlDocument(String urlDocument) {
        this.urlDocument = urlDocument;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdBarcode() {
        return idBarcode;
    }

    public void setIdBarcode(String idBarcode) {
        this.idBarcode = idBarcode;
    }

    public String getSignInsPhone() {
        return signInsPhone;
    }

    public void setSignInsPhone(String signInsPhone) {
        this.signInsPhone = signInsPhone;
    }

    public String getSignAgentPhone() {
        return signAgentPhone;
    }

    public void setSignAgentPhone(String signAgentPhone) {
        this.signAgentPhone = signAgentPhone;
    }

    public byte[] getPrintDoc() {
        return printDoc;
    }

    public void setPrintDoc(byte[] printDoc) {
        this.printDoc = printDoc;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getVersionID() {
        return versionID;
    }

    public void setVersionID(String versionID) {
        this.versionID = versionID;
    }

    public String getSupervisorDept() {
        return supervisorDept;
    }

    public void setSupervisorDept(String supervisorDept) {
        this.supervisorDept = supervisorDept;
    }

    public String getDocumentKind() {
        return DocumentKind;
    }

    public void setDocumentKind(String documentKind) {
        DocumentKind = documentKind;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public String getInsSignerEmail() {
        return insSignerEmail;
    }

    public void setInsSignerEmail(String insSignerEmail) {
        this.insSignerEmail = insSignerEmail;
    }

    public String getChannelSale() {
        return channelSale;
    }

    public void setChannelSale(String channelSale) {
        this.channelSale = channelSale;
    }

    public String getExecutiveEmail() {
        return executiveEmail;
    }

    public void setExecutiveEmail(String executiveEmail) {
        this.executiveEmail = executiveEmail;
    }

    public BigInteger getDigitSign() {
        return digitSign;
    }

    public void setDigitSign(BigInteger digitSign) {
        this.digitSign = digitSign;
    }

    @Override
    public String toString() {
        return "ActInfo{" +
                "idRK='" + idRK + '\'' +
                ", filial='" + filial + '\'' +
                ", executiveReportAct='" + executiveReportAct + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", contractDate=" + contractDate +
                ", idAD=" + idAD +
                ", agentStatus='" + agentStatus + '\'' +
                ", agentName='" + agentName + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", agentId=" + agentId +
                ", activityType='" + activityType + '\'' +
                ", brokerLicenseNumber='" + brokerLicenseNumber + '\'' +
                ", brokerLicenseDate=" + brokerLicenseDate +
                ", birthDate=" + birthDate +
                ", inn='" + inn + '\'' +
                ", ogrnip='" + ogrnip + '\'' +
                ", taxTreatment='" + taxTreatment + '\'' +
                ", mediatorType='" + mediatorType + '\'' +
                ", actNumber='" + actNumber + '\'' +
                ", actDate=" + actDate +
                ", agentWithheldKV=" + agentWithheldKV +
                ", agentPayKV=" + agentPayKV +
                ", idAct=" + idAct +
                ", urlDocument='" + urlDocument + '\'' +
                ", status='" + status + '\'' +
                ", idBarcode='" + idBarcode + '\'' +
                ", signInsPhone='" + signInsPhone + '\'' +
                ", signAgentPhone='" + signAgentPhone + '\'' +
                ", printDoc=" + Arrays.toString(printDoc) +
                ", userEmail='" + userEmail + '\'' +
                ", versionID='" + versionID + '\'' +
                ", supervisorDept='" + supervisorDept + '\'' +
                ", DocumentKind='" + DocumentKind + '\'' +
                ", agentEmail='" + agentEmail + '\'' +
                ", insSignerEmail='" + insSignerEmail + '\'' +
                ", channelSale='" + channelSale + '\'' +
                ", executiveEmail='" + executiveEmail + '\'' +
                ", digitSign=" + digitSign +
                '}';
    }
}
