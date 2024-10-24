package RomanoPietro.u5d4.repositorys;

import RomanoPietro.u5d4.entities.Drinks;
import RomanoPietro.u5d4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinksRepository extends JpaRepository<Drinks, Long> {
    List<Drinks> findByName(String name);

}
