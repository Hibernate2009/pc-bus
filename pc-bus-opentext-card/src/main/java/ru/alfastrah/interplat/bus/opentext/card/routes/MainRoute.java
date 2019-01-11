package ru.alfastrah.interplat.bus.opentext.card.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alfastrah.interplat.bus.context.ProcessContextHandler;
import ru.alfastrah.interplat.bus.opentext.card.Constants;
import ru.alfastrah.interplat.bus.opentext.card.beans.unicus.UnicusDataProvider;
import ru.alfastrah.interplat.bus.opentext.card.converters.XmlToUnicus;

import static org.apache.camel.LoggingLevel.ERROR;
import static org.apache.camel.LoggingLevel.INFO;

public class MainRoute extends RouteBuilder {

    @Autowired
    private UnicusDataProvider unicusDataProvider;
    @Autowired
    private XmlToUnicus xmlToUnicus;
    @Autowired
    private ProcessContextHandler processContextHandler;


    @Override
    public void configure() throws Exception {
        onException(Exception.class)
                .handled(true)
                .transform().simple("${exception.stacktrace}")
                .log(ERROR, Constants.BODY);

        from("activemq:queue:xml_queue")
                .routeId("extractFromXmlQueueRoute")
                .bean(processContextHandler, "makeProcessContext(${properties:processName})")
                .bean(processContextHandler, "logStartProcess")
                .log(INFO, "before transform: " + Constants.BODY)
                .bean(xmlToUnicus, "convert")
                .bean(unicusDataProvider, "push")
//                .log(INFO, "after transform: " + Constants.BODY)
//                .bean(msSqlDLO, "insertContractData")
//                .bean(restClient, "sendResult('{\"result\":\"ok\"}')")
                .log(INFO, "after sendResult: " + Constants.BODY);
    }
}
