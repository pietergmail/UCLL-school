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

    public Product(String name, double aanschafprijs){
        this.state = new Uitleenbaar(this);

        this.price = aanschafprijs;
        this.name = name;
    }

    public void setState(ProductState state){
        this.state = state;
    }

    public void uitlenen() throws DBException {
        state.uitlenen();
    }

    public void verwijderen() throws DBException {state.verwijderen();}
    public void herstellen() throws DBException {state.herstellen();}
    public void terugbrengen() throws DBException {state.terugbrengen();}
    public void terugbrengenBeschadigd() throws DBException {state.terugbrengenBeschadigd();}

    public void setUitleenbaar(ProductState uitleenbaar){
        this.uitleenbaar = uitleenbaar;
        isbeschadigd = false;
    }

    public ProductState getUitleenbaar() {
        return uitleenbaar;
    }

    public ProductState getUitgeleend() {
        return uitgeleend;
    }

    public ProductState getBeschadigd() {
        return beschadigd;
    }

    public ProductState getVerwijderd() {
        return verwijderd;
    }

    public ProductState getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Product - name: " + this.name + "\n-price: €" + this.price + "\n-state: " + this.getState().toString();
    }
}
