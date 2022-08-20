package ds.datastructures.stack.problems;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static int[] stockSpan(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        res[0] = 1;
        for(int i = 1; i < arr.length; i++){
            int span = 0;
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            span += stack.isEmpty() ? i + 1 : i - stack.peek();
            res[i] = span;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {13, 15, 12, 14, 16, 8, 6, 4, 10, 30};
        System.out.println(Arrays.toString(stockSpan(arr)));
    }
}
