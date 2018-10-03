package pl.pawel.unittesting.parttwo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.pawel.unittesting.parttwo.model.Item;
import pl.pawel.unittesting.parttwo.repos.ItemRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void retrieveAllItems() {
        when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(2, "item2", 10, 10),
                new Item(3, "item3", 20,20)));
        List<Item> items = itemBusinessService.retrieveAllItems();
        assertEquals(100, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
    }
}