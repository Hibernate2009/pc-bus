package ru.alfastrah.interplat.bus.opentext.card.entities.unicus;

import org.joda.time.LocalDate;

import java.math.BigInteger;

public class Contract {
    private String externalURL;
    private String filial; //required
    private String salesChannel;
    private String curFirstName;//required
    private String curMiddleName;//required
    private String curLastName;
    private String curDepName;//required
    private String curParentDepName;//required
    private String acDep;
    private String agentType;//required
    private String firmName;
    private String firstName;
    private String middleName;
    private String lastName;
    private BigInteger subjectId;//required
    private String activityName;//required
    private String agentContractTypeCode;//required
    private String licenseNum;
    private LocalDate licenseDate;
    private LocalDate birthDate;
    private String inn;
    private String ogrn;
    private String agentContractNumber;//required
    private LocalDate signingDate;//required
    private String taxType;
    private String actFormTypeName;
    private String comments;
    private BigInteger firstACId;//required
    private BigInteger agentContractId;//required
    private BigInteger actualACCode;//required
    private String barcode;//required
    private BigInteger aspolisURL;//required
    private String actualStatus;//required
    private String executiveEmail;//required

    public String getExternalURL() {
        return externalURL;
    }

    public void setExternalURL(String externalURL) {
        this.externalURL = externalURL;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public String getCurFirstName() {
        return curFirstName;
    }

    public void setCurFirstName(String curFirstName) {
        this.curFirstName = curFirstName;
    }

    public String getCurMiddleName() {
        return curMiddleName;
    }

    public void setCurMiddleName(String curMiddleName) {
        this.curMiddleName = curMiddleName;
    }

    public String getCurLastName() {
        return curLastName;
    }

    public void setCurLastName(String curLastName) {
        this.curLastName = curLastName;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigInteger getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(BigInteger subjectId) {
        this.subjectId = subjectId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getAgentContractTypeCode() {
        return agentContractTypeCode;
    }

    public void setAgentContractTypeCode(String agentContractTypeCode) {
        this.agentContractTypeCode = agentContractTypeCode;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public LocalDate getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(LocalDate licenseDate) {
        this.licenseDate = licenseDate;
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

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getAgentContractNumber() {
        return agentContractNumber;
    }

    public void setAgentContractNumber(String agentContractNumber) {
        this.agentContractNumber = agentContractNumber;
    }

    public LocalDate getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(LocalDate signingDate) {
        this.signingDate = signingDate;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getActFormTypeName() {
        return actFormTypeName;
    }

    public void setActFormTypeName(String actFormTypeName) {
        this.actFormTypeName = actFormTypeName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigInteger getFirstACId() {
        return firstACId;
    }

    public void setFirstACId(BigInteger firstACId) {
        this.firstACId = firstACId;
    }

    public BigInteger getAgentContractId() {
        return agentContractId;
    }

    public void setAgentContractId(BigInteger agentContractId) {
        this.agentContractId = agentContractId;
    }

    public BigInteger getActualACCode() {
        return actualACCode;
    }

    public void setActualACCode(BigInteger actualACCode) {
        this.actualACCode = actualACCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigInteger getAspolisURL() {
        return aspolisURL;
    }

    public void setAspolisURL(BigInteger aspolisURL) {
        this.aspolisURL = aspolisURL;
    }

    public String getActualStatus() {
        return actualStatus;
    }

    public void setActualStatus(String actualStatus) {
        this.actualStatus = actualStatus;
    }

    public String getCurDepName() {
        return curDepName;
    }

    public void setCurDepName(String curDepName) {
        this.curDepName = curDepName;
    }

    public String getCurParentDepName() {
        return curParentDepName;
    }

    public void setCurParentDepName(String curParentDepName) {
        this.curParentDepName = curParentDepName;
    }

    public String getAcDep() {
        return acDep;
    }

    public void setAcDep(String acDep) {
        this.acDep = acDep;
    }

    public String getExecutiveEmail() {
        return executiveEmail;
    }

    public void setExecutiveEmail(String executiveEmail) {
        this.executiveEmail = executiveEmail;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "externalURL='" + externalURL + '\'' +
                ", filial='" + filial + '\'' +
                ", salesChannel='" + salesChannel + '\'' +
                ", curFirstName='" + curFirstName + '\'' +
                ", curMiddleName='" + curMiddleName + '\'' +
                ", curLastName='" + curLastName + '\'' +
                ", curDepName='" + curDepName + '\'' +
                ", curParentDepName='" + curParentDepName + '\'' +
                ", acDep='" + acDep + '\'' +
                ", agentType='" + agentType + '\'' +
                ", firmName='" + firmName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subjectId=" + subjectId +
                ", activityName='" + activityName + '\'' +
                ", agentContractTypeCode='" + agentContractTypeCode + '\'' +
                ", licenseNum='" + licenseNum + '\'' +
                ", licenseDate=" + licenseDate +
                ", birthDate=" + birthDate +
                ", inn='" + inn + '\'' +
                ", ogrn='" + ogrn + '\'' +
                ", agentContractNumber='" + agentContractNumber + '\'' +
                ", signingDate=" + signingDate +
                ", taxType='" + taxType + '\'' +
                ", actFormTypeName='" + actFormTypeName + '\'' +
                ", comments='" + comments + '\'' +
                ", firstACId=" + firstACId +
                ", agentContractId=" + agentContractId +
                ", actualACCode=" + actualACCode +
                ", barcode='" + barcode + '\'' +
                ", aspolisURL=" + aspolisURL +
                ", actualStatus='" + actualStatus + '\'' +
                ", executiveEmail='" + executiveEmail + '\'' +
                '}';
    }
}
