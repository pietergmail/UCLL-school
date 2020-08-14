package domain;

public class Product {
    private String name;
    private double price;

    private boolean isuitleenbaar = true;
    private boolean isuitgeleend = false;
    private boolean isbeschadigd = false;
    private boolean isverwijderd = false;

    private ProductState uitleenbaar;
    private ProductState uitgeleend;
    private ProductState beschadigd;
    private ProductState verwijderd;

    ProductState state;


    public Product(String name,double aanschafprijs){
        this.state = new Uitleenbaar();

        this.price = aanschafprijs;
        this.name = name;
    }
    public void setState(ProductState state) {
        this.state = state;
    }

    public void uitlenen() throws DBException {
        state.uitlenen();
    }

    public void verwijderen() throws DBException {
        state.verwijderen();
    }
    public void herstellen() throws DBException {
        state.herstellen();
    }
    public void terugbrengen() throws DBException {
        state.terugbrengen();
    }
    public void terugbrengenBeschadigd(){
        state.terugbrengenBeschadigd();
    }

    public void setUitleenbaar(ProductState uitleenbaar){
        this.uitleenbaar = uitleenbaar;
        isbeschadigd = false;
    }

    public ProductState getState(){
        return state;
    }
    public ProductState getBeschadigd(){
        return Beschadigd;
    }

    public ProductState getUitgeleend() {
        return Uitgeleend;
    }

    public ProductState getUitleendbaar() {
        return Uitleenbaar;
    }

    public ProductState getVerwijderd() {
        return Verwijderd;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product - name: " + this.name + "\n-price: €" + this.price + "\n-state: "+ this.getState().toString();
    }
}
