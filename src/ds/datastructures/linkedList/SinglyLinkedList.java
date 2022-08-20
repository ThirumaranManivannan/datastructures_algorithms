package ds.datastructures.linkedList;

import ds.datastructures.nodes.ListNode;

public class SinglyLinkedList {
    ListNode head = null;

    public void add(int value){
        if(head == null) {
            head = new ListNode(value);
            return;
        }
        ListNode newNode = new ListNode(value);
        ListNode temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public void insert(int value, int index){
        ListNode newNode = new ListNode(value);
        int count = 0;
        if(index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.next != null && count != index - 1){
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void delete(int index){
        ListNode temp = head;
        int count = 0;
        while(temp.next.next != null && count == index - 1){
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;
    }

    public void printRecursive(ListNode node){
       if(node == null)
           return;
        System.out.println(node.data);
        printRecursive(node.next);
    }

    public void print(){
        if(head == null)
            System.out.println("List is empty");
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void insertSorted(int value){
        if(head == null) {
            head = new ListNode(value);
            return;
        }
        ListNode temp = new ListNode(value);
        if(head.data >= value){
            temp.next = head;
            head = temp;
            return;
        }
        ListNode curr = head;
        while(curr.next != null && curr.next.data <= value){
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
    }

    public void reverse(){
        if(head == null)
            return;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void removeDuplicate(){
        if(head == null)
            return;
        ListNode curr = head.next;
        ListNode nonDuplicate = head;
        int currValue = head.data;
        while(curr != null){
            if(currValue != curr.data){
                currValue = curr.data;
                nonDuplicate.next = curr;
                nonDuplicate = curr;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args){
        SinglyLinkedList sList = new SinglyLinkedList();
        sList.add(10);
        sList.add(20);
        sList.add(20);
        sList.add(30);
        sList.add(30);
        sList.add(30);
        sList.add(40);
        sList.print();
        System.out.println("---------");
        sList.removeDuplicate();
        sList.print();
    }
}
