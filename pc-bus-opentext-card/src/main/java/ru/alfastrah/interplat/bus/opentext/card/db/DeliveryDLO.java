package ru.alfastrah.interplat.bus.opentext.card.db;

import org.joda.time.LocalDateTime;
import ru.alfastrah.interplat.bus.opentext.card.entities.Delivery;

import java.util.List;

public interface DeliveryDLO {
    List<Delivery> select(LocalDateTime time);

    void insert(Delivery delivery);

    void delete(String uuid);
}
