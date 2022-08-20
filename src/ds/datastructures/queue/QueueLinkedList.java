package ds.datastructures.queue;

public class QueueLinkedList {
    private int size = 0;
    private Node front;
    private Node rear;

    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void print(){
        Node temp = this.front;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void enqueue(int data){
        if(front == null){
            front = rear = new Node(data);
            size++;
            return;
        }
        Node newNode = new Node(data);
        rear.next = newNode;
        rear = newNode;
        size++;
    }

    public Integer dequeue(){
        if(front == null)
            return null;
        int val = front.data;
        front = front.next;
        if(front == null)
            rear = null;
        size--;
        return val;
    }

    public static void main(String[] args){
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(10);
        queue.enqueue(200);
        queue.enqueue(100);
        queue.enqueue(30);

        queue.print();

        System.out.println("before");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("after");
        queue.print();
    }
}
