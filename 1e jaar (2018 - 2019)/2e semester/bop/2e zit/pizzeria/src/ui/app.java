package ui;

import domain.Pizza;
import domain.Menu;
public class app {

    public static void main(String[] args){
        Pizza margarita = new Pizza("de standaard pizza", "tomatesaus", "kaas", "gehakt", 8, false);
        Pizza Vegetarisch = new Pizza("de standaard vegetarische pizza", "tomatesaus", "kaas", "Vegetarisch gehakt", 10, true);
        Pizza vierkazen = new Pizza("de een pizza met veel kazen", "andere kaas", "kaas", "meer kaas", 8, false);

        Menu menu = new Menu(margarita, Vegetarisch, vierkazen);
        System.out.print(menu.geefinfo());
    }
}
