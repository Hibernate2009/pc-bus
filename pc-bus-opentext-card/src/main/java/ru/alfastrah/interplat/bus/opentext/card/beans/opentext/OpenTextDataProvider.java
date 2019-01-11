package ru.alfastrah.interplat.bus.opentext.card.beans.opentext;

import com.opentext.livelink.service.otintegration.CardResponseType;
import org.springframework.beans.factory.annotation.Value;
import ru.alfastrah.interplat.bus.opentext.card.beans.DefaultExternalSystem;
import ru.alfastrah.interplat.bus.opentext.card.beans.SystemConfig;
import ru.alfastrah.interplat.bus.opentext.card.entities.Context;
import ru.alfastrah.interplat.bus.opentext.card.entities.opentext.OpentextRequest;

import java.lang.reflect.Type;

public class OpenTextDataProvider extends DefaultExternalSystem<OpentextRequest, CardResponseType> implements SystemConfig {

    @Value("${opentext.countLimit}")
    private Integer countLimit;
    @Value("${opentext.redeliveryDelay}")
    private Integer redeliveryDelay;
    @Value("${opentext.queueName}")
    private String queueName;


    @Override
    public Integer getCountLimit() {
        return countLimit;
    }

    @Override
    public Integer getRedeliveryDelay() {
        return redeliveryDelay;
    }

    @Override
    public String getQueueName() {
        return queueName;
    }

    @Override
    public CardResponseType send(Context<OpentextRequest> context) throws Exception {
        return null;
    }

    @Override
    public void onSuccess(CardResponseType message, Context<OpentextRequest> context) {

    }

    @Override
    public void onFailed(Context<OpentextRequest> context) {

    }

    @Override
    public void resend(Context<OpentextRequest> context) {

    }

    @Override
    public Type getContextType() {
        return null;
    }
}
