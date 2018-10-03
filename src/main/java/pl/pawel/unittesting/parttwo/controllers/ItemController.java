package pl.pawel.unittesting.parttwo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.unittesting.parttwo.model.Item;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
