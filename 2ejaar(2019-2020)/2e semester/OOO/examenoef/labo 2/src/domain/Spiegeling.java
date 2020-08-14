package domain;

public class Spiegeling implements CodeStrategy {
    @Override
    public String encode(String m) {
        String result = "";
        for(char x: m.toCharArray()) { //elke letter van de message
            result = x + result;
        }
        return result;
    }

    @Override
    public String decode(String m) {
        return encode(m);
    }
}
