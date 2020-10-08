public class LetterLezerLauncher {

    public static void main(String[] args){
        LetterLezer f1 = new SpatiesTussenDecorator(new TekstLetterLezer("abc def"));
        char letter =f1.leesLetter();
        while (letter != '*'){
            System.out.println(letter);
            letter = f1.leesLetter();
        }
    }
}
