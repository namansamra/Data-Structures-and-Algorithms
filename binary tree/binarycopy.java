import java.util.*;
import java.util.Scanner;


public class binarycopy{
     public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node() {

        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static class pair {
        Node node = null;
        int state = 0;

        pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void display_binary(Node node) {
        if (node == null)
            return;

        System.out.print(node.left != null ? node.left.val : " ");
        System.out.print(" " + node.val + " ");
        System.out.print(node.right != null ? node.right.val : " ");
        System.out.println();

        display_binary(node.left);
        display_binary(node.right);
    }











    
}