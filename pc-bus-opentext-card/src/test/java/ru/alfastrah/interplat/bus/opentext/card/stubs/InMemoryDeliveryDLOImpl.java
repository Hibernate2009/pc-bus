package ru.alfastrah.interplat.bus.opentext.card.stubs;

import org.joda.time.LocalDateTime;
import ru.alfastrah.interplat.bus.opentext.card.db.DeliveryDLO;
import ru.alfastrah.interplat.bus.opentext.card.entities.Delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryDeliveryDLOImpl implements DeliveryDLO {

    private Map<String, Delivery> inMemoryDb = new HashMap<>();

    @Override
    public List<Delivery> select(LocalDateTime time) {
        return new ArrayList<>(inMemoryDb.values())
                .stream()
                .filter(e -> time.compareTo(e.getTime()) > 0)
                .collect(Collectors.toList());
    }

    @Override
    public void insert(Delivery delivery) {
        inMemoryDb.put(delivery.getUuid(), delivery);
    }

    @Override
    public void delete(String uuid) {
        inMemoryDb.remove(uuid);
    }
}
