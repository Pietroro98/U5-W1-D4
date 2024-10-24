package RomanoPietro.u5d4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Pizza extends FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany
    private List<Toppings> toppingList;
    private boolean isXl = false;

  public Pizza (String name, int calories, double price, List<Toppings> toppingList, boolean isXl) {
      super(calories, price);
        this.name = name;
        this.toppingList = toppingList;
        this.isXl = isXl;
  }


    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isXl=" + isXl +
                '}';
    }
}