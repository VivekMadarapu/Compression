import java.util.*;

public class HuffmanTree {
    public PriorityQueue<Node> tree;
    public Map<Character, String> codes;
    public Map<String, Character> swappedCodes;
    public Map<Character, Integer> intCodes;
    public Map<Integer, Character> swappedIntCodes;

    public HuffmanTree(HashMap<Character, Integer> frequencies){
        tree = new PriorityQueue<>();
        codes = new HashMap<>();
        swappedCodes = new HashMap<>();
        intCodes = new HashMap<>();
        swappedIntCodes = new HashMap<>();
        for(Map.Entry<Character,Integer> entry : frequencies.entrySet()) {
            tree.add(new Node(entry.getKey(), entry.getValue()));
        }
        initTree();
        initCodes(tree.peek(), "", 0);
    }

    private void initTree() {
        while(tree.size() > 1){
            Node first = tree.poll();
            Node second = tree.poll();
            Node newNode = new Node('\0', first.frequency + second.frequency);
            newNode.setLeft(first);
            newNode.setRight(second);
            tree.add(newNode);
        }
    }

    public void initCodes(Node root, String str, int bit)
    {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            codes.put(root.data, str);
            swappedCodes.put(str, root.data);
            intCodes.put(root.data, bit);
            swappedIntCodes.put(bit, root.data);
        }
        int leftBit = bit << 1;
        int rightBit = (bit << 1) | 1;

        initCodes(root.left, str + "0", leftBit);
        initCodes(root.right, str + "1", rightBit);
    }

    public void printCodes(){
        for (Map.Entry<Character, String> c : codes.entrySet()) {
            if(c.getKey() == null){
                System.out.println("null | " + c.getValue());
            }
            else if(c.getKey().equals('\n')){
                System.out.println("\\n | " + c.getValue());
            }
            else if(c.getKey().equals('\r')){
                System.out.println("\\r | " + c.getValue());
            }
            else {
                System.out.println(c.getKey() + " | " + c.getValue());
            }
        }
    }

}
