package domain;

import java.util.Random;

public class CeasarCode implements CodeStrategy{

    private int aantal_plaatsen;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public CeasarCode(int aantal_plaatsen){
        Random n = new Random();
        this.aantal_plaatsen = aantal_plaatsen;
    }

    @Override
    public String encode(String m) {
        m = m.toLowerCase();
        int index;
        String encoded="";
        for(char x: m.toCharArray()){ //elke letter van de message
            if(alphabet.contains(""+x)){
                index = alphabet.indexOf(x);                 //vindt index van letter van message in alphabet array
                if (index + aantal_plaatsen > 25){
                    index +=aantal_plaatsen -26;
                }else{
                    index += aantal_plaatsen;
                }
                encoded += alphabet.charAt(index);
            }else{
                encoded += " ";
            }
        }
        return encoded;
    }

    @Override
    public String decode(String m) {
        m = m.toLowerCase();
        int index;
        String encoded="";
        for(char x: m.toCharArray()){ //elke letter van de encoded
            if(alphabet.contains(""+x)){
                index = alphabet.indexOf(x) - aantal_plaatsen;                 //vindt index van letter van message in alphabet array
                if (index < 0){
                    index +=  26;
                }
                encoded += alphabet.charAt(index);
            }else{
                encoded += " ";
            }
        }
        return encoded;
    }

    @Override
    public String toString() {
        return "caesar";
    }
}
