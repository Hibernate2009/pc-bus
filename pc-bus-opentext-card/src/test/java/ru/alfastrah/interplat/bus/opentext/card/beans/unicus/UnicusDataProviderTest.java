package ru.alfastrah.interplat.bus.opentext.card.beans.unicus;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import ru.alfastrah.interplat.bus.opentext.card.beans.DeliveryManager;
import ru.alfastrah.interplat.bus.opentext.card.beans.EmailSender;
import ru.alfastrah.interplat.bus.opentext.card.beans.opentext.OpenTextDataProvider;
import ru.alfastrah.interplat.bus.opentext.card.converters.UnicusToOpentext;
import ru.alfastrah.interplat.bus.opentext.card.entities.Context;
import ru.alfastrah.interplat.bus.opentext.card.entities.Delivery;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.UnicusResponse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UnicusDataProviderTest {

    @InjectMocks
    private UnicusDataProvider unicusDataProvider = new UnicusDataProvider();
    @Mock
    private UnicusSender unicusSender;
    @Mock
    private DeliveryManager deliveryManager;
    @Mock
    private EmailSender emailSender;
    @Mock
    private OpenTextDataProvider openTextDataProvider;
    @Mock
    private UnicusToOpentext unicusToOpentext;
    private String message;
    @Captor
    private ArgumentCaptor<Delivery> captor;
    private String currentSystemQueue = "activemq:queue:unicus";

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(unicusDataProvider, "countLimit", 10);
        ReflectionTestUtils.setField(unicusDataProvider, "queueName", currentSystemQueue);
        ReflectionTestUtils.setField(unicusDataProvider, "redeliveryDelay", 0);
        message = IOUtils.toString(getClass().getResourceAsStream("/unicus/defaultContext.json"), "UTF-8");
        when(unicusSender.execute(any())).thenReturn(new UnicusResponse());
        when(openTextDataProvider.getQueueName()).thenReturn("activemq:queue:opentext");
        when(unicusToOpentext.convert(any(), any())).thenReturn(new Context<>());
    }

    @Test
    public void shouldBeSendMessageInNextSystem_whenCurrentSystemCallIsSuccess() throws Exception {
        unicusDataProvider.pull(message);
        verify(openTextDataProvider).push(any());
    }

    @Test
    public void shouldBeSendMessageInSameSystem_whenCurrentSystemCallIsFail() throws Exception {
        when(unicusSender.execute(any())).thenThrow(Exception.class);
        unicusDataProvider.pull(message);
        verify(deliveryManager).invoke(captor.capture());
        assertEquals(currentSystemQueue, captor.getValue().getQueue());
    }

    @Test
    public void shouldBeSendEmail_whenAttemptLimitIsExceeded() throws Exception {
        message = IOUtils.toString(getClass().getResourceAsStream("/unicus/contextWithTenAttempts.json"), "UTF-8");
        unicusDataProvider.pull(message);
        verify(emailSender).send(anyString());
    }
}