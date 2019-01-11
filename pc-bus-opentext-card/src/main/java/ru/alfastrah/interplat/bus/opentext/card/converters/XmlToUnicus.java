package ru.alfastrah.interplat.bus.opentext.card.converters;

import org.apache.camel.Header;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import ru.alfastrah.interplat.bus.context.ProcessContext;
import ru.alfastrah.interplat.bus.opentext.card.entities.Context;
import ru.alfastrah.interplat.bus.opentext.card.entities.DocumentType;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.UnicusRequest;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.math.BigInteger;

import static ru.alfastrah.interplat.bus.opentext.card.converters.ContextConverter.createContext;

@Component
public class XmlToUnicus {


    public Context<UnicusRequest> convert(Document document, @Header("processContext") ProcessContext processContext) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        Integer count = (Integer) xPath.evaluate("", document, XPathConstants.NUMBER);
        Long integrationDocId = (Long) xPath.evaluate("", document, XPathConstants.NUMBER);
        String integrationTypeId = (String) xPath.evaluate("", document, XPathConstants.STRING);
        UnicusRequest request = new UnicusRequest(BigInteger.valueOf(integrationDocId), DocumentType.valueOf(integrationTypeId));
        return createContext(count, processContext.getProcessName(), processContext.getProcessId(), request);
    }
}
