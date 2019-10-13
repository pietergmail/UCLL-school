package domain;

import domain.Pizza;

public class Menu {
    Pizza pizza1;
    Pizza pizza2;
    Pizza pizza3;

    public Menu(Pizza pizza1, Pizza pizza2, Pizza pizza3) {
        setPizza1(pizza1);
        setPizza2(pizza2);
        setPizza3(pizza3);
    }

    public Pizza getPizza1() {
        return pizza1;
    }

    public void setPizza1(Pizza pizza1) {
        this.pizza1 = pizza1;
    }

    public Pizza getPizza2() {
        return pizza2;
    }

    public void setPizza2(Pizza pizza2) {
        this.pizza2 = pizza2;
    }

    public Pizza getPizza3() {
        return pizza3;
    }

    public void setPizza3(Pizza pizza3) {
        this.pizza3 = pizza3;
    }

    public String geefinfo(){
        return "Pizza1: " + pizza1.beschrijving + " ingredienten:" +pizza1.getIngredient1() + "\n"
        + "Pizza2: " + pizza2.beschrijving + " ingredienten:" +pizza2.getIngredient1() + "\n" +
        "Pizza3: " + pizza3.beschrijving + " ingredienten:" +pizza3.getIngredient1() + "\n";
    }
}
