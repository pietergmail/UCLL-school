import java.util.ArrayList;

public class Shop {

    private ArrayList<Product_old> products = new ArrayList<>();

    public Shop() {

    }

    public double getPrice(String productid, int days) {
        double price = 0;
        for (Product_old p: products) {
            if(p.getId().equals(productid)){
                price = p.getPrice(days);
                break;
            }
        }
        if(price == 0){
            throw new IllegalArgumentException("Id niet gevonden.");
        }else{
            return price;
        }
    }

    public void addProduct(String title, String id, String type){
        switch (type){
            case "M":
                Movie movie = new Movie(title, type, id);
                products.add(movie);
                break;
            case "G":
                Game game = new Game(title, type, id);
                break;
        }
    }

    public Product_old getProduct(String id){
        for(Product_old p: products){
            if (p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
}
