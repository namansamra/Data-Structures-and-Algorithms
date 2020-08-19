
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class question {
    public static Scanner scn = new Scanner(System.in);
    public static boolean duplicasyInbracket(String str) {
        Stack<Character> st = new Stack<>();
        int i = 0;

        while (i < str.length()) {

            char ch = str.charAt(i);
            if (ch == ')') {
                if (st.peek() == '(')
                    return true;

                else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else
                st.push(str.charAt(i));

            i++;

        }

        return false;

    }

    public static boolean duplicasyInbracket2(String str) { // nothing just for loop
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (ch == ')') {
                if (st.peek() == '(')
                    return true;

                else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else
                st.push(str.charAt(i));

        }

        return false;

    }

    // the question is somewhat different as we have to ignore the middle characters
    // this approach fails in (a+b)+[c+d]+{e++f} as the + signs
    // in between will be there in stack so i name it experimental
    public static boolean isbalanceEXP(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (st.size() == 0) {
                st.push(ch);
                continue;
            }
            if (ch == ')') {
                while (st.peek() != '(')
                    st.pop();
                st.pop();
            } else if (ch == '}') {
                while (st.peek() != '{')
                    st.pop();
                st.pop();
            } else if (ch == ']') {
                while (st.peek() != '[')
                    st.pop();
                st.pop();
            } else
                st.push(ch);

        }

        return st.size() == 0;
    }

    // solution acoording to question
    public static boolean isbalance(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{' || ch == '<')
                st.push(ch);
            else {
                if (ch == ')') {
                    if (st.size() == 0 || st.peek() != '(')
                        return false;

                    st.pop();
                } else if (ch == ']') {
                    if (st.size() == 0 || st.peek() != '[')
                        return false;

                    st.pop();
                } else if (ch == '}') {
                    if (st.size() == 0 || st.peek() != '{')
                        return false;

                    st.pop();
                } else if (ch == '>') {
                    if (st.size() == 0 || st.peek() != '<')
                        return false;

                    st.pop();
                }
            }

        }

        return st.size() == 0;
    }

    public static int[] nexGreaterOnRight(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0) {
                st.push(i);
                continue;
            }

            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                int idx = st.pop();
                ans[idx] = i;
            }

            st.push(i);
        }

        while (st.size() != 0) {
            int idx = st.pop();
            ans[idx] = arr.length;
        }

        return ans;

    }

    public static int[] nextGreaterOnleft(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (st.size() == 0) {
                st.push(i);
                continue;
            }

            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                int idx = st.pop();
                ans[idx] = i;
            }

            st.push(i);
        }

        while (st.size() != 0) {
            int idx = st.pop();
            ans[idx] = -1;
        }

        return ans;
    }

    public static int[] nexGreaterOnRight2(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (st.size() == 0) {
                st.push(i);
                ans[i] = -1;
                continue;
            }

            while (st.size() != 0 && st.peek() < arr[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public static int[] nextGreaterOnleft2(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0) {
                st.push(i);
                ans[i] = -1;
                continue;
            }

            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                int idx = st.pop();
            }

            if (st.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;

    }

    public static int[] span1(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (st.size() == 0) {
                st.push(i);
                continue;
            }

            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                int idx = st.pop();
                ans[idx] = idx - i;
            }

            st.push(i);
        }

        while (st.size() != 0) {
            int idx = st.pop();
            ans[idx] = idx + 1;
        }

        return ans;

    }

    public static int[] span2(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0) {
                st.push(i);
                ans[i] = 1;
                continue;
            }

            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                int idx = st.pop();
            }

            if (st.size() == 0) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public static int[] nextGreater(int[] arr) {// direct pushing element not index
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (st.size() == 0) {
                st.push(arr[i]);
                ans[i] = -1;
                continue;
            }

            while (st.size() != 0 && st.peek() < arr[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return ans;
    }

    public static int[] nextSmallerOnRight(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0) {
                st.push(i);
                continue;
            }

            while (st.size() != 0 && arr[st.peek()] > arr[i]) {
                int idx = st.pop();
                ans[idx] = i;
            }

            st.push(i);

        }

        while (st.size() != 0) {
            int idx = st.pop();
            ans[idx] = -1;
        }

        return ans;

    }

    public static int[] nextSmallerOnLeft(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (st.size() == 0) {
                st.push(i);
                continue;
            }

            while (st.size() != 0 && arr[st.peek()] > arr[i]) {
                int idx = st.pop();
                ans[idx] = i;
            }

            st.push(i);
        }

        while (st.size() != 0) {
            int idx = st.pop();
            ans[idx] = -1;
        }

        return ans;
    }

    public static void nextGreaterDirectPrint(int[] arr) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            if (st.size() == 0) {
                st.push(val);
                continue;
            }
            while (st.size() != 0 && st.peek() < val) {
                System.out.println("next greater to " + st.pop() + " is " + val);
            }

            st.push(val);
        }
        while (st.size() != 0) {
            System.out.println("next greater to " + st.pop() + " does " + "NOT EXIST");

        }

    }

    public static void nextGreaterINCREASING_OREDER(int[] arr) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            if (st.size() == 0) {
                st.push(val);
                continue;
            }

            while (st.size() != 0 && st.peek() < val) {
                map.put(st.pop(), val);
            }

            st.push(val);
        }
        while (st.size() != 0) {
            map.put(st.pop(), -1);
        }

        for (Map.Entry<Integer, Integer> v : map.entrySet()) {
            System.out.println(v.getKey() + " -> " + v.getValue());
        }
    }

    public static int[] nextSmallerOnRightModifiedForHisto(int[] arr) {// for no smaller on rigt we put arr.length not
                                                                       // -1

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0) {
                st.push(i);
                continue;
            }

            while (st.size() != 0 && arr[st.peek()] > arr[i]) {
                int idx = st.pop();
                ans[idx] = i;
            }

            st.push(i);

        }

        while (st.size() != 0) {
            int idx = st.pop();
            ans[idx] = arr.length;
        }

        return ans;
    }

    public static int histogram(int[] arr) {

        int[] rb = nextSmallerOnRightModifiedForHisto(arr);
        int[] lb = nextSmallerOnLeft(arr);

        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static int[] nexGreaterOnRightForsliding(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0) {
                st.push(i);
                continue;
            }

            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                int idx = st.pop();
                ans[idx] = i;
            }

            st.push(i);
        }

        while (st.size() != 0) {
            int idx = st.pop();
            ans[idx] = arr.length;
        }

        return ans;

    }

    public static void slidingWindowMax(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] ngor = nexGreaterOnRightForsliding(arr);
        int i = 0;
        while (i + 4 <= arr.length) {
            int j = i;

            while (j < i + 4) {
                if (ngor[j] >= i + 4) {
                    list.add(arr[j]);
                    break;
                } else
                    j++;
            }

            // while (ngor[j] < i + 4) {
            // j = ngor[j];
            // }
            // list.add(arr[j]);
            i++;
        }

        for (int k : list) {
            System.out.print(k + " ");
        }

    }

    public static void infix2(String str) {// my code

        Stack<Integer> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch))
                st1.push(ch - '0');
            else {
                if (ch == '(')
                    st2.push(ch);

                else {
                    if (ch == ')') {
                        while (st2.peek() != '(') {
                            char op = st2.pop();

                            int up = st1.pop();
                            int down = st1.pop();
                            int val = operation(down, up, op);
                            st1.push(val);
                        }
                        st2.pop();
                    } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                        while (st2.size() != 0 && st2.peek() != '(' && precedence(ch) <= precedence(st2.peek())) {
                            char op = st2.pop();

                            int up = st1.pop();
                            int down = st1.pop();
                            int val = operation(down, up, op);
                            st1.push(val);

                        }
                        st2.push(ch);
                    }

                }

            }

        }

        while (st2.size() != 0) {
            char op = st2.pop();

            int up = st1.pop();
            int down = st1.pop();
            int val = operation(down, up, op);
            st1.push(val);
        }

        System.out.println(st1.peek());
    }

    public static int precedence(char ch) {
        if (ch == '+')
            return 1;
        else if (ch == '-')
            return 1;

        else if (ch == '*')
            return 2;

        else
            return 2;
    }

    public static int operation(int down, int up, char ch) {
        if (ch == '+')
            return down + up;
        else if (ch == '-')
            return down - up;

        else if (ch == '*')
            return down * up;

        else
            return down / up;
    }

    public static void infix(String str) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch))
                st1.push(ch - '0');

            else if (ch == '(')
                st2.push(ch);

            else if (ch == ')') {
                while (st2.peek() != '(') {
                    char op = st2.pop();

                    int up = st1.pop();
                    int down = st1.pop();
                    int val = operation(down, up, op);
                    st1.push(val);
                }
                st2.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (st2.size() != 0 && st2.peek() != '(' && precedence(ch) <= precedence(st2.peek())) {
                    char op = st2.pop();

                    int up = st1.pop();
                    int down = st1.pop();
                    int val = operation(down, up, op);
                    st1.push(val);

                }
                st2.push(ch);
            }

        }

        while (st2.size() != 0) {
            char op = st2.pop();

            int up = st1.pop();
            int down = st1.pop();
            int val = operation(down, up, op);
            st1.push(val);
        }

        System.out.println(st1.peek());
    }

    public static void Pre_to_PostInConversion(String str) {
        Stack<Integer> val = new Stack<>();
        Stack<String> in = new Stack<>();
        Stack<String> post = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                val.push(ch - '0');
                in.push(ch + "");
                post.push(ch + "");
            } else {

                int val1 = val.pop(); // *******/ see the change we have take value popped first as val1;
                int val2 = val.pop();

                String in1 = in.pop();
                String in2 = in.pop();

                String post1 = post.pop();
                String post2 = post.pop();

                int val_to_put = operation(val1, val2, ch);
                val.push(val_to_put);

                String in_to_put = "(" + in1 + ch + in2 + ")";
                in.push(in_to_put);

                String pre_to_put = post1 + post2 + ch;
                post.push(pre_to_put);

            }
        }

        System.out.println(val.pop());
        System.out.println(in.pop());
        System.out.println(post.pop());
    }

    public static void In_to_prefixPostConversion(String str) {
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(')
                op.push(ch);
            else if (ch == ')') {
                while (op.peek() != '(') {
                    char opr = op.pop();
                    String up1 = pre.pop();
                    String down1 = pre.pop();

                    String up2 = post.pop();
                    String down2 = post.pop();

                    pre.push(opr + down1 + up1);
                    post.push(down2 + up2 + opr);
                }
                op.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (op.size() != 0 && op.peek() != '(' && precedence(ch) <= precedence(op.peek())) {
                    char opr = op.pop();
                    String up1 = pre.pop();
                    String down1 = pre.pop();

                    String up2 = post.pop();
                    String down2 = post.pop();

                    pre.push(opr + down1 + up1);
                    post.push(down2 + up2 + opr);
                }

                op.push(ch);
            } else {
                pre.push(ch + "");
                post.push(ch + "");
            }

        }

        while (op.size() != 0) {
            char opr = op.pop();
            String up1 = pre.pop();
            String down1 = pre.pop();

            String up2 = post.pop();
            String down2 = post.pop();

            pre.push(opr + down1 + up1);
            post.push(down2 + up2 + opr);
        }

        System.out.println(pre.pop());
        System.out.println(post.pop());
    }

    public static void Post_to_PreInConversion(String str) {
        Stack<Integer> val = new Stack<>();
        Stack<String> in = new Stack<>();
        Stack<String> pre = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                val.push(ch - '0');
                in.push(ch + "");
                pre.push(ch + "");
            } else {

                int val2 = val.pop();
                int val1 = val.pop();

                String in2 = in.pop();
                String in1 = in.pop();

                String pre2 = pre.pop();
                String pre1 = pre.pop();

                int val_to_put = operation(val1, val2, ch);
                val.push(val_to_put);

                String in_to_put = "(" + in1 + ch + in2 + ")";
                in.push(in_to_put);

                String pre_to_put = ch + pre1 + pre2;
                pre.push(pre_to_put);

            }

        }

        System.out.println(val.pop());
        System.out.println(in.pop());
        System.out.println(pre.pop());

    }

    public static int findCelebrity(int[][] arr) { // my code :D
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while (st.size() != 1) {
            int up = st.pop();
            int down = st.pop();

            if (arr[up][down] == 0) {
                st.push(up);
            } else if (arr[down][up] == 0)
                st.push(down);

        }

        System.out.println(st.peek());

        boolean ans = true;
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[st.peek()][i] == 1 && i != st.peek()) {
                ans = false;
                break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][st.peek()] != 1 && i != st.peek()) {
                ans = false;
                break;
            }
        }

        return ans == true ? st.peek() : -1;

    }

    // PERFECT SOLUTION
    public static int findCelebrityOpti(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++)
            st.push(i);

        while (st.size() != 1) {
            int potenCeleb = st.pop();
            int j = st.pop();

            if (arr[potenCeleb][j] == 1) {
                // potential celeb knows j so potenCeleb is not a celeb
                st.push(j);
            } else {
                // potemtial celeb doesnot knows j thus j is not celeb
                st.push(potenCeleb);
            }

        }

        boolean ans = true;
        int finalpotenCeleb = st.pop(); // finalist in potential celebrity

        for (int i = 0; i < arr.length; i++) {
            if (i != finalpotenCeleb) {
                if (arr[finalpotenCeleb][i] == 1 || arr[i][finalpotenCeleb] == 0) {
                    ans = false;
                    break;
                }
            }
        }

        return ans == true ? finalpotenCeleb : -1;

    }

    public static class Pair implements Comparable<Pair> {
        int st;
        int end;

        Pair() {
            this.st = 0;
            this.end = 0;

        }

        Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }

        // this>other return +
        // this=other return 0
        // this<other return -1

        public int compareTo(Pair other) {
            if (this.st != other.st) {
                return this.st - other.st;
            } else {
                return this.end - other.end;
            }
        }

    }

    public static void mergeInvervals(int[][] arr) { // MY METHOD :D
        Stack<Pair> st = new Stack<>();
        Pair[] pairs = new Pair[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);
        for (int i = pairs.length - 1; i >= 0; i--) {
            Pair p = pairs[i];
            if (st.size() == 0) {
                st.push(p);
                continue;
            } else {
                Pair top = st.peek();
                int intersec = Math.max(top.st, p.st) - Math.min(top.end, p.end);// intersection is taken to check the
                                                                                 // commmmon area
                                                                                 // intersection=max(st)-main(end) time
                if (intersec > 0) {
                    st.push(p);
                } else {
                    Pair newEle = new Pair();
                    while (st.size() != 0 && intersec <= 0) {
                        newEle.st = Math.min(st.peek().st, p.st);
                        newEle.end = Math.max(st.peek().end, p.end);
                        st.pop();
                        if (st.size() != 0) {
                            intersec = Math.max(st.peek().st, p.st) - Math.min(st.peek().end, p.end);
                        }

                    }
                    st.push(newEle);

                }

            }
        }

        while (st.size() != 0) {
            Pair ans = st.pop();
            System.out.println(ans.st + " " + ans.end);
        }

    }

    public static void mergeIntervalsPerfect(int[][] arr) {
        Stack<Pair> st = new Stack<>();

        Pair[] pairs = new Pair[arr.length];

        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);

        for (int i = 0; i < pairs.length; i++) {
            Pair p = pairs[i];
            if (i == 0) {
                st.push(p);
            } else if (p.st > st.peek().end) {
                st.push(p);
            } else if (p.st <= st.peek().end) {
                Pair top = st.peek();
                top.end = Math.max(top.end, p.end);
            }

        }

        // now stack is filled but we want it st in increasing oreder so pop and
        // stodring st elements
        Stack<Pair> ans = new Stack<>();
        while (st.size() != 0) {
            ans.push(st.pop());
        }

        while (ans.size() != 0) {
            Pair ele = ans.pop();
            System.out.println(ele.st + " " + ele.end);
        }

    }

    public static void SmallestNumFollowingPattern(String str) {
        Stack<Integer> st = new Stack<>();
        int val = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'd') {
                st.push(val);
                val++;
            } else {
                st.push(val);
                val++;
                while (st.size() != 0) {
                    System.out.print(st.pop());
                }
            }

        }

        st.push(val);
        while (st.size() != 0) {
            System.out.print(st.pop());
        }
    }

    public String reverseParentheses(String s) {
        int openidx = -1; // index of last open bracket in open arr
        int[] open = new int[(s.length() + 1) / 2]; // array to store the positions of open brackets
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(")) {
                arr[i] = ""; // to remove "("
                openidx++; // incrementing openidx to store index in open arr
                open[openidx] = i;// storing index of open bracket
            } else if (arr[i].equals(")")) { // we got ")"
                arr[i] = ""; // to remove ")"
                swap(arr, open[openidx], i); // now reversing the chars
                openidx--; // decrement the openidx so we got to know the last open idx now.
            }
        }

        return String.join("", arr);

    }

    public void swap(String[] arr, int st, int end) {
        while (st < end) {
            String temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] arr = { 1, 2, 9, 7, 8, 1, 2, 3, 10, 7, 4, 5, 6, 9, 6 };
        // int[] arr={10,1,2,3,5};
        // String test = "((a+b)+(c+d))";
        // System.out.println(duplicasyInbracket(test));
        // System.out.println(duplicasyInbracket2(test));
        // nextGreater(arr);
        // int[]ans=nextGreaterBEST_and_intuitive(arr);
        // int[] ans = nextGreaterOnleft(arr);
        // for (int i : ans) {
        // System.out.print(i + " ");
        // }
        // System.out.println();
        // int[] ans2=nextGreaterOnleft2(arr);
        // for(int i:ans2){
        // System.out.print(i+" ");
        // }

        // int[] ans2 = nextGreaterOnleft2(arr);
        // for (int i : ans2) {
        // System.out.print(i + " ");
        // }

        // int[] a = { 10, 1, 4, 2, 4, 1, 11 };
        // int[] ans2 = nextSmallerOnRight(a);
        // for (int i : ans2) {
        // System.out.print(i + " ");
        // }
        // System.out.println();

        // int[] ans3 = nextSmallerOnLeft(a);
        // for (int i : ans3) {
        // System.out.print(i + " ");
        // }

        // int[] a = { 2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6 };
        // slidingWindowMax(a);

        // infix2("2+(5-3*6/2)");
        // String str = "a*(b-c+d)/e";
        // prefixPostfix(str);

        // int[][] test = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0
        // } };

        // int a = findCelebrity(test);
        // System.out.println(a);

        // int[][] merge = { { 1, 8 }, { 5, 12 }, { 14, 38 }, { 22, 24 }, { 26, 30 }, { 27, 31 }, { 90, 98 } };
        // int[][] a = { { 1, 8 }, { 5, 12 }, { 14, 19 }, { 22, 28 }, { 25, 27 }, { 27, 30 } };
        // int[][] b = { { 1, 8 }, { 2, 4 }, { 5, 12 }, { 14, 19 }, { 16, 21 }, { 19, 20 }, { 22, 28 }, { 23, 28 },
        //         { 25, 27 }, { 27, 30 } };
        // // mergeInvervals(b);
        // mergeIntervalsPerfect(b);

        System.out.println('A'-'A');
        System.out.println('a'-'a');

        int n=scn.ne
    }

}