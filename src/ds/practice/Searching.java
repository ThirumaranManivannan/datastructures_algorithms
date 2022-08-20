package ds.practice;

import java.util.Arrays;

public class Searching {

    public static void main(String[] args){
        int[] arr1 = {10,20,30,40};
        int[] arr2 = {2,8,9,10,15};
        //System.out.println(findMedian(arr1, arr2));
        System.out.println(countInversion(arr1));
    }

    public static int[] merge(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] newArr = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]) {
                newArr[k] = arr1[i];
                i++;
            }
            else{
                newArr[k] = arr2[j];
                j++;
            }
            k++;
        }
        if (i < arr1.length){
            for(i = i; i< arr1.length; i++){
                newArr[k] = arr1[i];
                k++;
            }
        }
        if (j < arr2.length){
            for(j = j; j < arr2.length; j++){
                newArr[k] = arr2[j];
                k++;
            }
        }
        return newArr;
    }

    public static double findMedian(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int low = 0;
        int high = n1 - 1;
        while(low <= high){
            int midOfn1 = (low + high)/2;
            int midOfn2 = ((n1 + n2 + 1)/2) - midOfn1;
            if(arr1[midOfn1] >= arr2[midOfn2 - 1] && arr1[midOfn1 - 1] <= arr2[midOfn2]){
                System.out.println("found position");
                if((n1 + n2) % 2 == 0){
                    return Math.max(arr1[midOfn1], arr2[midOfn2 - 1]) + Math.min(arr1[midOfn1+ 1], arr2[midOfn2]);
                }else{
                    return Math.max(arr1[midOfn1], arr2[midOfn2 - 1]);
                }
            }
            if(arr1[midOfn1] < arr2[midOfn2 - 1] || arr1[midOfn1 - 1] > arr2[midOfn2]){
                low = midOfn1 + 1;
            }
            else{
                high = midOfn1 -1;
            }
        }
        return -1;
    }

    public static void findIntersection(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(arr1[i] == arr2[j]){
                if(i == 0 && j==0) {
                    System.out.println(arr1[i]);
                    i++; j++;
                }
                else if(arr1[i - 1] < arr1[i] || arr2[j - 1] < arr2[j]) {
                    System.out.println(arr1[i]);
                }
                i++;j++;
            }else if(arr1[i] > arr2[j]){
                j++;
            }else {
                i++;
            }
        }
    }

    public static void findUnion(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(arr1[i] == arr2[j]){
                i++;
                j++;
            }else if(arr1[i] > arr2[j]){
                System.out.println(arr2[j]);
                System.out.println(arr1[i]);
                j++;
            }else{
                System.out.println(arr1[i]);
                System.out.println(arr2[j]);
                i++;
            }
        }
        while(i < n1){
            System.out.println(arr1[i]);
            i++;
        }
        while(j < n2){
            System.out.println(arr2[j]);
            j++;
        }
    }

    public static int countInversion(int[] arr){
        int n = arr.length;
        int res = 0;
        int min = arr[0];
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] < max){
                res++;
            }
            if(arr[i] < min){
                res++;
                min = arr[i];
            }else if(arr[i] > max){
                max = arr[i];
            }
        }
        return res;
    }
}
