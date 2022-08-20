package ds.datastructures.stack.problems;

import java.util.Arrays;
import java.util.Stack;

public class PreGreater {

    public static int[] previousGreater(int[] arr){
        int[] res = new int[arr.length];
        res[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for(int i = 1; i < arr.length; i++){
            int preGrater = -1;
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? preGrater : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }

    public static int[] nextGreater(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        res[n - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);

        for(int i = n - 2; i >=0; i--){
            int nextGreater = -1;
            while(!stack.isEmpty() && stack.peek() < arr[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? nextGreater : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args){

        int[] arr = {5, 15, 10, 8, 6, 12, 9, 18};
        System.out.println(Arrays.toString(nextGreater(arr)));
    }
}
