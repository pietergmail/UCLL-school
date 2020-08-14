package domain;

public class Uitgeleend implements ProductState {
    private Product product;
    public Uitgeleend(Product p){
        this.product = p;
    }
    @Override
    public void uitlenen() {
        throw new DBException("Het product is al uitgeleend");
    }

    @Override
    public void verwijderen() {
        throw new DBException("Het product is uitgeleend");
    }

    @Override
    public void terugbrengen() {
        product.setState(product.getUitleendbaar());
    }

    @Override
    public void terugbrengenBeschadigd() {
        product.setState(product.getBeschadigd());
    }

    @Override
    public void herstellen() {
        throw new DBException("Het product is uitgeleend");
    }
    @Override
    public String toString() {
        return " uitgeleend";
    }
}
