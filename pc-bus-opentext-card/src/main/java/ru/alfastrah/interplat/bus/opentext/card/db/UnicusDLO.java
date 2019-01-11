package ru.alfastrah.interplat.bus.opentext.card.db;

import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.Act;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.Agreement;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.Contract;

import java.math.BigInteger;

public interface UnicusDLO {
    Contract getContractById(BigInteger id);

    Agreement getAgreementById(BigInteger id);

    Act getActById(BigInteger id);
}
