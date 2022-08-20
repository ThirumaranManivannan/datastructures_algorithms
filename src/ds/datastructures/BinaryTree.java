package ds.datastructures;

import ds.datastructures.nodes.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    Node root = null;

    public void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }
    public void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }
    public void preOrder(Node node){
        if(node == null)
            return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void printKdistance(Node root, int k){
        if(root == null || k < 0)
            return;
        if(k == 0)
            System.out.println(root.data);
        else {
            printKdistance(root.left, k - 1);
            printKdistance(root.right, k - 1);
        }
    }
    Queue<Node> nodeQueue = new LinkedList<>();
    public void levelOrder(Node root){
        if(root == null)
            return;
        System.out.print(root.data);
        if(root.left != null)
            nodeQueue.add(root.left);
        if(root.right != null)
            nodeQueue.add(root.right);
        levelOrder(nodeQueue.poll());
    }

    public void levelOrderItr(Node root){
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.println(curr.data);
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }
    }

    public Integer size(Node root){
        if(root == null)
            return 0;
        return size(root.left) + size(root.right) + 1;
    }

    public Integer maxOfBT(Node root, Integer maxVal){
        if(root == null)
            return maxVal;
        if(root.data > maxVal)
            maxVal = root.data;
        return Math.max(maxOfBT(root.left, maxVal), maxOfBT(root.right, maxVal));
    }

    public Boolean chilSum(Node root){
        if(root == null)
            return true;
        if(root.left  == null && root.right == null)
            return true;
        int sum = 0;
        if(root.left != null)
            sum += root.left.data;
        if(root.right != null)
            sum += root.right.data;
        return ((root.data == sum) && chilSum(root.left) && chilSum(root.right));
    }

    public Integer height(Node root){
        if(root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public Boolean isBalancedWithHeight(Node root){
        if(root == null)
            return true;
        return height(root.left) - height(root.right) <= 1;
    }

    public Integer isBalanced(Node root){
        if(root == null)
            return 0;
        int lh = isBalanced(root.left);
        if(lh == -1)
            return -1;
        int rh = isBalanced(root.right);
        if(rh == -1)
            return -1;
        if(Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }

    public Integer maximumWidth(Node root){
        if(root == null)
            return 0;
        Queue<Node> levelQueue = new LinkedList<Node>();
        levelQueue.add(root);
        int width = 1;
        while(levelQueue.size() >= width){
            Node cur = root;
            if(cur.left != null)
                levelQueue.add(cur.left);
            if(cur.right != null)
                levelQueue.add(cur.right);
            width = levelQueue.size();
            levelQueue.poll();
        }
        return width;
    }

    int preOrder = 0;
    public Node cTree(int[] in, int[] pre, int is, int ie){
        if(is > ie)
            return null;
        Node root = new Node(pre[preOrder++]);
        int inIndex = 0;
        for(int i = is; i <= ie; i++){
            if(in[i] == root.data){
                inIndex = i;
                break;
            }
        }
        root.left = cTree(in, pre, is, inIndex);
        root.right = cTree(in, pre, inIndex + 1, ie);
        return root;
    }

    public void spiralOrder(Node root){
        if(root == null)
            return;
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.add(root);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                Node curr = s1.pop();
                System.out.println(curr.data + " ");
                if(curr.left != null)
                    s2.add(curr.left);
                if(curr.right != null)
                    s2.add(curr.right);
            }
            while(!s2.isEmpty()){
                Node curr = s2.pop();
                System.out.println(curr.data + " ");
                if(curr.right != null)
                    s1.add(curr.right);
                if(curr.left != null)
                    s1.add(curr.left);
            }
        }
    }


    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Node root = new Node(10);
        root.left = new Node(4);
        root.left.left = new Node(8);
        root.left.right = new Node(7);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(15);

        root.right = new Node(30);
        root.right.right = new Node(6);

        //view of tree
        /**
         *           10
         *          /   \
         *         4    30
         *        /   \     \
         *       8      7      6
         *             /  \
         *            9     15
         */
        bt.spiralOrder(root);

    }
}
