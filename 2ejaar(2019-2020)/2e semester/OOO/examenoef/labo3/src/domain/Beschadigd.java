package domain;

public class Beschadigd implements ProductState {
    Product product;

    public Beschadigd(Product product){
        this.product = product;
    }
    @Override
    public void uitlenen() {
        throw new DBException("Het product is beschadigd, gelieven het eerst te herstellen");
    }

    @Override
    public void verwijderen() {
        product.setState(product.getVerwijderd());
    }

    @Override
    public void terugbrengen() {
        throw new DBException("Het product is terugbrengen maar is beschadigd.");

    }

    @Override
    public void terugbrengenBeschadigd() {
        throw new DBException("Het product is terugbrengen maar is beschadigd.");
    }

    @Override
    public void herstellen() {
        product.setState(product.getUitleendbaar());
    }

    @Override
    public String toString() {
        return " beschadigd";
    }
}
