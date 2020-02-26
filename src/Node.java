public class Node implements Comparable{
    private Entry data;
    private Node parent;
    private Node left;
    private Node right;

    public Node() {
        data = null;
        left = null;
        right = null;
        parent = null;
    }

    public Node(Entry item) {
        data = item;
        left = null;
        right = null;
        parent = null;
    }

    public Node(Entry item, Node left, Node right) {
        data = item;
        left.setParent(this);
        this.left = left;
        right.setParent(this);
        this.right = right;
    }

    public Node(Node root) {
        data = root.getData();
        left = root.getLeft();
        right = root.getRight();
        parent = root.getParent();
    }

    public Entry getData() {
        return data;
    }

    public void setData(Entry item) { data = item; }

    public void setParent(Node p) { parent = p; }

    public Node getParent() { return parent; }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

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
        else if(((Node) o).data.frequency != data.frequency){
            return data.compareTo(((Node) o).data);
        }
        return 0;
    }

}