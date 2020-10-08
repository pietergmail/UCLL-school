package domain;

public class Uitgeleend implements ProductState {

    private Product product;

    public Uitgeleend(Product p){this.product = p;}

    @Override
    public void uitlenen() throws DBException {
        throw new DBException("Het product is al uitgeleend");
    }

    @Override
    public void verwijderen() throws DBException {
        throw new DBException("Het product is al uitgeleend");
    }

    @Override
    public void terugbrengen() throws DBException {
        product.setState(product.getUitleenbaar());
    }

    @Override
    public void terugbrengenBeschadigd() throws DBException {
        product.setState(product.getBeschadigd());
    }

    @Override
    public void herstellen() throws DBException {
        throw new DBException("Het product is al uitgeleend");
    }

    @Override
    public String toString(){
        return " Uitgeleend.";
    }
}
