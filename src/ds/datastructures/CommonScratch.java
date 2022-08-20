package ds.datastructures;

import java.util.concurrent.atomic.AtomicInteger;

public class CommonScratch {

    public static int naturalNumSum(int n){
        if(n == 1)
            return 1;
        return n + naturalNumSum(n - 1);
    }

    public static boolean isPalindrome(String s, int start, int end){
        if(start >= end)
            return true;
        if(s.charAt(start) == s.charAt(end))
            return isPalindrome(s, start+1, end - 1);
        else
            return false;
    }

    public static int sumOfDigits(int n){
        if(n % 10 == n)
            return n;
        return n % 10 + sumOfDigits(n / 10);
    }

    public static int ropeCutting(int n, int a, int b, int c){
        AtomicInteger res = new AtomicInteger(-1);
        ropeCutting(n, a, b, c, 0, res);
        return res.get();
    }

    public static void ropeCutting(int n, int a, int b, int c, int len, AtomicInteger res){

        if(n == 0) {
            res.set(Math.max(res.get(), len));
            return;
        }
        if(n < 0)
            return;

        ropeCutting(n - a, a, b, c, len + 1, res);
        ropeCutting(n - b, a, b, c, len + 1, res);
        ropeCutting(n - c, a, b, c, len + 1, res);

    }
    public static void main(String[] args){
        System.out.println(ropeCutting(5, 2, 5, 1));
    }
}
