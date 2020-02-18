import java.util.*;

public class HuffmanTree {
    public PriorityQueue<Node> tree;
    public Map<Object, String> codes;

    public HuffmanTree(HashMap<Object, Integer> frequencies){
        tree = new PriorityQueue<>();
        codes = new HashMap<>();
        Set<Object> keys = frequencies.keySet();
        for (Object key : keys) {
            tree.add(new Node(new Entry(key, frequencies.get(key))));
        }
        while(tree.size() > 1){
            Node first = tree.poll();
            Node second = tree.poll();
            Node newNode = new Node(new Entry('\0', first.getData().frequency + second.getData().frequency));
            newNode.setLeft(first);
            newNode.setRight(second);
            tree.add(newNode);
        }
        makeCodes(tree.peek(), "");
    }

    public void makeCodes(Node root, String str)
    {
        if (root == null)
            return;

        if (root.getLeft() == null && root.getRight() == null) {
            codes.put((root.getData()).data, str);
        }

        makeCodes(root.getLeft(), str + "0");
        makeCodes(root.getRight(), str + "1");
    }

    public String getCode(Object o){
        return codes.get(o);
    }

}
