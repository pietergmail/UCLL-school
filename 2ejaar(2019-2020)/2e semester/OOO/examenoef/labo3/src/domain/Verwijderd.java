package domain;

public class Verwijderd implements ProductState {

    private Product product;

    public Verwijderd(Product p){this.product = p;}
    @Override
    public void uitlenen() throws DBException {
        throw new DBException("Het product is verwijderd.");
    }

    @Override
    public void verwijderen() throws DBException {
        throw new DBException("Product is al verwijderd.");
    }

    @Override
    public void terugbrengen() throws DBException {
        throw new DBException("Het product is verwijderd.");
    }

    @Override
    public void terugbrengenBeschadigd() throws DBException {
        throw new DBException("Het product is verwijderd.");
    }

    @Override
    public void herstellen() throws DBException {
        throw new DBException("Het product is verwijderd.");
    }

    @Override
    public String toString() {
        return " verwijderd";
    }
}
