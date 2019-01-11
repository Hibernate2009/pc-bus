package ru.alfastrah.interplat.bus.opentext.card.db;

import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.Act;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.Agreement;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.Contract;

import java.math.BigInteger;

public class UnicusDLOImpl implements UnicusDLO {
    @Override
    public Contract getContractById(BigInteger id) {
        return new Contract();
    }

    @Override
    public Agreement getAgreementById(BigInteger id) {
        return new Agreement();
    }

    @Override
    public Act getActById(BigInteger id) {
        return new Act();
    }
}
