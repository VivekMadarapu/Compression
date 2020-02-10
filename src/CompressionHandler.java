import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CompressionHandler {

    private HashMap<Object, Integer> freq = new HashMap<>();

    public CompressionHandler(String file) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(file));
        reader.useDelimiter(".");
        while(reader.hasNext()){

        }
    }

}
