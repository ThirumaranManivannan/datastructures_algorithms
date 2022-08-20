package ds.datastructures.linkedList;

import ds.datastructures.nodes.ListNode;

public class CircularLinkedList {
    public static void main(String[] args){
        ListNode head = null;
        head = insertAtBegining(head, 10);
        head = insertAtBegining(head, 3);
        print(head);
    }

    public static void print(ListNode node){
        if(node == null)
            return;
        ListNode cur = node.next;
        System.out.println(node.data);
        while(cur != node){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public static ListNode insertAtBegining(ListNode node, int value){
        ListNode temp = new ListNode(value);
        if(node == null) {
            temp.next = temp;
            return temp;
        }
        ListNode curr = node;
        while(curr.next != node){
            curr = curr.next;
        }
        curr.next = temp;
        temp.next = node;
        return temp;
    }
}
