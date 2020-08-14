package domain;

public class Spiegeling implements CodeStrategy {

    public Spiegeling(){

    }
    @Override
    public String encode(String message) {
        String result = "";
        for(char x: message.toCharArray()) { //elke letter van de message
            result = x + result;
        }
        return result;
        }

    @Override
    public String decode(String message) {
        return encode(message);
    }
}
