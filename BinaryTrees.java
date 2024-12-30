
/*
 * root
 * branch
 * leaf
 */
import java.util.*;

import javax.swing.tree.TreeNode;

public class BinaryTrees {

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

    // static class BinaryTree{

    static int index = -1;

    public static Node buildTree(int nodes[]) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    /*
     * pre order
     * time : O(n)
     * space : O(1)
     */
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /*
     * in order
     * time : O(n)
     * space :
     */
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /*
     * post order
     * time :
     * space :
     */
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /*
     * level order
     * time :
     * space :
     */
    // public static void levelOrder(Node root) {
    // Queue<Node> q = new LinkedList<>(); // WHY??!!

    // if(root == null) {
    // return;
    // }
    // q.add(root);
    // q.add(null);

    // while(!q.isEmpty()) {
    // Node currNode = q.remove();
    // if(currNode == null) {
    // // end of list - no more element left
    // if(q.isEmpty()) {
    // break;
    // } else {
    // // new line
    // System.out.println();
    // }
    // } else {
    // System.out.print(currNode.data + " ");
    // if(currNode.left != null) {
    // q.add(currNode.left);
    // }
    // if(currNode.right != null) {
    // q.add(currNode.right);
    // }
    // }
    // }
    // }

    /*
     * height of tree
     * time : O(n)
     * space :
     */
    public static int height(Node root) {
        int countHeight = 0;
        if (root == null) {
            return 0;
        } else {
            countHeight++;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int maxHeight = Math.max(leftHeight, rightHeight) + 1;

        return maxHeight;
    }

    /*
     * count number of tree nodes
     * time : O(n)
     * space :
     */
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        int totalCount = leftCount + rightCount + 1;

        return totalCount;
    }

    /*
     * sum of nodes
     * time :
     * space :
     */
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        int totalSum = leftSum + rightSum + root.data;

        return totalSum;
    }

    /*
     * find diameter of a tree
     * time : O(n^2)
     * space :
     */
    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiameter = diameterOfTree(root.left);
        int leftHeight = height(root.left);

        int rightDiameter = diameterOfTree(root.right);
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        int maxDiameter1 = Math.max(leftDiameter, rightDiameter);
        int maxDiameter = Math.max(maxDiameter1, selfDiameter);

        return maxDiameter;
    }

    /*
     * optimal solution to find diameter of a tree
     * time : O(n)
     * space :
     */
    static class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameterOfTreeOptimal(Node root) {
        Info leftInfo = diameterOfTreeOptimal(root.left);
        Info rightInfo = diameterOfTreeOptimal(root.right);

        int selfHeight = leftInfo.height + rightInfo.height + 1;

        int finalDiameter = Math.max(leftInfo.diameter, Math.max(rightInfo.diameter, selfHeight));
        int finalHeight = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(finalDiameter, finalHeight);
    }

    /*
     * subtree of another tree - given the roots of two binary trees root and
     * subRoot, return
     * true if there is a subtree of root with the same structure and node values of
     * subRoot
     * and false otherwise
     * 
     * time :
     * space :
     */
    public static boolean isSubTree(Node root, Node subRoot) {
        if (root == null) {
            return false; // subroot none empty
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // boolean leftAns = isSubTree(root.left, subRoot);
        // boolean rightAns = isSubTree(root.right, subRoot);

        // return leftAns || rightAns;

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static int countNodes2(Node root) {
        if (root == null) {
            return 0;
        }

        int countLeft = countNodes(root.left);
        int countRight = countNodes(root.right);

        return countLeft + countRight + 1;
    }

    public static int rangeSumBST(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.data >= low && root.data <= high) {
            sum += root.data;
        }

        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        return sum = sum + left + right;
    }

    /*
     * kth level of a tree
     * time :
     * space :
     */
    public static void kLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kLevel(root.left, level + 1, k);
        kLevel(root.right, level + 1, k);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 3;
        kLevel(root, 1, k);
        System.out.println();
    }
}
