package ds.datastructures.arraylist;

import java.util.Arrays;

public class ArrayList<T> {
    private int capacity;
    private final int sizeFactor = 2;
    private Object[] arr;
    private int size = 0;
    public ArrayList(int capacity){
        this.capacity = capacity;
        arr = new Object[capacity];
    }
    public ArrayList(){
        this.capacity = 2;
        arr = new Object[this.capacity];
    }

    private boolean isFull(){
        return this.capacity == this.size;
    }
    private void increaseCapacity(){
        this.capacity = this.capacity * sizeFactor;
        Object[] newArr = new Object[this.capacity];
        if (this.size >= 0) System.arraycopy(arr, 0, newArr, 0, this.size);
        arr = newArr;
    }

    private boolean validation(){
        if(isFull())
            increaseCapacity();
        return true;
    }

    public Boolean add(T data){
        if(validation()){
            arr[size++] = data;
            return true;
        }else {
            System.out.println("something went wrong");
            return false;
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size; i++){
            sb.append(arr[i]);
            if(i != size - 1)
                sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
}
