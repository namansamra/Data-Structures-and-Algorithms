import java.util.*;

public class binaryPrac {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;

        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.left != null ? " " + root.left.val + " " : " ");
        System.out.print(" <=" + root.val + "=> ");
        System.out.print(root.right != null ? " " + root.right.val : " ");
        System.out.println();

        display(root.left);
        display(root.right);
    }

    static int idx = 0;

    public static TreeNode creatBinaryTree(int[] arr) {
        if (idx == arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(arr[idx]);
        idx++;

        root.left = creatBinaryTree(arr);
        root.right = creatBinaryTree(arr);

        return root;
    }

    public static class pair {
        TreeNode node;
        int state = -1;

        pair(TreeNode node) {
            this.node = node;
        }

        pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static TreeNode creatBinaryItr(int[] arr) {
        int idx2 = 0;
        Stack<pair> st = new Stack<>();
        TreeNode root = new TreeNode(arr[idx2]);
        st.push(new pair(root, -1));
        idx2++;

        while (st.size() != 0) {
            pair top = st.peek();
            if (top.state == -1) {
                if (arr[idx2] != -1) {
                    TreeNode left = new TreeNode(arr[idx2]);
                    top.node.left = left;
                    st.push(new pair(left, -1));
                }
                top.state++;
                idx2++;

            } else if (top.state == 0) {
                if (arr[idx2] != -1) {
                    TreeNode right = new TreeNode(arr[idx2]);
                    top.node.right = right;
                    st.push(new pair(right, -1));
                }
                top.state++;
                idx2++;

            } else {

                st.pop();
            }

        }

        return root;

    }

    public static int size(TreeNode root) {
        if (root == null)
            return 0;

        int left_size = size(root.left);
        int right_size = size(root.right);

        return left_size + right_size + 1;
    }

    public static int height(TreeNode root) {
        if (root == null)
            return -1;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;

    }

    public static boolean find(TreeNode root, int data) {
        if (root == null)
            return false;

        if (root.val == data)
            return true;

        boolean res = false;
        res = res || find(root.left, data) || find(root.right, data);
        return res;

    }

    public static int min(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;

        int left_min = min(root.left);
        int right_min = min(root.right);

        return Math.min(root.val, Math.min(left_min, right_min));

    }

    public static int max(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int left_max = max(root.left);
        int right_max = max(root.right);

        return Math.max(root.val, Math.max(left_max, right_max));
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<pair> st = new Stack<>();
        st.push(new pair(root, -1));
        if (root == null)
            return list;

        while (st.size() != 0) {
            pair top = st.peek();
            if (top.state == -1) {
                if (top.node.left != null) {
                    st.push(new pair(top.node.left, -1));
                }
                top.state++;
            } else if (top.state == 0) {
                list.add(top.node.val);
                if (top.node.right != null) {
                    st.push(new pair(top.node.right, -1));
                }
                top.state++;
            } else {
                st.pop();
            }
        }
        return list;
    }

    public static ArrayList<Integer> node_to_root_path(TreeNode root, int data) {
        if (root == null) {
            ArrayList<Integer> base = new ArrayList<>();
            return base;
        }

        if (root.val == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            return list;
        }

        ArrayList<Integer> left = node_to_root_path(root.left, data);
        if (left.size() != 0) {
            left.add(root.val);
            return left;
        }
        ArrayList<Integer> right = node_to_root_path(root.right, data);
        if (right.size() != 0) {
            right.add(root.val);
            return right;
        }

        return new ArrayList<>();
    }

    public static int LCA(TreeNode root, int data1, int data2) {
        ArrayList<Integer> path1 = node_to_root_path(root, data1);
        ArrayList<Integer> path2 = node_to_root_path(root, data2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;
        if (path1.size() == 0 || path2.size() == 0)
            return -1;
        while (i >= 0 && j >= 0) {
            if (path1.get(i) != path2.get(j)) {
                break;
            }

            i--;
            j--;
        }

        return path1.get(i + 1);
    }

    public static void level_order(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode head = que.poll();
                System.out.print(head.val + " ");
                if (head.left != null) {
                    que.add(head.left);
                }

                if (head.right != null) {
                    que.add(head.right);

                }
            }

            System.out.println();
        }
    }

    public static void kdown(TreeNode root, int k) {
        if (root == null)
            return;
        if (k == 0) {
            System.out.print(root.val + " ");
            return;
        }

        kdown(root.left, k - 1);
        kdown(root.right, k - 1);
    }

    public static void kdown_modified_for_kaway(TreeNode root, TreeNode blocker, int k) {
        if (root == null || k < 0 || root == blocker)
            return;

        if (k == 0) {
            System.out.print(root.val + " ");
            return;
        }

        kdown_modified_for_kaway(root.left, blocker, k - 1);
        kdown_modified_for_kaway(root.right, blocker, k - 1);

    }

    public static ArrayList<TreeNode> r_to_N_path(TreeNode root, int data) {
        if (root == null) {
            return new ArrayList<TreeNode>();
        }

        if (root.val == data) {
            ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }

        ArrayList<TreeNode> left = r_to_N_path(root.left, data);
        if (left.size() != 0) {
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right = r_to_N_path(root.right, data);
        if (right.size() != 0) {
            right.add(root);
            return right;
        }

        return new ArrayList<TreeNode>();
    }

    public static void kway(TreeNode root, int data, int k) {
        ArrayList<TreeNode> path = r_to_N_path(root, data);
        for (int i = 0; i < path.size(); i++) {
            kdown_modified_for_kaway(path.get(i), i == 0 ? null : path.get(i - 1), k - i);

        }

    }

    static int height_x;
    static int height_y;
    static TreeNode par_x;
    static TreeNode par_y;

    public boolean isCousins(TreeNode root, int x, int y) {

        height_x = 0;
        height_y = 0;
        par_x = root;
        par_y = root;

        helper_cousin(root, root, x, y, 0);

        if (height_x == height_y && par_x != par_y)
            return true;

        return false;

    }

    public static void helper_cousin(TreeNode root, TreeNode par, int x, int y, int height) {
        if (root == null)
            return;

        if (root.val == x) {
            par_x = par;
            height_x = height;
        }
        if (root.val == y) {
            par_y = par;
            height_y = height;
        }

        helper_cousin(root.left, root, x, y, height + 1);
        helper_cousin(root.right, root, x, y, height + 1);

    }

    static int dia = 0;

    public static int diameter(TreeNode root) {
        if (root == null)
            return -1;

        int lh = diameter(root.left);
        int rh = diameter(root.right);

        dia = Math.max(dia, lh + rh + 2);

        return Math.max(lh, rh) + 1;
    }

    public static int[] diameterbyArr(TreeNode root) {
        if (root == null)
            return new int[] { -1, 0 };

        int[] left_pair = diameterbyArr(root.left);
        int[] right_pair = diameterbyArr(root.right);

        int[] arr_pair = new int[2];
        arr_pair[0] = Math.max(left_pair[0], right_pair[0]) + 1;
        arr_pair[1] = Math.max(left_pair[0] + right_pair[0] + 2, Math.max(left_pair[1], right_pair[1]));

        return arr_pair;

    }

    static int lol = 0;

    public static int leaf_to_leaf_sum(TreeNode root) {
        sum_up_to_leaf(root);
        return -1;
    }

    public static int sum_up_to_leaf(TreeNode root) {
        if (root == null)
            return 0;

        int left = sum_up_to_leaf(root.left);
        int right = sum_up_to_leaf(root.right);

        lol = Math.max(lol, left + right + root.val);

        return Math.max(right, left) + root.val;
    }

    public static boolean hasPathSum_root_to_leaf(TreeNode root, int target) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && target - root.val == 0)
            return true;

        boolean res = false;

        res = res || hasPathSum_root_to_leaf(root.left, target - root.val)
                || hasPathSum_root_to_leaf(root.right, target);

        return res;
    }

    public static boolean hasPathSum_root_to_node(TreeNode root, int target) {
        if (root == null)
            return false;

        if (target - root.val == 0)
            return true;

        boolean res = false;

        res = res || hasPathSum_root_to_node(root.left, target - root.val)
                || hasPathSum_root_to_node(root.right, target - root.val);

        return res;

    }

    static int minHeight = Integer.MAX_VALUE; // in height we pass 0;

    public static void min_height(TreeNode root, int height)// edges
    {
        if (root == null)
            return;

        if (root.left == null && root.right == null && height < minHeight) {
            minHeight = height;
            return;
        }

        min_height(root.left, height + 1);
        min_height(root.right, height + 1);

    }

    public static int minHeight_without_static(TreeNode root) {
        if (root == null)
            return -1;
        int left = minHeight_without_static(root.left);
        int right = minHeight_without_static(root.right);

        return left == -1 ? right + 1 : right == -1 ? left + 1 : Math.min(left, right) + 1;

    }

    static int min_depth_nodes = Integer.MAX_VALUE;

    public static void min_depth_means_nodes(TreeNode root, int height) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && height < min_depth_nodes) {
            min_depth_nodes = height;
            return;
        }

        min_depth_means_nodes(root.left, height + 1);
        min_depth_means_nodes(root.right, height + 1);

    }

    public static int min_depth_nodes_without_static(TreeNode root) {
        if (root == null)
            return 0;

        int left = min_depth_nodes_without_static(root.left);
        int right = min_depth_nodes_without_static(root.right);

        return left == 0 ? right + 1 : right == 0 ? left + 1 : Math.min(left, right) + 1;

    }

    public static void preOrdertraversalRec(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preOrdertraversalRec(root.left);
        preOrdertraversalRec(root.right);
    }

    public static void inOrdertraversalRec(TreeNode root) {
        if (root == null)
            return;

        inOrdertraversalRec(root.left);
        System.out.print(root.val + " ");
        inOrdertraversalRec(root.right);

    }

    public static void postOrdertraversalRec(TreeNode root) {
        if (root == null)
            return;

        postOrdertraversalRec(root.left);
        postOrdertraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    public static void preOrdertravITR(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || st.size() != 0) {
            while (curr != null) {
                st.push(curr);
                System.out.print(curr.val + " ");
                curr = curr.left;
            }

            curr = st.pop();
            curr = curr.right;
        }
    }

    public static void inOrdertravITR(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while (curr != null || st.size() != 0) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;

        }
    }

    public static boolean isSymmtericTree(TreeNode root) {
        // other name is MIRROR TREE
        // 1 tree
        return symmetric_helper(root, root);
    }

    public static boolean symmetric_helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if ((root1 == null || root2 == null) || root1.val != root2.val)
            return false;

        boolean res = true;

        res = res && symmetric_helper(root1.left, root2.right) && symmetric_helper(root1.right, root2.left);

        return res;

    }

    public static class pairBST {
        boolean isBST = false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

    }

    public boolean isValidBST(TreeNode root) {

        pairBST res = IsValidHelper(root);
        return res.isBST;

    }

    public static pairBST IsValidHelper(TreeNode root) {

        if (root == null) {
            pairBST bp = new pairBST();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;

            return bp;

        }

        pairBST lp = IsValidHelper(root.left);
        pairBST rp = IsValidHelper(root.right);

        pairBST mp = new pairBST();

        mp.isBST = (root.val > lp.max && root.val < rp.min) && lp.isBST && rp.isBST;
        mp.min = Math.min(root.val, Math.min(lp.min, rp.min));
        mp.max = Math.max(root.val, Math.max(lp.max, rp.max));

        return mp;

    }

    public static boolean isSameShape(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        boolean res = true;

        res = res && isSameShape(root1.left, root2.left) && isSameShape(root1.right, root2.right);

        return res;

    }

    static boolean isbinary_or_not;

    public static boolean isBinaryBalance(TreeNode root) {
        isbinary_or_not = true;
        helper_height_for_is_balance(root);
        return isbinary_or_not;
    }

    public static int helper_height_for_is_balance(TreeNode root) {
        if (root == null)
            return -1;

        int left_height = helper_height_for_is_balance(root.left);
        int right_height = helper_height_for_is_balance(root.right);

        if (Math.abs(left_height - right_height) > 1)
            isbinary_or_not = false;

        return Math.max(left_height, right_height) + 1;

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null)
            return t2;
        else if (t1 != null && t2 == null)
            return t1;

        TreeNode[] ans = helper_merge_tree(t1, t2);
        return ans[0];
    }

    public static TreeNode[] helper_merge_tree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null)
            return new TreeNode[] { t1, t2 };

        TreeNode[] left = helper_merge_tree(t1.left, t2.left);
        TreeNode[] right = helper_merge_tree(t1.right, t2.right);

        t1.val = t1.val + t2.val;
        if (left[0] == null && left[1] != null)
            t1.left = left[1];
        if (right[0] == null && right[1] != null)
            t1.right = right[1];

        return new TreeNode[] { t1, t2 };

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return creatMaxBST(nums, 0, nums.length);

    }

    public static TreeNode creatMaxBST(int[] nums, int st, int end) {
        if (st == end)
            return null;

        int maxidx = findMaxIdx(nums, st, end);
        TreeNode root = new TreeNode(nums[maxidx]);
        root.left = creatMaxBST(nums, st, maxidx);
        root.right = creatMaxBST(nums, maxidx + 1, end);

        return root;

    }

    public static int findMaxIdx(int[] nums, int st, int end) {
        int max_idx = st;
        for (int i = st; i < end; i++) {
            if (nums[i] > nums[max_idx]) {
                max_idx = i;
            }
        }
        return max_idx;

    }

    static int sum_left;

    public int sumOfLeftLeaves(TreeNode root) {
        sum_left = 0;
        helper_left_leaf_sum(root, false);
        return sum_left;

    }

    public static void helper_left_leaf_sum(TreeNode root, boolean iamLeft) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && iamLeft)
            sum_left += root.val;

        helper_left_leaf_sum(root.left, true);
        helper_left_leaf_sum(root.right, false);

    }

    static int Sum;

    public int sumNumbers(TreeNode root) {
        Sum = 0;
        helper_sum_number(root, 0);

        return Sum;

    }

    public static void helper_sum_number(TreeNode root, int sumVal) {
        if (root == null)
            return;

        sumVal = sumVal * 10 + root.val;
        if (root.left == null && root.right == null)
            Sum += sumVal;

        helper_sum_number(root.left, sumVal);
        helper_sum_number(root.right, sumVal);

    }

    public static void basic_funct(TreeNode root) {
        // System.out.println(size(root));
        // System.out.println(height(root));
        // System.out.println(find(root, 20));
        // System.out.println(min(root));
        // System.out.println(max(root));

        // ArrayList<Integer>path=node_to_root_path(root,20);
        // for(int i: path)
        // System.out.print(i+" ");
        // ArrayList<Integer> path2 = node_to_root_path(root, 30);
        // for (int i : path2)
        // System.out.print(i + " ");
        // System.out.println(LCA(root, 100, 70));
        // level_order(root);
        // kway(root, 20, 2);

        // diameter(root);
        // System.out.println(dia);
        // System.out.println(diameterbyArr(root)[1]);

        // leaf_to_leaf_sum(root);
        // System.out.println(lol);

        preOrdertraversalRec(root);
        System.out.println();
        preOrdertravITR(root);

        System.out.println();

        inOrdertraversalRec(root);
        System.out.println();
        inOrdertravITR(root);

    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, -1, -1, 50, -1, -1, 160, -1, -1, 70, -6, 90, 100, -1, -1, -1, 110, 120, -1, -1,
                -1, 130, -1, -1 };

        TreeNode root = creatBinaryTree(arr);
        // TreeNode root = creatBinaryItr(arr);
        // display(root);
        basic_funct(root);

    }
}