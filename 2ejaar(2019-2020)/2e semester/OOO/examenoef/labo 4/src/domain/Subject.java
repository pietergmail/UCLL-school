package domain;

public interface Subject {
    public void registerObserver(Events e,Observer o);
    public void removeObserver(Events e, Observer o);
    public void notifyObservers(Events e);
}
