import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String menu = "1. Add product\n2. Show product\n3. Show rental price\n\n0. Quit";
        int choice = -1;
        Shop shop = new Shop();
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                shop.addProduct(JOptionPane.showInputDialog("Enter the title:"), JOptionPane.showInputDialog("Enter the id:"), JOptionPane.showInputDialog("Enter the type (M for movie/G for game):"));
            } else if (choice == 2) {
                ShowProduct(shop);
            } else if (choice == 3){
                showPrice(shop);
            }
        }
    }

    public static void ShowProduct(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");
        try{
            JOptionPane.showMessageDialog(null, shop.getProduct(id).getTitle());
        }catch(Exception e){
            throw new IllegalArgumentException("product niet gevonden.");
        }
    }

    public static void showPrice(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");
        String days = JOptionPane.showInputDialog("Enter the days:");
        try {
            JOptionPane.showMessageDialog(null, shop.getPrice(id, Integer.parseInt(days)));
        }catch(Error e){
            throw new IllegalArgumentException("product niet gevonden.");
        }
    }
}