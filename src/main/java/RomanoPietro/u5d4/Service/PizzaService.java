package RomanoPietro.u5d4.Service;


import RomanoPietro.u5d4.entities.Pizza;
import RomanoPietro.u5d4.repositorys.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> findByName(String name){
        return pizzaRepository.findByName(name);
    }





}
