package ru.alfastrah.interplat.bus.opentext.card.db;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Repository;
import ru.alfastrah.interplat.bus.opentext.card.entities.Delivery;

import java.util.List;

@Repository
public class DeliveryDLOImpl implements DeliveryDLO {
    @Override
    public List<Delivery> select(LocalDateTime time) {
        return null;
    }

    @Override
    public void insert(Delivery delivery) {

    }

    @Override
    public void delete(String uuid) {

    }
}
