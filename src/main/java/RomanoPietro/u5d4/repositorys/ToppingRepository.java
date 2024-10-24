package RomanoPietro.u5d4.repositorys;

import RomanoPietro.u5d4.entities.Toppings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ToppingRepository extends JpaRepository <Toppings, Long>{
    List<Toppings> findByName(String name);

}
