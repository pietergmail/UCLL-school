package domain;

public class Radio implements player {
    private int frequency;

    public Radio(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String play() {
        return "radio plays at " + frequency;
    }
}
