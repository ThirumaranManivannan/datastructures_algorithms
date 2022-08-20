package ds.datastructures.queue;

public class MyQueue {

    private int capacity = 3;
    private int size = 0;
    private int front = -1;
    private int rear = -1;

    private int[] arr;

    public MyQueue(){
        arr = new int[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public void enqueue(int data){
        if(isFull())
            throw new RuntimeException("Queue is full");
        if(isEmpty()){
            arr[++rear] = data;
            ++front;
            size++;
            return;
        }
        arr[++rear] = data;
        size++;
    }

    public int peek(){
        if(isEmpty())
            throw new RuntimeException("Queue is empty");
        return arr[front];
    }

    public int getFront(){
        size--;
        return arr[front++];
    }

    public int getRear(){
        size--;
        return arr[rear--];
    }

    public static void main(String[] args){
        MyQueue queue = new MyQueue();
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(4);
        System.out.println(queue.getFront());
        queue.enqueue(1);
         queue.enqueue(1);
    }
}
