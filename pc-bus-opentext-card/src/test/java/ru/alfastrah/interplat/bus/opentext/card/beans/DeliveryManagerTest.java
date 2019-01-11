package ru.alfastrah.interplat.bus.opentext.card.beans;

import org.apache.camel.ProducerTemplate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import ru.alfastrah.interplat.bus.opentext.card.db.DeliveryDLO;
import ru.alfastrah.interplat.bus.opentext.card.entities.Delivery;
import ru.alfastrah.interplat.bus.opentext.card.stubs.InMemoryDeliveryDLOImpl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class DeliveryManagerTest {
    @InjectMocks
    private DeliveryManager deliveryManager = new DeliveryManager();
    @Mock
    private ProducerTemplate producerTemplate;
    @Spy
    private DeliveryDLO deliveryDLO = new InMemoryDeliveryDLOImpl();
    private String UUID = "ad3a440c-070c-460e-bd92-fdfbde4d3245";
    private String mockTimeValue = "2018-12-12 15:00:00";
    private String currentMockTimeValue = "2018-12-12 16:00:00";
    private LocalDateTime mockTime;
    private LocalDateTime currentMockTime;

    @Before
    public void init() {
        mockTime = LocalDateTime.parse(mockTimeValue, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
        currentMockTime = LocalDateTime.parse(currentMockTimeValue, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void shouldBeInsertInDb_whenCallInvoke() {
        Delivery delivery = new Delivery(UUID, "activemq:queue:main", "context", mockTime);
        deliveryManager.invoke(delivery);
        assertTrue(deliveryDLO.select(currentMockTime).contains(delivery));
    }

    @Test
    public void shouldBeSendMessage_whenExecuteTask() {
        insertDLO();
        deliveryManager.doTask();
        verify(producerTemplate).sendBody(anyString(), anyString());
    }

    @Test
    public void shouldBeDeleteDelivery_whenExecuteTaskAndDLOIsNotEmpty() {
        insertDLO();
        deliveryManager.doTask();
        assertTrue(deliveryDLO.select(currentMockTime).isEmpty());
    }

    private void insertDLO() {
        deliveryDLO.insert(new Delivery(UUID, "activemq:queue:main", "context", mockTime));
    }
}