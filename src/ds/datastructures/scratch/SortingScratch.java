package ds.datastructures.scratch;

import java.util.Arrays;

public class SortingScratch {

    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){
        if(arr == null || arr.length == 0)
            return;
        int min = 0;
        for(int i = 0; i < arr.length; i++){
            int currMin = i;int minVal = arr[i];
            for(int j = i; j < arr.length; j++){
                if(minVal > arr[j]) {
                    minVal = arr[j];
                    currMin = j;
                }
            }
            int temp = arr[min];
            arr[min++] = arr[currMin];
            arr[currMin] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){
        if(arr == null || arr.length == 0)
            return;
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int val = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > val){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = val;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] merge(int[] arr1, int[] arr2){
        if(arr1 == null && arr2 == null)
            return null;
        if(arr1 == null)
            return arr2;
        if(arr2 == null)
            return arr1;
        int n1 = arr1.length, n2 = arr2.length;
        int[] res = new int[n1+n2];
        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2){
            if(arr1[i] <= arr2[j]){
                res[k++] = arr1[i++];
            }else{
                res[k++] = arr2[j++];
            }
        }
        while(i < n1){
            res[k++] = arr1[i++];
        }
        while(j < n2){
            res[k++] = arr2[j++];
        }

        return res;
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int leftLen = mid - low + 1, rightLen = high - mid;
        int[] left = new int[leftLen];
        int[] right = new int[rightLen];

        System.arraycopy(arr, low , left, 0, leftLen);
        System.arraycopy(arr, mid + 1 , right, 0, rightLen);

        int i = 0, j = 0, k = low;
        while(i < leftLen && j < rightLen){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while(i < leftLen){
            arr[k++] = left[i++];
        }
        while(j < rightLen){
            arr[k++] = right[j++];
        }
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = low +((high - low)/2);
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void interSectionOfTwoSortedArr(int[] arr1, int[] arr2){
        int n1 = arr1.length, n2 = arr2.length;
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(i > 0 && arr1[i] == arr1[i - 1]){
                i++;
                continue;
            }
            if(arr1[i] < arr2[j]){
                i++;
            }else if(arr1[i] > arr2[j]){
                j++;
            }else{
                System.out.println(arr1[i]);
                i++; j++;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {2, 1, 3, 5, 4};
        int[] arr2 = {2, 3, 4, 8, 9};
        mergeSort(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }
}
