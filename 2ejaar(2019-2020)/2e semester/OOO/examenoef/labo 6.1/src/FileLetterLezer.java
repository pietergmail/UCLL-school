import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLetterLezer implements LetterLezer{
	private String tekst;
	private int index = 0;
	
	public FileLetterLezer(String fileNaam){
		try{
			Scanner scanner = new Scanner(new File(fileNaam));
			tekst = scanner.nextLine();
		}
		catch (FileNotFoundException e){
			tekst= "??";			
		}
	}
	
	public char leesLetter(){
		if (index < tekst.length()){
			return tekst.charAt(index++);
		}
		return '*';
	}
	
	public static void main (String [] args){
		FileLetterLezer fl = new FileLetterLezer("letters.txt");
		char letter = fl.leesLetter();
		while (letter != '*'){
			System.out.println(letter);
			letter = fl.leesLetter();
		}	
	}
}	
		
