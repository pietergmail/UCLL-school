public class TekstLetterLezer implements LetterLezer{
	private String tekst;
	private int index = 0;
	
	public TekstLetterLezer(String tekst){
		this.tekst = tekst;
	}
	
	public char leesLetter(){
		if (index < tekst.length()){
			return tekst.charAt(index++);
		}
		return '*';
	}
		
	public static void main (String [] args){
		TekstLetterLezer fl = new TekstLetterLezer("abc def");
		char letter = fl.leesLetter();
		while (letter != '*'){
			System.out.println(letter);
			letter = fl.leesLetter();
		}	
	}
}	


