package ui;

import domain.DBException;
import domain.Product;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.util.ArrayList;

//JOptionPane.showInputDialog("")
public class ProductUI {
    ArrayList<Product> products;
    public ProductUI(Pane root){
        products = new ArrayList<>();
    }

    public ProductUI(){
        products = new ArrayList<>();
        showMenu();
    }
    public void showMenu(){
        String menu = "1. Add party item \n2.Remove party item\n3.Rent party item\n4.Return party item\n5.Repair party item\n6.Show available party items\n\n0. QUIT";
        String input = JOptionPane.showInputDialog(menu);

        switch (input){
            case "0":
                System.exit(0);
                break;
            case "1":
                addItem();
                break;
            case "2":
                removeItem();
                break;
            case "3":
                rentItem();
                break;
            case "4":
                returnItem();
                break;
            case "5":
                repair();
                break;
            case "6":
                showAll();
                break;
            default:
                showMenu();
                break;
        }
    }
    public void addItem(){
        String AskName = "Wat is de naam van uw product?";
        String AskPrice = "Wat is de prijs van uw product?";

        boolean gelukt = false;
        String name = JOptionPane.showInputDialog(AskName);
        double price = 0;
        while (!gelukt){
            try {
                price = Double.parseDouble(JOptionPane.showInputDialog(AskPrice));
                gelukt = true;
            }catch (NumberFormatException e){
                System.out.println("Ongeldig nummer");
            }
        }
        Product p = new Product(name,price);
        JOptionPane.showMessageDialog(null,p.getName() + " succesvol aangemaakt");

        products.add(p);
        showMenu();
    }
    public void removeItem(){
        String AskName = "Wat is de naam van het item?";
        String name = JOptionPane.showInputDialog(AskName);
        int index = findItem(name);
        if(index != -1){
            Product p = products.get(index);
            try {
                p.verwijderen();
                JOptionPane.showMessageDialog(null,name + " verwijderd");

            }catch (DBException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            showMenu();
        }else{
            JOptionPane.showMessageDialog(null,name + " niet gevonden");
            showMenu();
        }

    }
    public int findItem(String name){
        int index = -1;
        System.out.println(products);
        for(Product p : products){
            if (p.getName().equals(name)){index = products.indexOf(p);}
        }
        if(index != -1){
            return index;
        }else
            return -1;
    }
    public void rentItem(){
        String AskName = "Wat is de naam van het item?";
        String name = JOptionPane.showInputDialog(AskName);
        int index = findItem(name);
        if(index != -1) {
            Product p = products.get(index);
            try {
                p.uitlenen();
                JOptionPane.showMessageDialog(null,name + " wordt nu uitgeleend voor €"+p.getPrice()/5);
            } catch (DBException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            showMenu();
        }else{
            JOptionPane.showMessageDialog(null,name + " niet gevonden");
            showMenu();
        }
    }
    public void returnItem(){
        String AskName = "Wat is de naam van het item?";
        String name = JOptionPane.showInputDialog(AskName);
        int index = findItem(name);
        if(index != -1) {
            Product p = products.get(index);
            try {
                String Askdmg = "Is het product beschadigd?\n1. nee\n2.ja";
                String dmg = JOptionPane.showInputDialog(Askdmg);

                if (dmg.equals("1")){
                    p.terugbrengen();
                    JOptionPane.showMessageDialog(null,name + " wordt nu teruggebracht");

                }else if (dmg.equals("2")){
                    p.terugbrengenBeschadigd();
                    JOptionPane.showMessageDialog(null,name + " wordt nu teruggebracht. Schadenvergoeding: €" + p.getPrice()/3);
                }else{
                    JOptionPane.showMessageDialog(null,dmg + " was geen optie");
                    showMenu();
                }
            } catch (DBException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            showMenu();
        }else{
            JOptionPane.showMessageDialog(null,name + " niet gevonden");
            showMenu();
        }
    }
    public void repair(){
        String AskName = "Wat is de naam van het item?";
        String name = JOptionPane.showInputDialog(AskName);
        int index = findItem(name);
        if(index != -1) {
            Product p = products.get(index);
            try {
                p.herstellen();
                JOptionPane.showMessageDialog(null,name + " wordt nu hersteld");
            } catch (DBException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            showMenu();
        }else{
            JOptionPane.showMessageDialog(null,name + " niet gevonden");
            showMenu();
        }
    }
    public void showAll(){
        String result = "";
        for(Product p: products){
            result+=p+"\n";
        }
        JOptionPane.showMessageDialog(null,result);
        showMenu();
    }


}
