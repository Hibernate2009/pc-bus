package ru.alfastrah.interplat.bus.opentext.card.converters;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import ru.alfastrah.interplat.bus.opentext.card.entities.Context;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.UnicusRequest;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static ru.alfastrah.interplat.bus.opentext.card.converters.ContextConverter.*;
import static ru.alfastrah.interplat.bus.opentext.card.entities.DocumentType.ACT;

public class ContextConverterTest {
    private static final String PROCESS_NAME = "processName";
    private static final String PROCCESS_ID = "processId";

    @Test
    public void shouldReturnContext_whenExistsParams() throws IOException {
        String expected = IOUtils.toString(getClass().getResourceAsStream("/unicus/defaultContext.json"), "UTF-8");
        Context<UnicusRequest> context = createContext(1, PROCESS_NAME, PROCCESS_ID, new UnicusRequest(BigInteger.TEN, ACT));
        assertEquals(expected, createJson(context));
    }

    @Test
    public void shouldReturnContextType_whenInputContextIsString() throws IOException {
        String value = IOUtils.toString(getClass().getResourceAsStream("/unicus/defaultContext.json"), "UTF-8");
        UnicusRequest request = new UnicusRequest(BigInteger.TEN, ACT);
        Context<UnicusRequest> expected = new Context<>(request, 1, PROCESS_NAME, PROCCESS_ID);
        Context<UnicusRequest> actual = extractContext(value, type(Context.class, UnicusRequest.class));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnExpectedType_whenInputMessageIsString() throws IOException {
        String request = IOUtils.toString(getClass().getResourceAsStream("/unicus/request.json"), "UTF-8");
        UnicusRequest expected = new UnicusRequest(BigInteger.TEN, ACT);
        assertEquals(expected, extractRequest(request, UnicusRequest.class));
    }
}