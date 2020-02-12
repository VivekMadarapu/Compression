public class Node {
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

    public Node(Node copiedRoot) {
        data = copiedRoot.getData();
        left = copiedRoot.getLeft();
        right = copiedRoot.getRight();
        parent = copiedRoot.getParent();
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
}