import java.util.*;

public class HuffmanTree {
    public PriorityQueue<Node> tree;
    public HashMap<Object, String> codes;

    public HuffmanTree(HashMap<Object, Integer> frequencies){
        tree = new PriorityQueue<>();
        Set<Object> keys = frequencies.keySet();
        for (Object key : keys) {
            tree.add(new Node(new Entry(key, frequencies.get(key))));
        }
        while(tree.size() > 1){
            Node first = tree.poll();
            Node second = tree.poll();
            Node newNode =  new Node(new Entry(null, first.getData().frequency + second.getData().frequency));
            tree.add(newNode);
        }
        for (Object key : keys) {
            codes.put(key, findCode(new Entry(key, frequencies.get(key))));
        }

    }

    public String findCode(Object item){
        if (item == null) throw new NullPointerException("parameters cannot be null!");
        Queue<Node> nodes = new Queue<>(tree.peek());
        StringBuilder code = new StringBuilder();
        while (!nodes.isEmpty()) {
            if (nodes.peek().getData().equals(item))
                return code.toString();
            if (nodes.peek().getLeft() != null)
                code.append("0");
            nodes.add(nodes.peek().getLeft());
            if (nodes.peek().getRight() != null)
                code.append("1");
            nodes.add(nodes.peek().getRight());
            nodes.iterator().next();
        }
        throw new NullPointerException("item is not in the BinaryTree.");
    }

    public String getCode(Object o){
        return codes.get(o);
    }




}
