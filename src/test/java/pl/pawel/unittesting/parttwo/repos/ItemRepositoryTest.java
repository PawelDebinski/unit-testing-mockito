package pl.pawel.unittesting.parttwo.repos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pawel.unittesting.parttwo.model.Item;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    // test jest tylko dla przykładu, ponieważ repo nie ma żadnych custom metod, więc nie ma potrzeby testowania go.
    // przenosimy data.sql do test/resources i odpalamy do testów h2
    @Test
    public void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }

}