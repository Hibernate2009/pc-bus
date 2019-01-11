package ru.alfastrah.interplat.bus.opentext.card.converters;

import org.springframework.stereotype.Component;
import ru.alfastrah.interplat.bus.opentext.card.entities.Context;
import ru.alfastrah.interplat.bus.opentext.card.entities.opentext.OpentextRequest;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.UnicusRequest;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.UnicusResponse;

@Component
public class UnicusToOpentext {

    public Context<OpentextRequest> convert(UnicusResponse response, Context<UnicusRequest> context) {
        Context<OpentextRequest> opentextContext = new Context<>();
        return opentextContext;
    }
}
