package domain;

public class Beschadigd implements ProductState {
    Product product;

    public Beschadigd(Product product){
        this.product = product;
    }

    @Override
    public void uitlenen() throws DBException {
        throw new DBException("Het product is beschadigd, gelieven het eerst te herstellen");
    }

    @Override
    public void verwijderen() throws DBException {
        product.setState(product.getVerwijderd());
    }

    @Override
    public void terugbrengen() throws DBException {
        throw new DBException("Het product is beschadigd, gelieven het eerst te herstellen");
    }

    @Override
    public void terugbrengenBeschadigd() throws DBException {
        throw new DBException("Het product is beschadigd, gelieven het eerst te herstellen");
    }

    @Override
    public void herstellen() throws DBException {
        product.setState(product.getUitleenbaar());
    }

    @Override
    public String toString(){
        return " beschadigd";
    }
}
