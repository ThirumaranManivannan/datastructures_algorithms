package ds.datastructures.scratch;

import ds.datastructures.nodes.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeScratch {

    public static Integer height(Node root){
        if(root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void printKdistance(Node root, int k, List<Integer> result){
        if(root == null) {
            return;
        }
        if(k == 0){
            result.add(root.data);
            return;
        }
        printKdistance(root.left, k - 1, result);
        printKdistance(root.right, k -1, result);
    }

    public static void levelOrder(Node root){
        if(root == null)
            return;
        Queue<Node> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        while(!levelQueue.isEmpty()){
            Node curr = levelQueue.poll();
            System.out.print(curr.data + " ");
            if(curr.left != null)
                levelQueue.add(curr.left);
            if(curr.right != null)
                levelQueue.add(curr.right);
        }
    }

    public static void levelOrderLineByLine(Node root){
        if(root == null)
            return;
        Queue<Node> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        levelQueue.add(null);
        while(levelQueue.size() > 1){
            Node curr = levelQueue.poll();
            if(curr == null){
                System.out.println();
                levelQueue.add(null);
                continue;
            }
            System.out.print(curr.data + " ");
            if(curr.left != null)
                levelQueue.add(curr.left);
            if(curr.right != null)
                levelQueue.add(curr.right);
        }
    }

    public static void levelOrderLineByLine2(Node root){
        if(root == null)
            return;
        Queue<Node> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        while(!levelQueue.isEmpty()){
            int size = levelQueue.size();
            for(int i = 0; i < size; i++){
                Node curr = levelQueue.poll();
                System.out.print(curr.data + " ");
                if(curr.left != null)
                    levelQueue.add(curr.left);
                if(curr.right != null)
                    levelQueue.add(curr.right);
            }
            System.out.println();
        }
    }

    public static Integer size(Node root){
        if(root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public static Integer findMax(Node root){
        if(root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
    }

    static int maxLevel = -1;
    public static void leftViewOfBT(Node root, int level){
        if(root == null)
            return;
        if(maxLevel < level){
            maxLevel = level;
            System.out.print(root.data + " ");
        }
        leftViewOfBT(root.left, level + 1);
        leftViewOfBT(root.right, level + 1);
    }

    public static void leftViewOfBT(Node root){
        if(root == null)
            return;
        Queue<Node> levelQueue = new LinkedList<Node>();
        levelQueue.add(root);
        while(!levelQueue.isEmpty()){
            int size = levelQueue.size();
            System.out.print(levelQueue.peek().data + " ");
            for(int i = 0; i < size; i++){
                Node curr = levelQueue.poll();
                if(curr.left != null)
                    levelQueue.add(curr.left);
                if(curr.right != null)
                    levelQueue.add(curr.right);
            }
        }
    }

    public static boolean isChildSum(Node root){
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        int sum = 0;
        if(root.left != null)
            sum += root.left.data;
        if(root.right != null)
            sum += root.right.data;
        return root.data == sum && isChildSum(root.left) && isChildSum(root.right);
    }

    public static boolean isBalanced(Node root){
        if(root == null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.abs(lh - rh) + 1 <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int printKDisNode(Node root, Node target, int k, List<Integer> result){
        if(root == null)
            return -1;
        if(root == target){
            printKdistance(root, k, result);
            return 1;
        }
        int dLeft = printKDisNode(root.left, target, k, result);
        if(dLeft != -1){
            if(k == dLeft){
                result.add(root.data);
            }else{
                printKdistance(root.right, k - dLeft - 1, result);
            }
            return dLeft + 1;
        }
        int dRight = printKDisNode(root.right, target, k, result);
        if(dRight != -1){
            if(k == dRight){
                result.add(root.data);
            }else{
                printKdistance(root.left, k, result);
            }
            return dRight + 1;
        }

        return -1;
    }

    public static int printKleaf(Node root, int k, int step){
        if(root == null)
            return 0;
        int Llevel = 1 + printKleaf(root.left, k, step+1);
        if(step - Llevel == 0)
            System.out.println(root.data);
        int Rlevel = 1 + printKleaf(root.right, k, step+1);
        if(step - Rlevel == 0)
            System.out.println(root.data);
        return Math.min(Llevel, Rlevel);
    }

    public static int countNodesInCompleteTree(Node root){
        if(root == null)
            return 0;
        int lh = 0, rh = 0;
        Node curr = root;
        while(curr != null){
            lh++;
            curr = curr.left;
        }
        curr = root;
        while(curr != null){
            rh++;
            curr = curr.right;
        }
        if(lh == rh)
            return (int)Math.pow(2, lh) - 1;
        else
            return 1 + countNodesInCompleteTree(root.left) + countNodesInCompleteTree(root.right);
    }

    public static class Distance{
        int val;
        public Distance(int val){
            this.val = val;
        }
    }
    public static int res = 0;
    public static int burnTime(Node root, int leaf){
        Distance dist = new Distance(-1);
        burnTime(root, leaf, dist);
        return res;
    }
    public static int burnTime(Node root, int leaf, Distance dist){
        if(root == null)
            return 0;
        if(root.data == leaf){
            dist.val = 0;
            return 0;
        }
        Distance ldist = new Distance(-1); Distance rdist = new Distance(-1);
        int lh = burnTime(root.left, leaf, ldist);
        int rh = burnTime(root.right, leaf, rdist);

        if(ldist.val != -1){
            dist.val = ldist.val + 1;
            res = Math.max(res, dist.val + rh );
        }else if(rdist.val != -1){
            dist.val = rdist.val + 1;
            res = Math.max(res, dist.val + lh);
        }
        return Math.max(lh, rh) + 1;
    }

    public static List<Integer> serialize(Node root){
        List<Integer> serialisedList = new ArrayList<>();
        serialize(root, serialisedList);
        return serialisedList;
    }
    public static void serialize(Node root, List<Integer> serializedList){
        if(root == null){
            serializedList.add(-1);
            return;
        }
        serializedList.add(root.data);
        serialize(root.left, serializedList);
        serialize(root.right, serializedList);
    }
    static int preIndex = 0;
    public static Node deserialize(List<Integer> serialisedList){
        if(preIndex == serialisedList.size())
            return null;
        int val = serialisedList.get(preIndex);
        preIndex++;
        if(val == -1)
            return null;
        Node curr = new Node(val);
        curr.left = deserialize(serialisedList);
        curr.right = deserialize(serialisedList);
        return curr;
    }

    public static void test(){
        int j = 1, num1 = 4;
        while(++j <= 10){
            num1++;
        }
        System.out.println(num1);
    }


    public static void main(String[] args){

//        Node root = new Node(10);
//        root.left = new Node(4);
//        root.left.left = new Node(8);
//        root.left.right = new Node(7);
//        root.left.right.left = new Node(9);
//        root.left.right.right = new Node(15);
//
//        root.right = new Node(30);
//        root.right.right = new Node(6);
//
//        Node root1 = new Node(20);
//        root1.left = new Node(8);
//        root1.right = new Node(12);
//        root1.left.left = new Node(3);
//        root1.left.right = new Node(5);
//
//        //view of tree
//        /**
//         *           10
//         *          /   \
//         *         4    30
//         *        /   \     \
//         *       8      7      6
//         *             /  \
//         *            9     15
//         */
//        levelOrder(deserialize(serialize(root)));
        test();
    }
}
