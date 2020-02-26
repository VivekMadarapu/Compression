import java.util.*;

public class HuffmanTree {
    public PriorityQueue<Node> tree;
    public Map<Character, String> codes;
    public Map<Character, Integer> intCodes;

    public HuffmanTree(HashMap<Character, Integer> frequencies){
        tree = new PriorityQueue<>();
        codes = new HashMap<>();
        intCodes = new HashMap<>();
        Set<Character> keys = frequencies.keySet();
        for (Character key : keys) {
            tree.add(new Node(new Entry(key, frequencies.get(key))));
        }
        makeTree();
        makeCodes(tree.peek(), "", 0);
    }

    private void makeTree() {
        while(tree.size() > 1){
            Node first = tree.poll();
            Node second = tree.poll();
            Node newNode = new Node(new Entry('\0', first.getData().frequency + second.getData().frequency));
            newNode.setLeft(first);
            newNode.setRight(second);
            tree.add(newNode);
        }
    }

    public void makeCodes(Node root, String str, int bit)
    {
        if (root == null) {
            return;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            codes.put(root.getData().data, str);
            intCodes.put(root.getData().data, bit);
        }
        int leftBit = bit << 1;
        int rightBit = (bit << 1) | 1;

        makeCodes(root.getLeft(), str + "0", leftBit);
        makeCodes(root.getRight(), str + "1", rightBit);
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
