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

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {
        if(!o.getClass().equals(Node.class)){
            return -1;
        }
        if(((Node) o).data.frequency != data.frequency){
            return data.frequency - ((Node) o).data.frequency;
        }
        return 0;
    }

}