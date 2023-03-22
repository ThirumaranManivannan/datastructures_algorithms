package probs;

import java.util.Map;

public class Numbers {

    public static void main(String[] args){
        System.out.println(factorial(6));
    }

    public static void countDigits(int x){
        int count = 0;
        while(x > 0){
            x = x/10;
            count++;
        }

        System.out.println("count of digits:"+ count);
    }

    public static void isPalindrome(int x){
        if(x/10 == 0) {
            System.out.println("single digit palindrome YES");
            return;
        }

        int reversedX = 0;
        int x1 = x;
        while(x1 > 0){
            if(reversedX == x1){
                System.out.println("YES inner");
                return;
            }
            reversedX = reversedX * 10 + x1 % 10;
            x1 = x1/10;
        }
        System.out.println("reversedX: " + reversedX);
        System.out.println(x == reversedX ? "YES" : "NO");
    }

    public static double factorial(int n){
        if(n == 1 || n == 0)
            return 1.0;
        return n * factorial(n - 1);
    }
}
