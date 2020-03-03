public class Node implements Comparable{
    public Character data;
    public int frequency;
    public Node parent;
    public Node left;
    public Node right;

    public Node(Character data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = null;
        right = null;
        parent = null;
    }

    public Node(Character data, int frequency, Node left, Node right) {
        this.data = data;
        this.frequency = frequency;
        left.setParent(this);
        this.left = left;
        right.setParent(this);
        this.right = right;
    }

    public Node(Node root) {
        data = root.data;
        frequency = root.frequency;
        left = root.left;
        right = root.right;
        parent = root.parent;
    }

    public void setData(Character item) { data = item; }

    public void setParent(Node p) { parent = p; }

    public void setLeft(Node item) {
        item.setParent(this);
        left = item;
    }

    public void setRight(Node item) {
        item.setParent(this);
        right = item;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null){
            throw new NullPointerException();
        }
        else if(!o.getClass().equals(Node.class)){
            throw new ClassCastException();
        }
        else if(((Node) o).frequency != frequency){
            return frequency - ((Node) o).frequency;
        }
        return 0;
    }

}