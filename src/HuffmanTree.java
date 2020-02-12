import java.util.*;

public class HuffmanTree {
    public PriorityQueue<BinaryTree<Entry>> tree;

    public HuffmanTree(HashMap<Object, Integer> frequencies){
        tree = new PriorityQueue<>();
        Set<Object> keys = frequencies.keySet();
        for (Object key : keys) {
            tree.add(new BinaryTree(new Node<>(new Entry(key, frequencies.get(key)))));
        }
    }

    public class Entry
    {
        public Object data;
        public int frequency;

        public Entry(Object data, int frequency)
        {
            this.data = data;
            this.frequency = frequency;
        }
    }


}
