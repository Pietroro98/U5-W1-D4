package RomanoPietro.u5d4.repositorys;

import RomanoPietro.u5d4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PizzaRepository extends JpaRepository <Pizza, Long> {
    List<Pizza> findByName(String name);

    @Query("SELECT p FROM Pizza p WHERE p.price < :price")
    List<Pizza> findPizzasCheaperThan(@Param("price") double price);

}
