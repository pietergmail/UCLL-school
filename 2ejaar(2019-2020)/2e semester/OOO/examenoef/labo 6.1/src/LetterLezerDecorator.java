
public abstract class LetterLezerDecorator implements LetterLezer{
	private LetterLezer letterLezer;
	
	public LetterLezerDecorator(LetterLezer letterLezer){
		this.letterLezer = letterLezer;
	}
	
	public LetterLezer getLetterLezer(){
		return letterLezer;
	}

}
