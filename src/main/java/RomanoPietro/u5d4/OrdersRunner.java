package RomanoPietro.u5d4;

import RomanoPietro.u5d4.Service.DrinkService;
import RomanoPietro.u5d4.Service.PizzaService;
import RomanoPietro.u5d4.entities.Drinks;
import RomanoPietro.u5d4.entities.Pizza;
import RomanoPietro.u5d4.entities.Toppings;
import RomanoPietro.u5d4.repositorys.DrinksRepository;
import RomanoPietro.u5d4.repositorys.PizzaRepository;
import RomanoPietro.u5d4.repositorys.ToppingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Slf4j
public class OrdersRunner implements CommandLineRunner {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private DrinksRepository drinksRepository;

    @Autowired
    private ToppingRepository toppingsRepository;

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private PizzaService pizzaService;

    @Override
    public void run(String... args) throws Exception {

        Toppings cheese = new Toppings("Cheese", 92, 0.69);
        Toppings ham = new Toppings("Ham", 35, 0.99);
        Toppings tomato = new Toppings("Tomato", 0, 0);
        Toppings pineapple = new Toppings("Pineapple", 24, 0.79);
        Toppings salame = new Toppings("Salame", 86, 0.99);

        toppingsRepository.save(cheese);
        toppingsRepository.save(ham);
        toppingsRepository.save(tomato);
        toppingsRepository.save(pineapple);
        toppingsRepository.save(salame);


        List<Toppings> margheritaToppings = List.of(tomato, cheese);
        Pizza margherita = new Pizza("Pizza_Margherita", 700, 6.0, margheritaToppings, false);

        List<Toppings> hawaiianToppings = List.of(tomato, cheese, ham, pineapple);
        Pizza hawaiian = new Pizza("Hawaiian Pizza",900, 7.0, hawaiianToppings, false);

        List<Toppings> salamiToppings = List.of(tomato, cheese, salame);
        Pizza salami = new Pizza("Salami Pizza",800, 7.0, salamiToppings, false);

        Pizza salamiXl = new Pizza("Salami Pizza XL",1100, 11.0, salamiToppings, true);

        pizzaRepository.save(margherita);
        pizzaRepository.save(hawaiian);
        pizzaRepository.save(salami);
        pizzaRepository.save(salamiXl);


        Drinks cola = new Drinks("CocaCola", 150, 2.50);
        Drinks water = new Drinks("Water", 0, 1.00);
        Drinks lemonade = new Drinks("Lemonade", 128, 1.00);
        Drinks beer = new Drinks("Beer", 43, 5.00);
        Drinks wine = new Drinks("Wine", 607, 7.49);

        drinksRepository.save(cola);
        drinksRepository.save(water);
        drinksRepository.save(lemonade);
        drinksRepository.save(beer);
        drinksRepository.save(wine);

        pizzaRepository.findAll().forEach(System.out::println);
        drinksRepository.findAll().forEach(System.out::println);
        toppingsRepository.findAll().forEach(System.out::println);


        List<Drinks> drinksByName = drinkService.findByName("CocaCola");
        drinksByName.forEach(drinks -> System.out.println("Drink trovato per nome: " + drinks.getName()));

        List<Drinks> drinksCheaperThan = drinkService.findDrinksCheaperThan(2.0);
        drinksCheaperThan.forEach(drinks -> System.out.println("Drink trovato per prezzo: " + drinks.getName()));

        List<Toppings> toppingsByName = toppingsRepository.findByName("Tomato");
        toppingsByName.forEach(toppings -> System.out.println("Topping trovato per nome: " + toppings.getName()));

        List<Pizza> pizzasByName = pizzaService.findByName("Pizza_Margherita");
        List<Pizza> pizzasCheaperThan = pizzaService.findPizzasCheaperThan(8.0);

        pizzasByName.forEach(pizza -> System.out.println("Pizza trovata per nome: " + pizza.getName()));
        pizzasCheaperThan.forEach(pizza -> System.out.println("Pizza trovata per prezzo: " + pizza.getName()));


    }
}
