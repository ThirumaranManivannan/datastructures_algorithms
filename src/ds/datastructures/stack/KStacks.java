package ds.datastructures.stack;

public class KStacks {
    private int[] arr, next, top;
    private int freeTop;

    public KStacks(int noOfStacks, int capacity){
        arr = new int[capacity];
        next = new int[capacity];
        for(int i = 0; i < capacity; i++){
            next[i] = i + 1;
        }
        next[capacity - 1] = -1;
        top = new int[noOfStacks];
        for(int i = 0; i < noOfStacks; i++){
            top[i] = -1;
        }
        freeTop = 0;
    }

    public void push(int stackNo, int val){
        int temp = freeTop;
        arr[freeTop] = val;
        freeTop = next[temp];
        next[temp] = top[stackNo];
        top[stackNo] = temp;
    }

    public int pop(int stackNo){
        int temp = top[stackNo];
        int val = arr[temp];
        top[stackNo] = next[temp];
        next[temp] = temp;
        freeTop = temp;
        return val;
    }

    public static void main(String[] args){
        KStacks kStacks = new KStacks(3, 20);
        kStacks.push(1, 10);
        kStacks.push(1, 11);
        kStacks.push(1, 12);
        kStacks.push(0, 0);
        kStacks.push(0, 1);
        kStacks.push(0, 2);
        kStacks.push(2, 20);
        kStacks.push(2, 21);
        kStacks.push(2, 22);

        System.out.println("Result " + kStacks.pop(0) +" " + kStacks.pop(1) +" "+ kStacks.pop(2));
        System.out.println("Result " + kStacks.pop(0) +" " + kStacks.pop(1) +" "+ kStacks.pop(2));
        System.out.println("Result " + kStacks.pop(0) +" " + kStacks.pop(1) +" "+ kStacks.pop(2));
    }
}
