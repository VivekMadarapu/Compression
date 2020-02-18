import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompressionHandler {

    private HashMap<Object, Integer> freq = new HashMap<>();
    public HuffmanTree tree;
    private File input;

    public CompressionHandler(String file) throws FileNotFoundException {
        input = new File(file);
        initFreq(file);
        tree = new HuffmanTree(freq);
    }

    public void initFreq(String file) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(file));
        reader.useDelimiter("");
        while(reader.hasNext()){
            Object o = reader.next();
            if(!freq.containsKey(o)){
                freq.put(o, 1);
            }
            else {
                freq.put(o, freq.get(o)+1);
            }
        }
        freq.put("end", 1);
    }

    public void compress() throws IOException {
        File out = new File(input.getName().substring(0, input.getName().length()-3) + "viv");
        createFile(out);
        BitOutputStream bitOut = new BitOutputStream(input.getName().substring(0, input.getName().length()-3) + "viv");
        for (Map.Entry<Object, String> objectStringEntry : tree.codes.entrySet()) {
            bitOut.writeBits(objectStringEntry.getValue().length(), Integer.parseInt(objectStringEntry.getValue(), 2));
        }

    }

    public void decompress() throws IOException {
        File out = new File(input.getName().substring(0, input.getName().length()-3) + "txt");
        createFile(out);
    }

    public void createFile(File file) throws IOException {
        int version = 0;
        while (file.exists()) {
            version++;
            file = new File("(" + version + ") " + input.getName());
        }
        //noinspection ResultOfMethodCallIgnored
        file.createNewFile();
    }

    public static void main(String[] args) throws IOException {
        CompressionHandler brick = new CompressionHandler("dream.txt");
        System.out.println(brick.tree.codes.toString());
    }

}
