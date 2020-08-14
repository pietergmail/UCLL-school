package model;

public interface Observer {
    void update(int[] e, int nummer, Observer o, int total);
}
