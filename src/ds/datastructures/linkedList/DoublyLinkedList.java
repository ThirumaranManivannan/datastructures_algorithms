package ds.datastructures.linkedList;

import ds.datastructures.nodes.DLNode;

public class DoublyLinkedList {
    DLNode head = null;
    DLNode tail = null;

    public void add(int value){
        DLNode newNode = new DLNode(value);
        if(head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public int getHead(){
        return head == null ? 0 : head.data;
    }

    public void print(){
        DLNode temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void encode(String str){
        char[] strArr = str.toCharArray();
        int counter = 1;
        for(int i = 1; i < strArr.length; i++){
            if(strArr[i] == strArr[i - 1]) {
                counter++;
            }
            else {
                System.out.println(counter + "" + strArr[i - 1]);
                counter = 1;
            }
        }
        System.out.println(counter+""+strArr[strArr.length - 1]);
    }
    public static void main(String[] args){
        encode("aaabbcccca");
    }
}
