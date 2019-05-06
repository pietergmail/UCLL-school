package domain.model;

public class LetterCounter {

    public LetterCounter(){

    }
    public int result(String letter, String Char){
        int total =  0;
        for(int i = 0; i < letter.length(); i++){
            if(letter.charAt(i) == Char.charAt(0)){
                total=total+1;
            }
        }
        return total;
    }

}
