/*

BinaryTree - O(n)
BinarySearchTree - O(h)

Left subtree nodes < root
Right subtree nodes > root
Left and Right subtrees are also BST with no duplicates
Inorder traversal of BST gives a sorted sequence 
Inorder: left -> root -> right
worst case time complexity: O(h) - h is height of the tree

Strategy - most problems will be solved using 'recursion'


 */

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int value) {
        // base case
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // recursion case
        if (root.data > value) {
            // insert left
            root.left = insert(root.left, value);
        } else { // root <= value
            // insert right
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void inOrderPrint(Node root) {
        if (root == null) {
            return;
        }

        inOrderPrint(root.left);
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }

    /*
     * search a BST
     * time : O(h) -> h is height of the tree
     * space : O(1)
     */
    public static boolean search(Node root, int key) {
        // base case
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        // recursion case
        if (root.data > key) {
            return search(root.left, key);
        } else { // root.data <= key
            return search(root.right, key);
        }
    }

    /*
     * delete a node
     * time :
     * space :
     */
    public static Node delete(Node root, int value) {
        if (root.data > value) {
            root.left = delete(root.left, value);
        } else if (root.data < value) {
            root.right = delete(root.right, value);
        } else { // root.data == value
            // case 1 - no child
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 - one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3 - two child
            Node IS = findInorderSuccessor(root.right); // left most value in right subtree
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    private static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /*
     * print in range
     * time :
     * space :
     */
    public static void printInRange(Node root, int range1, int range2) {
        // base case
        if (root == null) {
            return;
        }

        if (root.data >= range1 && root.data <= range2) {
            printInRange(root.left, range1, range2);
            System.out.print(root.data + " ");
            printInRange(root.right, range1, range2);
        } else if (root.data < range1) {
            printInRange(root.left, range1, range2);
        } else if (root.data > range2) {
            printInRange(root.right, range1, range2);
        }
    }

    /*
     * root to leaf paths
     * time :
     * space :
     */
    public static void rootToLeafPath(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "-");

        if (root.left != null) {
            rootToLeafPath(root.left);
        }

        if (root.right != null) {
            rootToLeafPath(root.right);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrderPrint(root);
        System.out.println();

        // printInRange(root, 5, 12);
        rootToLeafPath(root);
    }
}
