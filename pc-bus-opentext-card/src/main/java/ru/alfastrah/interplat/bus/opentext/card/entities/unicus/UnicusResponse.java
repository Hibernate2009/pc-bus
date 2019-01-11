package ru.alfastrah.interplat.bus.opentext.card.entities.unicus;

public class UnicusResponse {
    private Act act;
    private Agreement agreement;
    private Contract contract;

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
