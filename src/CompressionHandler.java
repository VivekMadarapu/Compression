import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompressionHandler {

    private HashMap<Character, Integer> freq = new HashMap<>();
    public HuffmanTree tree;
    private File input;
    private File output;
    private File decOutput;
    private int compressSize;

    public CompressionHandler(String file) throws FileNotFoundException {
        input = new File(file);
        compressSize = 0;
        initFreq(file);
        tree = new HuffmanTree(freq);
    }

    public void initFreq(String file) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(file));
        reader.useDelimiter("");
        while(reader.hasNext()){
            Character o = reader.next().charAt(0);
            if(!freq.containsKey(o)){
                freq.put(o, 1);
            }
            else {
                freq.put(o, freq.get(o)+1);
            }
        }
        freq.put(null, 1);
    }

    public void compress() throws IOException {
        output = new File(input.getName() + ".viv");
        int version = 0;
        while (output.exists()) {
            version++;
            output = new File("(" + version + ") " + input.getName()+ ".viv");
        }
        //noinspection ResultOfMethodCallIgnored
        output.createNewFile();
        BitOutputStream bitOut = new BitOutputStream(output.getName());
        Scanner file = new Scanner(input);
        file.useDelimiter("");
        while(file.hasNext()){
            char nextChar = file.next().charAt(0);
            compressSize += tree.codes.get(nextChar).length();
            bitOut.writeBits(tree.codes.get(nextChar).length(), Integer.parseInt(tree.codes.get(nextChar), 2));
            bitOut.flush();
        }

    }

    public void decompress() throws IOException {
        File out = new File(output.getName() + ".decompressed.txt");
        int version = 0;
        while (out.exists()) {
            version++;
            out = new File("(" + version + ") " + output.getName() + ".decompressed.txt");
        }
        //noinspection ResultOfMethodCallIgnored
        out.createNewFile();
        BitInputStream bitIn = new BitInputStream(output);
        FileWriter writer = new FileWriter(out);
        Map<String, Character> swapped = new HashMap<>();
        for(Map.Entry<Character,String> entry : tree.codes.entrySet()) {
            swapped.put(entry.getValue(), entry.getKey());
        }
        String curCode = "";
        for (int i = 0; i < compressSize; i++){
            curCode += bitIn.readBits(1);
            if(tree.codes.containsValue(curCode)){
                writer.write(swapped.get(curCode));
                curCode = "";
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CompressionHandler brick = new CompressionHandler("dream.txt");
        brick.compress();
        brick.decompress();

    }

}
