import java.util.*;

public class generictree {
    public static class TreeNode {
        int val;
        ArrayList<TreeNode> children = new ArrayList<>();

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode creatGenericTree(int[] arr) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1)
                st.pop();
            else {
                TreeNode temp = new TreeNode();
                temp.val = arr[i];

                if (st.size() > 0) {
                    TreeNode top = st.peek();
                    top.children.add(temp);
                } else {
                    root = temp;
                }

                st.push(temp);
            }
        }
        return root;

    }

    public static void displayGenericTree(TreeNode root) {
        String str = "";
        str += root.val + " " + "=>" + " ";
        for (int i = 0; i < root.children.size(); i++)
            str += root.children.get(i).val + " ";

        System.out.println(str);

        for (TreeNode child : root.children)
            displayGenericTree(child);

    }

    public static int size(TreeNode root) {
        int sum_child = 0;
        for (int i = 0; i < root.children.size(); i++)
            sum_child += size(root.children.get(i));

        return sum_child + 1;

    }

    public static int max(TreeNode root) {
        int max_child = Integer.MIN_VALUE;

        for (TreeNode child : root.children)
            max_child = Math.max(max_child, max(child));

        return Math.max(root.val, max_child);

    }

    public static int height(TreeNode root) {
        if (root == null) // just for null check means if root is given null  """DONOT FORGET THIS THIS WILL HURT IN LEETCODE"""
            return 0;
        int height = -1;
        for (TreeNode child : root.children)
            height = Math.max(height, height(child));

        return height + 1;
    }

    public static void preOrder(TreeNode root) {

        System.out.print(root.val + " ");
        for (TreeNode child : root.children)
            preOrder(child);
    }

    public static void postOrder(TreeNode root) {

        for (TreeNode child : root.children)
            postOrder(child);

        System.out.print(root.val + " ");
    }

    public static void prePostQues(TreeNode root) {

        System.out.println("NodePre =>" + root.val);
        for (TreeNode child : root.children) {
            System.out.println("PreEdge " + root.val + "-> " + child.val);
            prePostQues(child);
            System.out.println("PostEdge " + root.val + "-> " + child.val);

        }

        System.out.println("NodePost =>" + root.val);

    }

    public static void leverlOrderinSingleLine(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (que.size() != 0) {
            TreeNode head = que.poll();
            System.out.print(head.val + " ");
            for (TreeNode child : head.children)
                que.add(child);
        }
    }

    public static void levelOrder(TreeNode root) {  //if we have to return arraylist always take care of (root==null) see leetcode of N-tree level order.
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (que.size() != 0) {

            int size = que.size();
            while (size-- > 0) {
                TreeNode head = que.poll();
                System.out.print(head.val + " ");
                for (TreeNode child : head.children)
                    que.add(child);
            }

            System.out.println();

        }
    }

    public static void levelOrderusingtwoQues(TreeNode root) {
        Queue<TreeNode> mq = new ArrayDeque<>();
        mq.add(root);
        Queue<TreeNode> cq = new ArrayDeque<>();

        while (mq.size() != 0) {
            TreeNode par = mq.poll();
            System.out.print(par.val + " ");
            for (TreeNode child : par.children)
                cq.add(child);

            if (mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public static void levelOrderZigZag(TreeNode root) {

        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        int level = 1;
        ms.push(root);
        while (ms.size() != 0) {
            TreeNode top = ms.pop();
            System.out.print(top.val + " ");

            if (level % 2 == 1) {
                for (int i = 0; i < top.children.size(); i++)
                    cs.push(top.children.get(i));

            } else {
                for (int i = top.children.size() - 1; i >= 0; i--)
                    cs.push(top.children.get(i));
            }

            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }

    }

    public static TreeNode removeLeaves(TreeNode root) {// new Tree
        if (root.children.size() == 0) {
            return null;
        }

        TreeNode node = new TreeNode();
        node.val = root.val;

        for (TreeNode child : root.children) {
            TreeNode c = removeLeaves(child);
            if (c != null)
                node.children.add(c);
        }

        return node;
    }

    public static TreeNode removeLeaves2(TreeNode root) {/// change in same root
        if (root.children.size() == 0) {
            return null;
        }
        for (int i = root.children.size() - 1; i >= 0; i--) {   //loop is reverse because if we remove one element form arraylist all that list ele shifts to front by one for more see sumit sir video GT
            TreeNode c = removeLeaves2(root.children.get(i));
            if (c == null)
                root.children.remove(root.children.get(i));
        }

        return root;
    }

    public static void removeLeaves3(TreeNode root) {
        for (int i = root.children.size() - 1; i >= 0; i--) {// approach 3 => firstly we remove leaves of root then we assume that children will remove their leaves.
            TreeNode child = root.children.get(i);

            if (child.children.size() == 0)
                root.children.remove(child);
        }

        for (TreeNode child : root.children)
            removeLeaves3(child);

    }

    public static void linearise(TreeNode root) { // O(n2)
        for (TreeNode child : root.children)
            linearise(child);

        for (int i = root.children.size() - 1; i >= 1; i--) {
            TreeNode second_last = root.children.get(i - 1);
            TreeNode last = root.children.remove(i);
            TreeNode tail = getTail(second_last);
            tail.children.add(last);
        }

    }

    public static TreeNode getTail(TreeNode root) {
        TreeNode tail = root;
        while (tail.children.size() != 0) {
            tail = tail.children.get(0);
        }
        return tail;
    }

    public static TreeNode lineariseEfficiently(TreeNode root) { // O(n)
        if (root.children.size() == 0)
            return root;
        TreeNode last_linear_and_tail = lineariseEfficiently(root.children.get(root.children.size() - 1));
        for (int i = root.children.size() - 1; i >= 1; i--) {
            TreeNode last = root.children.remove(i);
            TreeNode second_last = root.children.get(i - 1);
            TreeNode second_last_linear_and_tail = lineariseEfficiently(second_last);
            second_last_linear_and_tail.children.add(last);
        }

        return last_linear_and_tail;

    }

    public static boolean findEle(TreeNode root, int data) {
        if (root.val == data)
            return true;

        boolean res = false;
        for (TreeNode child : root.children)
            res = res || findEle(child, data);

        return res;

    }

    public static ArrayList<TreeNode> node_to_root_path(TreeNode root, int data) {

        if (root.val == data) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }

        for (TreeNode child : root.children) {
            ArrayList<TreeNode> list = node_to_root_path(child, data);
            if (list.size() != 0) {
                list.add(root);
                return list;
            }

        }

        return new ArrayList<>();
    }

    public static int LCA(TreeNode root, int data1, int data2) {
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

    public static int distanceBetweenNodes(TreeNode root, int data1, int data2) {
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

        i++; // to come them at LCA (they define the distance of node from the LCA point);
        j++;

        return i + j;
    }

    public static boolean AreTreesSimilar(TreeNode root1, TreeNode root2) {
        if (root1.children.size() != root2.children.size())
            return false;

        boolean res = true;
        for (int i = 0; i < root1.children.size(); i++) {
            TreeNode child1 = root1.children.get(i);
            TreeNode child2 = root2.children.get(i);
            res = res && AreTreesSimilar(child1, child2);

        }

        return res;

    }

    public static boolean AreMirrorTrees(TreeNode root1, TreeNode root2) {
        if (root1.children.size() != root2.children.size())
            return false;
        boolean res = true;
        int i = root1.children.size() - 1;
        int j = 0;

        while (i >= 0 && j <= root2.children.size() - 1) {
            res = res && AreMirrorTrees(root1.children.get(i), root2.children.get(j));
            i--;
            j++;
        }

        return res;

    }

    public static boolean AreMirrorTrees02(TreeNode root1, TreeNode root2) {
        if (root1.children.size() != root2.children.size())
            return false;
        int i = root1.children.size() - 1;
        int j = 0;

        while (i >= 0 && j < root2.children.size()) {
            boolean res = AreMirrorTrees02(root1.children.get(i), root2.children.get(j));
            if (res == false) {
                return false;
            }
            i--;
            j++;
        }

        return true;

    }

    public static boolean isSymmetricSingleTree(TreeNode root) {
        int i = 0;
        int j = root.children.size() - 1;
        while (i < j) {
            if (root.children.get(i).children.size() != root.children.get(j).children.size())
                return false;

            i++;
            j--;
        }

        boolean res = true;
        for (TreeNode child : root.children)
            res = res && isSymmetricSingleTree(child);

        return res;
    }

    public static boolean isSymmetricSingleTree02(TreeNode root) {
        // NOTE=> if a tree is symmetric in itself then it must be a mirrorTree with
        // itself so we pass the same root to mirror tree function.

        return AreMirrorTrees(root, root);
    }

    static int size = 0;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int height = -1;

    public static void multiSolver(TreeNode root, int depth) {
        size++;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        height = Math.max(height, depth);

        for (TreeNode child : root.children)
            multiSolver(child, depth + 1);

    }

    static TreeNode predecessor = null;
    static TreeNode successor = null;
    static int state = 0;

    public static void prede_and_successor(TreeNode root, int data) {

        if (state == 0) {
            if (root.val == data) {
                state = 1;
            } else {
                predecessor = root;
            }
        } else if (state == 1) {
            successor = root;
            state = 2;
        }

        for (TreeNode child : root.children) {
            prede_and_successor(child, data);

        }

    }

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    public static void ceil_and_floor(TreeNode root, int data) {

        if (root.val > data) {
            ceil = Math.min(ceil, root.val);
        } else if (root.val < data)
            floor = Math.max(floor, root.val);

        for (TreeNode child : root.children)
            ceil_and_floor(child, data);
    }

    public static int KthLargest(TreeNode root, int k) {
        floor = Integer.MIN_VALUE; // in this method we basically find floor k times 1. floor of infity(1st larges)
                                   // 2. floor of 1st floor(means 2nd largest)
                                   // 3. floor of 2nd floor(3rd largest) ...k. floor of k-1 th floor( kth largest)
        int factor = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ceil_and_floor(root, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;

        }
        return factor;
    }

    static PriorityQueue<Integer> pq;

    public static void fill_the_pq(TreeNode root) {
        pq.add(root.val);

        for (TreeNode child : root.children)
            fill_the_pq(child);

    }

    public static int KthLargestUsingPriorityQueue(TreeNode root, int k) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        while (k > 0) {
            ans = pq.poll();
            k--;
        }

        return ans;
    }

    static int maxVal = 0;
    static TreeNode node_with_max_subtree = null;

    public static int node_with_max_subtree(TreeNode root) {

        int sum = 0;
        for (TreeNode child : root.children)
            sum += node_with_max_subtree(child);

        sum += root.val;

        if (sum > maxVal) {
            maxVal = sum;
            node_with_max_subtree = root;
        }

        return sum;
    }

    public static class pair {
        int height = 0;
        int dia = 0;
    }

    // public static pair diameter_of_GT(TreeNode root){
    // if(root.children.size()==0)
    // {
    // pair bp=new pair();
    // bp.height=-1;
    // bp.dia=0;
    // return bp;
    // }

    // pair mp=new pair();
    // for(TreeNode child:root.children)
    // {
    // pair rp=diameter_of_GT(child);
    // mp.height=Math.max(mp.height,rp.height)+1;
    // mp.dia=Math.max(rp.dia,mp.dia);
    // }

    // return mp;

    // }

    static int dia = 0;

    public static int diameter_GT(TreeNode root) {
        int hch = -1; // heighest child
        int shch = -1; // second heighest child

        int ch = 0;
        for (TreeNode child : root.children) {
            ch = diameter_GT(child);

            if (ch > hch) {
                shch = hch;
                hch = ch;
            } else if (ch > shch) {
                shch = ch;
            }

        }

        int candidate = hch + shch + 2;
        if (candidate > dia) {
            dia = candidate;
        }

        return hch + 1;

    }

    public static class pairPrePost {
        int state = -1;
        TreeNode node = null;
    }

    public static void PreOrderGT(TreeNode root) {
        if (root == null)
            return;

        Stack<pairPrePost> st = new Stack<>();
        pairPrePost node = new pairPrePost();
        node.node = root;
        st.push(node);

        String pre = "";
        String post = "";

        while (st.size() != 0) {
            pairPrePost top = st.peek();
            if (top.state == -1) {
                pre += top.node.val + " ";
                top.state++;
            } else if (top.state == top.node.children.size()) {
                post += st.pop().node.val + " ";
            } else {
                TreeNode child = top.node.children.get(top.state);
                pairPrePost topush = new pairPrePost();
                topush.node = child;
                st.push(topush);
                top.state++;
            }
        }

        System.out.println(pre);
        System.out.println(post);

    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        int[] arr2 = { 200, 920, 500, -1, 609, -1, -1, 390, 780, -1, 890, 1108, -1, 1280, -1, -1, 980, -1, -1, -1 };

        // TreeNode root = creatGenericTree(arr);
        // displayGenericTree(root);

        // System.out.println(size(root));
        // System.out.println(max(root));
        // System.out.println(height(root));
        // preOrder(root);
        // System.out.println();
        // postOrder(root);
        // System.out.println();
        // prePostQues(root);

        // leverlOrderinSingleLine(root);
        // System.out.println();
        // levelOrder(root);
        // System.out.println();
        // levelOrderusingtwoQues(root);

        // System.out.println();
        // TreeNode node = removeLeaves(root);
        // displayGenericTree(node);
        // System.out.println();

        // linearise(root);

        // lineariseEfficiently(root);
        // displayGenericTree(root);

        // System.out.println(findEle(root, 120));

        // ArrayList<TreeNode> ans = node_to_root_path(root, 100);
        // for (TreeNode child : ans)
        // System.out.print(child.val + " ");

        // System.out.println(LCA(root, 110, 100));
        // System.out.println(distanceBetweenNodes(root, 110, 70));

        // TreeNode root1 = creatGenericTree(arr);
        // displayGenericTree(root1);
        // TreeNode root2 = creatGenericTree(arr2);
        // displayGenericTree(root2);

        // System.out.println(AreTreesSimilar(root1, root2));

    }
}