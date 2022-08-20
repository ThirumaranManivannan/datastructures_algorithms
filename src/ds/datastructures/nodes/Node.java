package ds.datastructures.nodes;

public class Node {
    public int data;
    public Node left, right;
    public Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
