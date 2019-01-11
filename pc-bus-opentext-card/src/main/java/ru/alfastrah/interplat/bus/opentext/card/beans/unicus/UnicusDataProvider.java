package ru.alfastrah.interplat.bus.opentext.card.beans.unicus;

import org.apache.camel.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.alfastrah.interplat.bus.opentext.card.beans.DefaultExternalSystem;
import ru.alfastrah.interplat.bus.opentext.card.beans.EmailSender;
import ru.alfastrah.interplat.bus.opentext.card.beans.SystemConfig;
import ru.alfastrah.interplat.bus.opentext.card.beans.opentext.OpenTextDataProvider;
import ru.alfastrah.interplat.bus.opentext.card.converters.UnicusToOpentext;
import ru.alfastrah.interplat.bus.opentext.card.entities.Context;
import ru.alfastrah.interplat.bus.opentext.card.entities.opentext.OpentextRequest;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.UnicusRequest;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.UnicusResponse;

import java.lang.reflect.Type;

import static ru.alfastrah.interplat.bus.opentext.card.converters.ContextConverter.createJson;
import static ru.alfastrah.interplat.bus.opentext.card.converters.ContextConverter.type;

@Component
public class UnicusDataProvider extends DefaultExternalSystem<UnicusRequest, UnicusResponse> implements SystemConfig {

    @Value("${unicus.countLimit}")
    private Integer countLimit;
    @Value("${unicus.redeliveryDelay}")
    private Integer redeliveryDelay;
    @Value("${unicus.queueName}")
    private String queueName;
    @Autowired
    private UnicusSender unicusSender;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private OpenTextDataProvider openTextDataProvider;
    @Autowired
    private UnicusToOpentext unicusToOpentext;

    @Consume(uri = "${queueName.unicus}")
    public void pull(String message) {
        super.pull(message);
    }

    @Override
    public UnicusResponse send(Context<UnicusRequest> context) throws Exception {
        UnicusRequest request = context.getObject();
        return unicusSender.execute(request);
    }

    @Override
    public void onSuccess(UnicusResponse response, Context<UnicusRequest> context) {
        Context<OpentextRequest> opentextContext = unicusToOpentext.convert(response, context);
        String message = createJson(opentextContext);
        openTextDataProvider.push(message);
    }

    @Override
    public void onFailed(Context<UnicusRequest> context) {
        String message = createJson(context);
        emailSender.send(message);
    }

    @Override
    public Type getContextType() {
        return type(Context.class, UnicusRequest.class);
    }

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
}
