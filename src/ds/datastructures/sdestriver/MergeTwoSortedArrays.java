package ds.datastructures.sdestriver;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args){
        int[] arr1 = {1,4,8,10}, arr2 = {2,3,9};
        mergeTwoSortedArrays2(arr1, arr2);
        System.out.println(Arrays.toString(arr1) + " " + Arrays.toString(arr2));
    }

    //O(n + m) + O((m + n) Log (m + n)) + O(m + n)
    public static void mergeTwoSortedArrays(int[] arr1, int[] arr2){

        int m = arr1.length, n = arr2.length, k = 0;
        int[] res = new int[m + n];
        for (int j : arr1) res[k++] = j;
        for (int j : arr2) res[k++] = j;
        Arrays.sort(res);
        k = 0;
        for(int i = 0; i < m; i++) arr1[i] = res[k++];
        for(int i = 0; i < n; i++) arr2[i] = res[k++];
    }

    //O(m * n)
    public static void mergeTwoSortedArrays1(int[] arr1, int[] arr2){

        int m = arr1.length, n = arr2.length, i = 0;
        while(i < m){
            if(arr1[i] > arr2[0]){
                int temp = arr2[0];
                arr2[0] = arr1[i];
                arr1[i] = temp;

                for(int k = 1; k < n; k++){
                    if(arr2[k - 1] > arr2[k]){
                        int temp1 = arr2[k - 1];
                        arr2[k - 1] = arr2[k];
                        arr2[k] = temp1;
                    }
                }
            }
            i++;
        }
    }

    public static void swap(int indx1, int indx2){
        int temp = indx1;
        indx1 = indx2;
        indx2 = temp;
    }

    public static void mergeTwoSortedArrays2(int[] arr1, int[] arr2){
        int m = arr1.length, n = arr2.length;
        int gap = (int) Math.ceil((m + n) / 2.0);
        while(gap > 0){
            int i = 0;
            int j = gap;
            while(j < m + n) {
                if (i < m && j < m && arr1[i] > arr1[j]) {
                   int temp = arr1[i];
                   arr1[i] = arr1[j];
                   arr1[j] = temp;
                }
                else if (i < m && j >= m && arr1[i] > arr2[j - m]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j - m];
                    arr2[j - m] = temp;
                }
                else if(i >= m && j >= m && arr2[i - m] > arr2[j - m]) {
                    int temp = arr2[i - m];
                    arr2[i - m] = arr2[j - m];
                    arr2[j - m] = temp;
                }
                i++;
                j++;
            }
            if(gap == 1) {
                gap = 0;
            }
            else {
                gap = (int)Math.ceil((double) gap/2.0);
            }
        }
    }
}
