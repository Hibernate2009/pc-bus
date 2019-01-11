package ru.alfastrah.interplat.bus.opentext.card.beans;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alfastrah.interplat.bus.opentext.card.db.DeliveryDLO;
import ru.alfastrah.interplat.bus.opentext.card.entities.Delivery;

import java.util.List;

@Component
public class DeliveryManager {

    @Autowired
    private DeliveryDLO deliveryDLO;

    @Produce
    private ProducerTemplate producerTemplate;


    public void invoke(Delivery delivery) {
        deliveryDLO.insert(delivery);
    }

    public void doTask() {
        // todo begin transaction
        List<Delivery> select = deliveryDLO.select(LocalDateTime.now());
        deleteSelectedRow(select);
        // todo end transaction
        for (Delivery delivery : select) {
            String queue = delivery.getQueue();
            String context = delivery.getContext();
            producerTemplate.sendBody(queue, context);

        }
    }

    private void deleteSelectedRow(List<Delivery> rows) {
        rows.forEach(e -> deliveryDLO.delete(e.getUuid()));
    }
}
