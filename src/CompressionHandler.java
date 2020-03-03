import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompressionHandler {

    private HashMap<Character, Integer> freq = new HashMap<>();
    public HuffmanTree tree;
    public File input;
    public File output;
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
            Character c = reader.next().charAt(0);
            if(!freq.containsKey(c)){
                freq.put(c, 1);
            }
            else {
                freq.put(c, freq.get(c)+1);
            }
        }
        freq.put(null, 1);
    }

    public void compress() throws IOException {
        output = new File(input.getName() + ".viv");
        int version = 0;
        while (output.exists()) {
            version++;
            output = new File(input.getName() + "(" + version + ")"  + ".viv");
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
        }
        bitOut.writeBits(tree.codes.get(null).length(), Integer.parseInt(tree.codes.get(null), 2));
        bitOut.flush();
    }

    public void decompress() throws IOException {
        File out = new File(output.getName() + ".txt");
        int version = 0;
        while (out.exists()) {
            version++;
            out = new File(output.getName() + "(" + version + ")"  + ".txt");
        }
        //noinspection ResultOfMethodCallIgnored
        out.createNewFile();
        BitInputStream bitIn = new BitInputStream(output);
        BufferedWriter writer = new BufferedWriter(new FileWriter(out));
        String curCode = "";
        for (int i = 0; i < compressSize; i++){
            curCode += bitIn.readBits(1);
            if(tree.codes.containsValue(curCode)){
                if(tree.swappedCodes.get(curCode) == null){
                    break;
                }
                writer.write(tree.swappedCodes.get(curCode));
                curCode = "";
            }
        }
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        File[] files = new File("C:\\Users\\228800\\IdeaProjects\\Compression\\").listFiles();
        for (File file : files) {
            if(!file.getName().equals("Compression.iml") && !file.getName().equals(".git") && !file.getName().equals(".idea") && !file.getName().equals("out") && !file.getName().equals("src")){
                CompressionHandler brick = new CompressionHandler(file.getName());
                brick.compress();
                brick.decompress();
            }
        }



    }
}
