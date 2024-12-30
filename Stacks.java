import java.util.*;

public class Stacks {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // printStack(s);
        reverseStack(s);
        printStack(s);
    }

    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    public static void reverseStack(Stack<Integer> stack) {
        // base case
        if(stack.isEmpty()) {
            return;
        }

        // recursive case
        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }

    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if(stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < str.length()) {
            stack.push(str.charAt(index));
            index++;
        }

        StringBuilder result = new StringBuilder("");
        while(!stack.isEmpty()) {
            char curr = stack.pop();
            result.append(curr);
        }
        return result.toString();
    }








    //  ---------------------------------------------------------------------------------------------------
    // Stacks
    /*
     * push
     * pop
     * peek
     */

    static class StacksArray{
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // push implement
        public static void push(int data) {
            list.add(data);
        }

        // pop implement
        public static int pop() {
            if(isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek
        public static int peek() {
            if(isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

    }



    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class StacksLinkedList {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if(isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if(isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }
    
}
