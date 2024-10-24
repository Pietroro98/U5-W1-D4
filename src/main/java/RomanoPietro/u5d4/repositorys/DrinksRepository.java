package RomanoPietro.u5d4.repositorys;

import RomanoPietro.u5d4.entities.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DrinksRepository extends JpaRepository<Drinks, Long> {
    List<Drinks> findByName(String name);

    @Query("SELECT d FROM Drinks d WHERE d.price < :price")
    List<Drinks> findDrinksCheaperThan(@Param("price") double price);
}
