
public class SpatieWegDecorator extends LetterLezerDecorator {
	
	public SpatieWegDecorator(LetterLezer letterLezer){
		super(letterLezer);
	}
	
	public char leesLetter(){
		char letter = getLetterLezer().leesLetter();		
		while (letter == ' ' && letter!= '*'){
			letter =  getLetterLezer().leesLetter();
		}
		return letter;
	}
}
