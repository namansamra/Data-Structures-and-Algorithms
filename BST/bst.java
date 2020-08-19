import java.util.*;

//IMPORTANT NOTE::::::::::::::::IF YOU WANT TO DONE THINGS IN INCREASING ORDER THEN DO IT IN INORDER TRAVERSAL::::::::::::::::::::::::::::::::::
//-----------------------------------------------------------------------------------------------------------------------------------------------

public class bst {

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

    public static TreeNode constructBST(int[] arr, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = st + (end - st) / 2;
        TreeNode root = new TreeNode(arr[mid]);

        root.left = constructBST(arr, st, mid - 1);
        root.right = constructBST(arr, mid + 1, end);

        return root;

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

    // static int size=0;
    // static int sum=0;
    // static int height=0;
    // static int min=Integer.MAX_VALUE;
    // static int max=Integer.MIN_VALUE
    public static int size(TreeNode root) {
        if (root == null)
            return 0;

        int ls = size(root.left);
        int rs = size(root.right);

        return ls + rs + 1;

    }

    public static int sum(TreeNode root) {
        if (root == null)
            return 0;

        int lsum = sum(root.left);
        int rsum = sum(root.right);

        return lsum + rsum + root.val;
    }

    public static int height(TreeNode root) {
        if (root == null)
            return -1;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static int min(TreeNode root) {
        if (root.left == null)
            return root.val;

        return min(root.left);

    }

    public static int max(TreeNode root) {
        if (root.right == null)
            return root.val;

        return max(root.right);

    }

    public static boolean find(TreeNode root, int data) {
        if (root == null)
            return false;
        if (data == root.val)
            return true;

        boolean res = false;
        if (data < root.val) {
            res = res || find(root.left, data);
        } else {
            res = res || find(root.right, data);
        }

        return res;

    }

    public static TreeNode add_NODE(TreeNode root, int data) {
        if (root == null) {
            TreeNode child = new TreeNode(data);
            return child;
        }

        if (data < root.val) {
            root.left = add_NODE(root.left, data);
        } else {
            root.right = add_NODE(root.right, data);
        }
        return root;

    }

    // public static TreeNode maxleft(TreeNode root) {

    // }

    public static TreeNode remove_NODE(TreeNode root, int data) {
        if (root == null)
            return null;

        if (data == root.val) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                return root.left != null ? root.left : root.right;
            } else {
                int leftmax = max(root.left);
                root.val = leftmax;
                root.left = remove_NODE(root.left, leftmax);
                return root;
            }
        }

        if (data < root.val) {
            root.left = remove_NODE(root.left, data);
        } else if (data > root.val) {
            root.right = remove_NODE(root.right, data);
        }

        return root;
    }

    static int sum = 0;
    static int sumforNext = 0;

    public static void replace_sum_of_larger_BST(TreeNode root) {
        if (root == null)
            return;

        replace_sum_of_larger_BST(root.right);

        int valof_root = root.val;
        root.val = sumforNext;
        sumforNext += valof_root;

        replace_sum_of_larger_BST(root.left);

    }

    public static ArrayList<TreeNode> node_to_root_path(TreeNode root, int data) {

        if (root.val == data) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }

        if (data < root.val) {
            ArrayList<TreeNode> left = node_to_root_path(root.left, data);
            left.add(root);
            return left;

        } else if (data > root.val) {
            ArrayList<TreeNode> right = node_to_root_path(root.right, data);
            right.add(root);
            return right;
        }

