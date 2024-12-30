public class LinkedList {
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(9);
        ll.addFirst(5);
        ll.addFirst(3);

        ll.printLL();
        ll.printLL();

        // ll.reverseLinkedList();
        // ll.printLL();
        
    } 


    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // time : O(1)
    public void addFirst(int data) {
        // step 1: create new node
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }

        // step 2: newNode next = head
        newNode.next = head;
        // step 3: head = newNode
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        // step 1: create newNode
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        // step 2: tail next = newNode
        tail.next = newNode;
        // step 3: tail = newNode
        tail = newNode;
        size++;
    }

    public void printLL() {
        if(head == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(int index, int data) {
        Node temp = head;
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
        }

        int currIndex = 0;
        while(currIndex < index - 1) {
            temp = temp.next;
            currIndex++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public int size() {
        int count = 0;
        if(head == null) {
            return 0;
        }
        Node temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void removeFirst() {
        if(size == 0) {
            System.out.println("LinkedList is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
            size--;
            return;
        }

        Node temp = head;
        temp = head.next;
        head = temp;
        size--;
    }

    public void removeLast() {
        if(size == 0) {
            System.out.println("Linked list is empty");
            return;
        } else if(size == 1) {
            head = tail = null;
            return;
        }

        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public int search(int key) {
        Node temp = head;
        int index = 0;

        while(temp != null) {
            if(temp.data == key) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        // not found
        return -1;
    }

    public int recursiveSearch(int key) {
        return helperRecursiveSearch(head, key);
    }

    private int helperRecursiveSearch(Node head, int key) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }
        
        int index = helperRecursiveSearch(head.next, key);
        if(index == -1) {
            return -1;
        }

        return index + 1;
    }

    public void reverseLinkedList() {
        if(head == null) {
            System.out.println("Empty LinkedList");
            return;
        }

        Node curr = tail = head;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // public void remove(int index) {
    //     Node temp = head;
    //     int currIndex = 0;

    //     while(currIndex != index) {
    //         temp = temp.next;
    //         index++;
    //     }

    //     if(temp.next.next == null) {
    //         System.out.println("null");
    //     } else {
    //         temp.next = temp.next.next;
    //     }
    // }
}
