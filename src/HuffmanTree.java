import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class HuffmanTree {
    public Heap heap;
    public int size;
    private int maxsize;

    public void huffHeapify(PriorityQueue<Integer> freq, HashMap<Integer, Character> data){
        heap = new int[data.size()];
        while(freq.size() > 1){
            int min = freq.poll();
            if(freq.size() > 0){
                int min2 = freq.poll();
            }
            freq.add()
        }

    }


}
