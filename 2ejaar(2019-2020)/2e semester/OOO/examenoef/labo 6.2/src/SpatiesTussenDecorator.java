public class SpatiesTussenDecorator extends LetterLezerDecorator {
    private char vorigeLetter = ' ';

    public SpatiesTussenDecorator(LetterLezer letterLezer){
        super(letterLezer);
    }

    public char leesLetter() {
        char letter = ' ';
        if (vorigeLetter == ' '){
            letter = getLetterLezer().leesLetter();
        }
        else {
            letter = ' ';
        }
        vorigeLetter = letter;
        return letter;
    }
}
