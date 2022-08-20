package ds.datastructures.stack.problems;

import java.util.Stack;

public class Histogram {

    public static int findArea(int[] arr){

        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){

            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int top = stack.pop();
                int curr = arr[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                res = Math.max(res, curr);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            int curr = arr[top] * (stack.isEmpty() ? arr.length : (arr.length - stack.peek() - 1));
            res = Math.max(res, curr);
        }
        return res;
    }

    public static int largestAreaBinaryArr(int[][] arr, int m, int n){
        int res = 0;
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != 0){
                    arr[i][j] = arr[i - 1][j] + arr[i][j];
                }
            }
            res = Math.max(res, findArea(arr[i]));
        }
        return res;
    }
    public static void main(String[] args){
        int[][] arr = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        System.out.println(largestAreaBinaryArr(arr,  4, 4));
    }
}
