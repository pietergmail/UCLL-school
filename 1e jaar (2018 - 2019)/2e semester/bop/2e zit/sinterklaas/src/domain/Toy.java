package domain;

public class Toy {
    private String name;
    private int min_age;
    private int max_age;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getMin_age() {
        return min_age;
    }

    private void setMin_age(int min_age) {
        if (min_age < 0)
            throw new IllegalArgumentException("Leeftijd mag niet kleiner dan nul zijn");
        this.min_age = min_age;
    }

    public int getMax_age() {
        return max_age;
    }

    private void setMax_age(int max_age) {
        if (max_age < 0)
            throw new IllegalArgumentException("Leeftijd mag niet kleiner dan nul zijn");
        this.max_age = max_age;
    }

    public Toy(String name, int min_age, int max_age) {
        setMax_age(max_age);
        setMin_age(min_age);
        setName(name);
    }
}
