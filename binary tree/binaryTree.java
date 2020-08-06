import java.util.*;
import java.util.Scanner;

public class binaryTree {
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
        System.out.print(" " + "<-" + node.val + "->" + " ");
        System.out.print(node.right != null ? node.right.val : " ");
        System.out.println();

        display_binary(node.left);
        display_binary(node.right);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, -1, -1, 50, -1, -1, 160, -1, -1, 70, -6, 90, 100, -1, -1, -1, 110, 120, -1, -1,
                -1, 130, -1, -1 };

        // int[] arr = { 10, 20, -1, -1, 30, -1, -1 };

        Node root1 = creatBinary_tree(arr);
        // Node root2 = creat_binarytTreeItr(arr);

        // display_binary(root1);
        // System.out.println();
        // display_binary(root2);
        // System.out.println(min_in_tree(root1));

        // ArrayList<Node> ans = root_to_node_path(root1, 160);
        // for (Node n : ans)
        // System.out.print(n.val + " ");

        // System.out.println(Least_Common_ancesstor(root1, 100,70));
        // Kdown(root1, 3);
        // kway(root1, 20, 2);
        // System.out.println(height(root1));
        // System.out.println(diameter01(root1));

        // int[] ans = diameter02(root1);
        // for (int i : ans)
        // System.out.print(i + " ");

        // System.out.println();
        // System.out.println(diameter03(root1) + " " + dia);
        // leaf_to_leafSum(root1);
        // System.out.println(node_to_node_max_sum(root1));
        // System.out.println(sum_lol);
        // System.out.println(max_non);

        // System.out.println(hasPathSum(root1, 30));
        // System.out.println(minHeight(root1));
        minHeight(root1, 0);
        System.out.println(min__);
        System.out.println(minHeight02(root1));

        // PreTraversal(root1);
        // System.out.println();
        // IN_order_Traversal(root1);
        // System.out.println();
        // PostTraversal(root1);

    }

    static int idx = 0;

    public static Node creatBinary_tree(int[] arr) {
        if (arr[idx] == arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }
        Node node = new Node(arr[idx]);
        idx++;
        node.left = creatBinary_tree(arr);
        node.right = creatBinary_tree(arr);

        return node;
    }

    public static Node creat_binarytTreeItr(int[] arr) {
        // three states are possible 0=>no children till now,1=>left chilren is
        // decided,2=>both children are decided

        int idx = 0;
        Stack<pair> st = new Stack<>();
        Node root = new Node(arr[idx]);
        st.push(new pair(root, 0));
        idx++;

        while (st.size() != 0) {
            pair topEle = st.peek();
            if (topEle.state == 0) {
                if (arr[idx] != -1) {
                    Node left = new Node(arr[idx]);
                    topEle.node.left = left;
                    st.push(new pair(left, 0));
                }
                topEle.state++;
                idx++;
            }

            else if (topEle.state == 1) {
                if (arr[idx] != -1) {
                    Node right = new Node(arr[idx]);
                    topEle.node.right = right;
                    st.push(new pair(right, 0));
                }

                topEle.state++;
                idx++;
            } else
                st.pop();
        }

        return root;

    }

    public static int min_in_tree(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int left = min_in_tree(root.left);
        int right = min_in_tree(root.right);
        return Math.min(root.val, Math.min(left, right));

    }

    public static int max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int left = max(root.left);
        int right = max(root.right);

        return Math.max(root.val, Math.max(left, right));
    }

    public static int height(Node root) {
        if (root == null)
            return -1;

        int left_height = height(root.left);
        int right_height = height(root.right);

        return Math.max(left_height, right_height) + 1;
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }

        int left_size = size(root.left);
        int right_size = size(root.right);
        return left_size + right_size + 1;
    }

    public boolean find(Node root, int data) {
        if (root == null)
            return false;

        if (root.val == data)
            return true;

        boolean res = false;
        res = res || find(root.left, data) || find(root.right, data);

        return res;
    }

    public static ArrayList<Node> root_to_node_path(Node root, int data) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.val == data) {
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(root);
            return ans;

        }

        ArrayList<Node> left = root_to_node_path(root.left, data);
        {
            if (left.size() != 0) {
                left.add(root);
                return left;
            }
        }
        ArrayList<Node> right = root_to_node_path(root.right, data);
        {
            if (right.size() != 0) {
                right.add(root);
                return right;
            }
        }

        return new ArrayList<>();
    }

    public static ArrayList<Node> r_to_N_path(Node root, int data) {
        if (root == null) {
            return new ArrayList<Node>();
        }

        if (root.val == data) {
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }

        ArrayList<Node> right = r_to_N_path(root.right, data);
        if (right.size() != 0) {
            right.add(root);
            return right;
        }

        ArrayList<Node> left = r_to_N_path(root.left, data);
        if (left.size() != 0) {
            left.add(root);
            return left;
        }

        return new ArrayList<Node>();
    }

    public static int Least_Common_ancesstor(Node root, int data1, int data2) {
        ArrayList<Node> path_of_data1 = root_to_node_path(root, data1);
        ArrayList<Node> path_of_data2 = root_to_node_path(root, data2);

        Integer ans = null;
        if (path_of_data1.size() == 0 || path_of_data2.size() == 0)
            return ans;

        int i = path_of_data1.size() - 1;
        int j = path_of_data2.size() - 1;

        while (i >= 0 && j >= 0) {
            int val1 = path_of_data1.get(i).val; // rememeber that in root to node path the values are stores in reverse
                                                 // order
            int val2 = path_of_data2.get(j).val;

            if (val1 != val2)
                break;

            ans = val1;
            i--;
            j--;
        } // path1.equals(path2) can also be used

        return ans;

    }

    public static void Kdown(Node node, int k) {
        if (node == null || k < 0) {
            return;

        }

        if (k == 0) {
            System.out.println(node.val);
            return;
        }

        Kdown(node.left, k - 1);
        Kdown(node.right, k - 1);

    }

    public static void Kdown_modified_for_kaway(Node node, Node blocker, int k) {
        if (node == null || k < 0 || node == blocker) {
            return;

        }

        if (k == 0) {
            System.out.print(node.val + " ");
            return;
        }

        Kdown_modified_for_kaway(node.left, blocker, k - 1);
        Kdown_modified_for_kaway(node.right, blocker, k - 1);

    }

    public static void kway(Node node, int data, int k) {
        ArrayList<Node> path = root_to_node_path(node, data);
        for (int i = 0; i < path.size(); i++)
            Kdown_modified_for_kaway(path.get(i), i != 0 ? path.get(i - 1) : null, k - i);

    }

    public static int diameter01(Node root) {
        if (root == null)
            return 0;

        int left_height = height(root.left);
        int right_height = height(root.right);
        int left_dia = diameter01(root.left);
        int right_dia = diameter01(root.right);

        int diameter_final = Math.max(left_height + right_height + 2, Math.max(left_dia, right_dia));
        return diameter_final;

    }

    public int[] diaPract(Node root) {
        if (root == null)
            return new int[] { -1, 0 };

        int[] left = diaPract(root.left);
        int[] right = diaPract(root.right);

        int left_dia = left[1];
        int right_dia = right[1];
        int left_height = left[0];
        int right_height = right[0];

        int[] arr = new int[2];
        arr[0] = Math.max(left_height, right_height) + 1;
        arr[1] = Math.max(Math.max(left_dia, right_dia), right_height + left_height + 2);

        return arr;
    }

    public static int[] diameter02(Node root) {
        if (root == null) {
            return new int[] { -1, 0 };
        }

        int[] left_height_and_dia = diameter02(root.left);
        int[] right_height_and_dia = diameter02(root.right);

        int[] arr = new int[2];
        arr[0] = Math.max(left_height_and_dia[0], right_height_and_dia[0]) + 1;
        arr[1] = Math.max(left_height_and_dia[0] + right_height_and_dia[0] + 2,
                Math.max(left_height_and_dia[1], right_height_and_dia[1]));

        return arr;
    }

    static int dia = 0;

    public static int diameter03(Node root) {
        if (root == null)
            return -1;

        int lh = diameter03(root.left);
        int rh = diameter03(root.right);

        dia = Math.max(dia, lh + rh + 2);

        return Math.max(lh, rh) + 1;

    }

    static int sum_lol = 0;

    public static int leaf_to_leafSum(Node root) {
        if (root == null)
            return 0;

        int left_leaf_sum = leaf_to_leafSum(root.left);
        int right_leaf_sum = leaf_to_leafSum(root.right);

        if (root.left != null && root.right != null)
            sum_lol = Math.max(sum_lol, left_leaf_sum + right_leaf_sum + root.val);

        return Math.max(left_leaf_sum, right_leaf_sum) + root.val;
    }

    static int max_non = Integer.MIN_VALUE;

    public static int node_to_node_max_sum(Node root) {
        if (root == null)
            return 0;

        int left_non_sum = node_to_node_max_sum(root.left);
        int right_non_sum = node_to_node_max_sum(root.right);
        int max_sum_in_brach = Math.max(left_non_sum, right_non_sum);

        int comparision1 = Math.max(max_sum_in_brach + root.val, left_non_sum + right_non_sum + root.val);

        max_non = Math.max(max_non, Math.max(root.val, comparision1));

        return Math.max(max_sum_in_brach + root.val, root.val);

    }

    public static boolean hasPathSum(Node root, int target) {
        if (root == null)
            return false;

        if (target == 0)
            return true;

        boolean res = false;

        res = res || hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);

        return res;
    }

    public static boolean hasPathSum_leaf_to_root(Node root, int target) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null && target == 0)
            return true;

        boolean res = false;

        res = res || hasPathSum_leaf_to_root(root.left, target - root.val) || hasPathSum(root.right, target - root.val);

        return res;
    }

    static int min__ = Integer.MAX_VALUE;

    public static void minHeight(Node root, int ht) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            min__ = Math.min(min__, ht);
            return;
        }

        minHeight(root.left, ht + 1);
        minHeight(root.right, ht + 1);

    }

    public static int minHeight02(Node root) {
        if (root == null)
            return -1;

        int left = minHeight02(root.left);
        int right = minHeight02(root.right);

        // if (left == -1)
        //     return right + 1;

        // else if (right == -1)
        //     return left + 1;

        // else
        //     return Math.min(left, right) + 1;

        return left==-1?right+1:right==-1?left+1:Math.min(left,right)+1;    

    }

    public static int mindepth_means_number_of_nodes(Node root) {
        if (root == null)
            return 0;

        int left = mindepth_means_number_of_nodes(root.left);
        int right = mindepth_means_number_of_nodes(root.right);

        if (left == 0)
            return right + 1;

        else if (right == 0)
            return left + 1;

        else
            return Math.min(left, right) + 1;

       // return (left==0 ||right==0)? left+right+1:Math.min(left,right)+1;     

    }

    // to convert the binary into decimal a small trick from ****left to
    // right****(main) and right to left(we all know right to left)
    public static int BinaryConvert(String n) {
        int sum = 0;
        // int i=n.length()-1;
        // int j=0;
        // while(i>=0)
        // {
        // int ch=n.charAt(i)-'0';
        // sum+=ch*Math.pow(2,j);
        // i--;
        // j++;
        // }

        for (int i = 0; i < n.length(); i++) {
            int ch = n.charAt(i) - '0';
            sum = sum * 2 + ch;
        }

        return sum;
    }

    //// LEETCODE 1022;
    static int ans = 0;

    public int sumRootToLeaf(Node root) {
        ans = 0;
        helper(root, "");
        return ans;

        // return BinaryConvert("11001");

    }

    public static void helper(Node node, String sum) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            String value = sum + node.val + "";
            ans += BinaryConvert(value);
        }

        helper(node.left, sum + node.val + "");
        helper(node.right, sum + node.val + "");
    }

    ///////////////////////////////////////////

    // LEETCODE 226

    public Node invertTree(Node root) {
        helper1(root);
        return root;

    }

    public static void helper1(Node root) {
        if (root == null)
            return;
        // Method 1;
        // Node left = new Node();
        // Node right = new Node();

        // left=root.left;
        // right=root.right;

        // root.left=right;
        // root.right=left;

        // Method2
        Node left_temp = root.left;
        root.left = root.right;
        root.right = left_temp;

        helper1(root.left);
        helper1(root.right);

    }

    //// TRAVERSALS IN BINARY TREE

    public static void PreTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        PreTraversal(root.left);
        PreTraversal(root.right);

    }

    public static void IN_order_Traversal(Node root) {
        if (root == null)
            return;

        IN_order_Traversal(root.left);
        System.out.print(root.val + " ");
        IN_order_Traversal(root.right);

    }

    public static void PostTraversal(Node root) {
        if (root == null)
            return;

        PostTraversal(root.left);
        PostTraversal(root.right);
        System.out.print(root.val + " ");

    }

    ///////////////////// LEETCODE 637
    static List<Double> arr;

    public List<Double> averageOfLevels(Node root) {
        arr = new ArrayList<>();
        average_cal(root);
        return arr;

    }

    public static void average_cal(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while (que.size() != 0) {
            int size = que.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                Node node = que.peek();
                if (node.left != null)
                    que.add(node.left);

                if (node.right != null)
                    que.add(node.right);

                sum += que.poll().val;

            }
            arr.add((sum / size));
        }
    }

    /////////////////////////// LEETCODE 606
    public String tree2str(Node node) {
        if (node == null)
            return "";
        if (node.right == null && node.left == null)
            return node.val + "";
        String left = tree2str(node.left);
        String right = tree2str(node.right);

        if (right.equals("")) // both right and left cannot be empty as it is already considered above.
            return node.val + "(" + left + ")" + "";
        else
            return node.val + "(" + left + ")" + "(" + right + ")";

        // if(left.equals(""))
        // return node.val+"()"+"("+right+")"+"";
        // if(right.equals(""))
        // return node.val+"("+left+")"+"";

        // return node.val+"("+left+")"+"("+right+")";

    }

    //////////////////////// LEETCODE 100;
    public boolean isSameTree(Node p, Node q) {
        return !is_not_Same_helper(p, q);
    }

    public static boolean is_not_Same_helper(Node p, Node q) {
        if (p == null && q == null)
            return false;

        // if((p==null && q!=null ) || p!=null &&q==null)
        // return true;

        if (p == null || q == null)
            return true;

        boolean res = false;
        if (p.val != q.val)
            return true;

        res = res || is_not_Same_helper(p.left, q.left) || is_not_Same_helper(p.right, q.right);

        return res;

    }

    ///////////////////////////////////////////

    ////////////////////// LEETCODE 993
    static int par1;
    static int par2;
    static int height1;
    static int height2;

    public boolean isCousins(Node root, int x, int y) {
        par1 = -1;
        par2 = -1;
        height1 = 0;
        height2 = 0;

        depth_of_node(root, -1, x, y, 0);
        if (par1 != par2 && height1 == height2)
            return true;

        return false;
    }

    public static void depth_of_node(Node node, int pnode, int x, int y, int dep) {
        if (node == null)
            return;

        if (node.val == x) {
            par1 = pnode;
            height1 = dep;
            return;
        } else if (node.val == y) {
            par2 = pnode;
            height2 = dep;
            return;
        }

        depth_of_node(node.left, node.val, x, y, dep + 1);
        depth_of_node(node.right, node.val, x, y, dep + 1);

    }

    // ------------------- one more method for same question================

    public boolean isCousins_(Node root, int x, int y) {

        int[] height1 = depth_of_node(root, -1, x);
        int[] height2 = depth_of_node(root, -1, y);
        if (height1[0] == height2[0] && height1[1] != height2[1])
            return true;

        return false;
    }

    public static int[] depth_of_node(Node node, int pnode, int val) {
        if (node == null)
            return new int[] { Integer.MIN_VALUE, -1 };

        if (node.val == val) {
            return new int[] { 0, pnode };
        }
        int left[] = depth_of_node(node.left, node.val, val);
        int right[] = depth_of_node(node.right, node.val, val);

        int[] arr = new int[2];
        arr[0] = Math.max(left[0], right[0]) + 1;
        arr[1] = left[1] != -1 ? left[1] : right[1];

        return arr;

    }

    ///////////////////////////////////////////////////

    /////////////////////////////////////// LEETCODE 606
    // without static
    public int sumOfLeftLeaves(Node root) {

        return helper(root, false);

    }

    public static int helper(Node root, boolean IamLeft) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null && IamLeft)
            return root.val;

        return helper(root.left, true) + helper(root.right, false);

    }

    // with static
    static int sum;

    public int sumOfLeftLeavesStatic(Node root) {
        sum = 0;
        helper(root);

        return sum;

    }

    public static void helper(Node root) {
        if (root == null)
            return;

        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;

        helper(root.left);
        helper(root.right);
    }

    /////////////////////////////////////////////////

    ////////////////////LEETCODE 110
    public boolean isBalanced(Node root) {
        if (root == null)
            return true;

        return height1(root) == -1 ? false : true;

    }

    public static int height1(Node root) {
        if (root == null)
            return 0;

        int left = height1(root.left);
        int right = height1(root.right);

        return (left == -1 || right == -1 || Math.abs(left - right) > 1) ? -1 : Math.max(left, right) + 1;

    }

    ////same with my first Method

    public boolean isBalanced2(Node root) {
        if (root == null)
            return true;

        int[] ans = height2(root);
        return ans[1] == 1;
    }

    public static int[] height2(Node root) {
        if (root == null)
            return new int[] { -1, 1 };

        int[] left = height2(root.left);
        int[] right = height2(root.right);

        int[] arr = new int[2];
        arr[0] = Math.max(left[0], right[0]) + 1;
        arr[1] = (left[1] == 0 || right[1] == 0) ? 0 : (Math.abs(left[0] - right[0]) > 1) ? 0 : 1;

        return arr;

    }

    ////////////////////////////

}