package pl.pawel.unittesting.parttwo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.unittesting.parttwo.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
