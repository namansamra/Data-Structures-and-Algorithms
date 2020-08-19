import java.util.*;

public class avl {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        int height = 0;
        int bfac = 0;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static TreeNode addNode(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data < node.val) {
            node.left = addNode(node.left, data);

        } else if (data > node.val) {
            node.right = addNode(node.right, data);
        }

        node = rotation(node);
        return node;

    }

    public static void update_and_bal_node(TreeNode node) {
        int lh = -1;
        int rh = -1;

        if (node.left != null)
            lh = node.left.height;

        if (node.right != null)
            rh = node.right.height;

        node.height = Math.max(lh, rh) + 1;
        node.bfac = lh - rh;

    }

    public static TreeNode ll(TreeNode x) {
        TreeNode y = x.left;
        TreeNode yright = y.right;

        y.right = x;
        x.left = yright;

        update_and_bal_node(y);
        update_and_bal_node(x);
        return y;

    }

    public static TreeNode rr(TreeNode x) {
        TreeNode y = x.right;
        TreeNode yleft = y.left;

        y.left = x;
        x.right = yleft;

        update_and_bal_node(x);
        update_and_bal_node(y);
        return y;

    }

    public static TreeNode rotation(TreeNode node) {
        update_and_bal_node(node);
        if (node.bfac == 2) { // can be ll/lr
            if (node.left.bfac == 1) { // must be ll
                return ll(node);

            } else if (node.left.bfac == -1) {// must be lr
                node.left = rr(node.left); // rr on y then ll on x
                return ll(node);
            }

        } else if (node.bfac == -2) {// can be rr/rl
            if (node.right.bfac == -1) { // must be rr
                return rr(node);

            } else if (node.right.bfac == 1) {// mustb be rl
                node.right = ll(node.right);// ll on y then rr on x
                return rr(node);

            }

        }

        return node;
    }

    public static int maxIntree(TreeNode root) {
        if (root.right == null) {
            return root.val;
        }

        return maxIntree(root.right);
    }

    public static TreeNode remove(TreeNode node, int data) {
        if (node == null) {
            return null;
        }
        if (data == node.val) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null || node.right == null) {
                return node.left != null ? node.left : node.right;
            } else {
                int leftsubtreeMax = maxIntree(node.left);
                node.val = leftsubtreeMax;
                node.left = remove(node.left, leftsubtreeMax);
                return node;

            }
        }
        if (data < node.val) {
            node.left = remove(node.left, data);
        } else if (data > node.val) {
            node.right = remove(node.right, data);
        }

        return node;

    }

    public static void display(TreeNode node) {
        if (node == null)
            return;
        String str = "";

        str += node.left != null ? node.left.val + "" : "   ";
        str += "->" + node.val + " (" + node.bfac + ") " + "<-";
        str += node.right != null ? node.right.val + " " : " ";
        System.out.println(str);

        display(node.left);
        display(node.right);

    }

    public static void main(String[] args) {
        TreeNode node = null;
        for (int i = 0; i < 10; i++) {
            node = addNode(node, (i + 1) * 10);
        }
        node = remove(node, 80);
        display(node);
    }
}