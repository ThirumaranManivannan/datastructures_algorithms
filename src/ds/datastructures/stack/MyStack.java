package ds.datastructures.stack;

import java.util.EmptyStackException;

public class MyStack<T> {
    private final Integer CAPACITY = 10;
    private Integer size = 0;
    private Object[] arr;
    private Integer top = -1;

    public MyStack(Integer capacity){
        arr = new Object[capacity];
    }
    public MyStack(){
        arr = new Object[CAPACITY];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return size == arr.length - 1;
    }

    public void push(T data){
        if(isFull())
            throw new StackOverflowError();
        arr[++top] = data;
        size++;
    }

    public T pop(){
        if(isEmpty())
            throw new EmptyStackException();
        T data = (T) arr[top--];
        size--;
        return data;
    }

    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
