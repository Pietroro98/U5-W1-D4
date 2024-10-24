package RomanoPietro.u5d4.Service;


import RomanoPietro.u5d4.entities.Toppings;
import RomanoPietro.u5d4.repositorys.ToppingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;

    public List<Toppings> findByName(String name) {
        return toppingRepository.findByName(name);
    }
}