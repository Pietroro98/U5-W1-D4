package RomanoPietro.u5d4.Service;

import RomanoPietro.u5d4.entities.Drinks;
import RomanoPietro.u5d4.entities.Pizza;
import RomanoPietro.u5d4.repositorys.DrinksRepository;
import RomanoPietro.u5d4.repositorys.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DrinkService {
    @Autowired
    private DrinksRepository drinkRepository;

    public List<Drinks> findByName(String name){
        return drinkRepository.findByName(name);
    }
}
