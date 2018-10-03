package pl.pawel.unittesting.parttwo.service;

import org.springframework.stereotype.Service;
import pl.pawel.unittesting.parttwo.model.Item;

@Service
public class ItemBusinessService {
    public Item retrieveHardcodedItem() {

        return new Item(1, "Ball", 10, 100);
    }
}
