import java.io.*;
import java.util.*;

public class ScannerExample{public staticvoidmain(String[] args)
{File file= new File("data.txt");
Map<String, String> map = new HashMap<>();
try{Scanner scanner= new Scanner(file);
    while(scanner.hasNextLine()) {String line = scanner.nextLine();
    Scanner lineScanner= new Scanner(line);lineScanner.useDelimiter("=");
    String key= lineScanner.next();String value= lineScanner.next();
    map.put(key, value);
    lineScanner.close();
    }scanner.close();
} catch (FileNotFoundExceptionex)
{thrownew DomainException("Fout bij wegschrijven", ex);}}}