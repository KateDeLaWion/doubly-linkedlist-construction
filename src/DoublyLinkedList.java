import java.util.NoSuchElementException;

public class DoublyLinkedList {

    // separate class of ListNode
    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;
        //constructor of ListNode
        public ListNode(int data) {
            this.data = data;
        }
    }


    //constructor of DoublyLinkedList
    private ListNode head; // this head has the head, return head, return the entire list
    private ListNode tail;
    private int length;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // function of empty or not
    public boolean isEmpty() {
        return length == 0; // head == null;  boolean operator
    }

    // function of length
    public int length() {
        return length;
    }

    // function of insertFirst
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    // function of insertLast
    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    // function to delete the first node
    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if(head == tail){
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    // function to delete the last node
     public ListNode deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if(head == tail){
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
     }


    // function to display Doubly LinkedList in forward direction
    public void displayForward() {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // function to display Doubly LinkedList in backward direction
    public void displayBackward() {
        if (tail == null) {
            return;
        }
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

//        dll.insertFirst(1);
//        dll.insertFirst(10);
//        dll.insertFirst(15);
//        dll.insertFirst(25);

        dll.insertLast(1);
        dll.insertLast(10);
        dll.insertLast(15);
        dll.insertLast(25);

//        System.out.println("Forward display as below:");
//        dll.displayForward();
//        System.out.println("Backward display as below:");
//        dll.displayBackward();


//        System.out.println("Forward display as below:");
//        dll.displayForward();
//        dll.deleteFirst();
//        dll.deleteFirst();
//        dll.deleteFirst();
//        System.out.println("Forward display as below:");
//        dll.displayForward();


        System.out.println("Forward display as below:");
        dll.displayForward();
        dll.deleteLast();
        dll.deleteLast();
        System.out.println("Forward display as below:");
        dll.displayForward();


    }


}
