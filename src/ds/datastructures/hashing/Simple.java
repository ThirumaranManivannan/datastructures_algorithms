package ds.datastructures.hashing;

import java.util.*;

public class Simple {

    private static int countDistinctElements(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        return set.size();
    }

    private static void countFrequencies(int[] arr){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(Integer i : arr){
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    private static int intersection(int[] arr1, int[] arr2){
        Set<Integer> set1 = new HashSet<>();
        int res = 0;
        for(int i : arr1){
            set1.add(i);
        }
        for(int i : arr2){
            if(set1.contains(i)) {
                res++;
                set1.remove(i);
            }
        }
        return res;
    }

    private static int union(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();
        for(int i : arr1){
            set.add(i);
        }
        for(int i : arr2){
            set.add(i);
        }
        return set.size();
    }

    public static boolean isPairWithGivenSum(int[] arr, int sum){
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            System.out.println(set);
            int reqVal = sum - i;
            if(set.contains(i)) {
                System.out.println(i + " " + reqVal);
                return true;
            }
            set.add(reqVal);
        }
        return false;
    }

    public static boolean subArrWithZeroSum(int[] arr){
        Set<Integer> set = new HashSet<>();
        int preSum = 0;
        for(int i : arr){
            preSum += i;
            if(set.contains(preSum))
                return true;
            if(preSum == 0)
                return true;
            set.add(preSum);
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr = {1, 4, 13, -3, -10, 5};
        System.out.println(subArrWithZeroSum(arr));
        //countFrequencies(arr);
    }
}