        return new ArrayList<>();
    }

    public static int LCA_in_BST(TreeNode root, int data1, int data2) {
        ArrayList<TreeNode> path1 = node_to_root_path(root, data1);
        ArrayList<TreeNode> path2 = node_to_root_path(root, data2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0) {

            if (path1.get(i) != path2.get(j))
                break;

            i--;
            j--;

        }

        return path1.get(i + 1).val;

    }

    public static int LCA_IN_BST2(TreeNode root, int data1, int data2) {

        if (root.val < data1 && root.val < data2) {
            return LCA_IN_BST2(root.left, data1, data2);
        } else if (root.val > data1 && root.val > data2) {
            return LCA_IN_BST2(root.right, data1, data2);
        } else {
            return root.val;
        }

    }

    public static void printRange(TreeNode root, int min, int max) { // my approach
        if (root == null)
            return;
        if (min < root.val) {
            printRange(root.left, min, max);
        }
        if (min <= root.val && root.val <= max) {
            System.out.print(root.val + " ");
        }
        if (max > root.val) {
            printRange(root.right, min, max);
        }
    }

    public static void printRange2(TreeNode root, int min, int max) {
        if (root == null)
            return;

        if (min < root.val && max < root.val) {
            printRange2(root.left, min, max);
        } else if (min > root.val && max > root.val) {
            printRange2(root.right, min, max);
        } else {
            printRange2(root.left, min, max);
            System.out.println(root.val);
            printRange2(root.right, min, max);
        }
    }

    public static void travelAndPrint(TreeNode root, TreeNode node, int target) {// can print not unique eg. 25 50 and
                                                                                 // 50 25
        if (node == null)
            return;

        travelAndPrint(root, node.left, target);
        int val = node.val;
        int comple = target - val;
        if (find(root, comple)) {
            System.out.println(val + " " + comple);
        }
        travelAndPrint(root, node.right, target);

    }

    public static void travelAndPrintUniquePair(TreeNode root, TreeNode node, int target) {
        if (node == null)
            return;

        travelAndPrintUniquePair(root, node.left, target);
        int val = node.val;
        int comple = target - val;
        if (comple > val) {
            if (find(root, comple)) {
                System.out.println(val + " " + comple);
            }
        }
        travelAndPrintUniquePair(root, node.right, target);

    }

    public static void travel_and_fill(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;

        travel_and_fill(root.left, list);
        list.add(root.val);
        travel_and_fill(root.right, list);

    }

    public static void printpairs(ArrayList<Integer> list, int target) {
        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            int Ele1 = list.get(i);
            int Ele2 = list.get(j);
            int sum = Ele1 + Ele2;
            if (sum == target) {
                System.out.println(Ele1 + " " + Ele2);
                i++;
                j--;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
    }

    public static class BTPair {
        TreeNode node = null;
        int state = 0;

        BTPair(TreeNode node, int state) {
            this.node = node;
            this.state = state;

        }
    }

    public static void bestApprochForPair(TreeNode root, int target) {
        Stack<BTPair> ls = new Stack<>();
        Stack<BTPair> rs = new Stack<>();

        ls.add(new BTPair(root, 0));
        rs.add(new BTPair(root, 0));

        TreeNode left = getNextFromNormalInOrder(ls);
        TreeNode right = getNextFromReverseInOrder(rs);

        while (left.val < right.val) {
            if (left.val + right.val < target) {
                left = getNextFromNormalInOrder(ls);
            } else if (left.val + right.val > target) {
                right = getNextFromReverseInOrder(rs);
            } else {
                System.out.println(left.val + " " + right.val);
                left = getNextFromNormalInOrder(ls);
                right = getNextFromReverseInOrder(rs);
            }

        }

    }

    public static TreeNode getNextFromNormalInOrder(Stack<BTPair> st) {
        while (st.size() != 0) {
            BTPair top = st.peek();
            if (top.state == 0) {
                if (top.node.left != null) {
                    st.push(new BTPair(top.node.left, 0));
                }
                top.state++;

            } else if (top.state == 1) {
                if (top.node.right != null) {
                    st.push(new BTPair(top.node.right, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }

        return null;

    }

    public static TreeNode getNextFromReverseInOrder(Stack<BTPair> st) {
        while (st.size() != 0) {
            BTPair top = st.peek();
            if (top.state == 0) {
                if (top.node.right != null) {
                    st.push(new BTPair(top.node.right, 0));
                }
                top.state++;

            } else if (top.state == 1) {
                if (top.node.left != null) {
                    st.push(new BTPair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }

        return null;

    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;

        if (R < root.val)
            return trimBST(root.left, L, R);
        else if (L > root.val)
            return trimBST(root.right, L, R);
        else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }

    }

    // ----------------------------------------------------------------------------------------------------------------------------------------
    // WTIH EXTRA SPACE
    Integer prev = null;
    int count = 0;
    int maxCount = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return new int[0];

        inorder(root, ans);

        int[] a = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            a[i] = ans.get(i);

        return a;

    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        count = prev == null || prev == root.val ? count + 1 : 1;

        if (count > maxCount) {
            list.clear();
            maxCount = count;
            list.add(root.val);

        } else if (count == maxCount) {
            list.add(root.val);
        }

        prev = root.val;
        inorder(root.right, list);
    }

    ///// WITH EXTRA SPACE
    public int[] findMode2(TreeNode root) {
        if (root == null)
            return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        inorder2(root, map);
        int maxCount = Integer.MIN_VALUE;
        for (int val : map.values()) {
            maxCount = Math.max(maxCount, val);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == maxCount)
                list.add(e.getKey());
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }

    public static void inorder2(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null)
            return;

        inorder2(root.left, map);
        int count = map.getOrDefault(root.val, 0) + 1;
        map.put(root.val, count);
        inorder2(root.right, map);

    }

    // ----------------------------------------------------------------------------------------------------------------------------------------

    public static int[] mergetwoSortedArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                ans[k] = arr1[i];
                i++;

            } else if (arr1[i] > arr2[j]) {
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            ans[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            ans[k] = arr2[j];
            j++;
            k++;
        }

        return ans;
    }

    public static int[] mergeSort(int[] arr, int st, int end) {
        if (st == end) {
            int[] ba = new int[1];
            ba[0] = arr[st];
            return ba;
        }
        int mid = (st + (end - st) / 2);
        int[] fha = mergeSort(arr, st, mid);
        int[] sha = mergeSort(arr, mid + 1, end);

        int[] fullSortedarr = mergetwoSortedArray(fha, sha);

        return fullSortedarr;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 25, 37, 50, 62, 75, 87 };
        TreeNode root = constructBST(arr, 0, arr.length - 1);
        display(root);
        // System.out.println(size(root));
        // System.out.println(sum(root));
        // System.out.println(height(root));
        // System.out.println(min(root));
        // System.out.println(max(root));
        // System.out.println(find(root, 62));

        // System.out.println();
        // remove_NODE(root, 25);
        System.out.println();
        // remove_NODE(root, 50);

        // replace_sum_of_larger_BST(root);
        // display(root);

        // System.out.println(LCA_in_BST(root, 87, 25));

        // printRange(root, 10, 63);
        // travelAndPrint(root, root, 75);
        // System.out.println();
        // travelAndPrintUniquePair(root, root, 75);
        // ArrayList<Integer> list = new ArrayList<>();
        // travel_and_fill(root, list);

        // System.out.println();
        // printpairs(list, 137);

        // bestApprochForPair(root, 137);

        // int[] one = { 1, 4, 5, 6, 7, 8, 10, 13 };
        // int[] two = { 1, 2, 3, 4, 4, 4, 5, 6, 7, 10, 12, 13, 15, 18, 20, 70 };

        // int[] res = mergetwoSortedArray(one, two);
        // for (int i : res) {
        // System.out.print(i + " ");
        // }

        int[] test = { -10, -100, -165, 78, 12, 44, 22, 55, -1, 335, 990, 0, 4, 3, 2, 6, 43, 77, 24, 77 };
        int[] sorted = mergeSort(test, 0, test.length - 1);
        for (int i : sorted) {
            System.out.print(i + " ");
        }

    }
}