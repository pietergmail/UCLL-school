package domain;

public interface ProductState {
    void uitlenen() throws DBException;
    void verwijderen() throws DBException;
    void terugbrengen() throws DBException;
    void terugbrengenBeschadigd() throws DBException;
    void herstellen() throws DBException;
}
