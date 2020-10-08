public class HoofdletterDecorator extends LetterLezerDecorator {
    private char vorigeLetter = ' ';

    public HoofdletterDecorator(LetterLezer letterLezer){
        super(letterLezer);
    }
    public char leesLetter() {
        char letter = getLetterLezer().leesLetter();
        if (vorigeLetter == ' '){
            letter = Character.toUpperCase(letter);
        }
        vorigeLetter = letter;
        return letter;
    }
}
