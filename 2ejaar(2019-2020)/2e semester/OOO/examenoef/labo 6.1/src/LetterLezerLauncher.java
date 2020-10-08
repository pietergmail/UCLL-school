
public class LetterLezerLauncher {

	public static void main(String[] args) {
		//LetterLezer fl = new HoofdletterDecorator(new TekstLetterLezer("abc def"));
		//LetterLezer fl = new HoofdletterDecorator(new SpatieWegDecorator(new TekstLetterLezer("abc def")));
		LetterLezer fl = new SpatiesTussenDecorator(new TekstLetterLezer("abc def"));
		char letter = fl.leesLetter();
		while (letter != '*'){
			System.out.print(letter);
			letter = fl.leesLetter();
		}	

	}

}
