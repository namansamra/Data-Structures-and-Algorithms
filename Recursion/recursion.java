import java.util.*;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;



public class recursion {

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter the no.");
        // int n = scn.nextInt();
        // System.out.println(factorial(n));

        // System.out.println(fibonaci(n));

        // printIncreasing(n);
        // System.out.println();
        // printDecreasing(n);

        // int a = scn.nextInt();
        // int b = scn.nextInt();
        // System.out.println(power02(a, b));

        // int n = scn.nextInt();
        // tower_pf_hanoi(n, 'A', 'B', 'C');

        // int[] arr = { 1, 2, 2, 3, 4, 2, 2, 4, 9, 93, -1, 234, 9, 3 };
        // displayArr(0, arr);

        // System.out.println(findArr(0, 4, arr));
        // System.out.println(findArr02(0, 10, arr));
        // System.out.println(max_in_array(0, arr));
        // System.out.println(min_in_array(0, arr));

        // int[] ans = Store_index(0, 0, 10, arr);
        // displayArr(0, ans);

        // System.out.println(jump_game(0, 3));
        // jump_game02(4); // without count
        // System.out.println(res);

        // int[] arr = new int[] { 1, 2, 5, 7 };
        // System.out.println(Coin_change_array_permu02(0, 0, 10, arr));

        // String str = "hihiiiihithithithithitiiih";
        // remove_Hi(0, str, "");
        // remove_Hi_without_Hit(0, str, "");

        System.out.println(Subsequc_of_str("aab"));
        System.out.println(subsequences("aab"));
        // System.out.println(compression(1, "aaabbbccccdddefffgh"));
        // System.out.println();
        // System.out.println(Compression02("aaabbbccccdddefffgh"));

        // System.out.println(mazepath_answer_only(3, 3));
        // System.out.println(mazepath(0, 0, 2, 2));
        // System.out.println(mazepath_count(2, 2));
        // System.out.println(mazepath_with_diagonal(2, 2));
        // boolean[][] arr = new boolean[4][4];
        // boolean[][] record = new boolean[8][8];
        // int[][] board = new int[9][9];
        // int[][] board=new int[][]{{1,1,0},{1,1,1},{0,1,1}};
        // System.out.println(floodfill_answerONLY(2, 2, arr));
        // System.out.println(floodfill_all_answer(0, 0, 2, 2, arr));

        // System.out.println(floodfill_with_hurdles(0, 0, 2, 2, arr,board ));
        // System.out.println(knight_count_only(0, 0, 2, 2, arr));
        // System.out.println();
        // System.out.println(knight_all_answer(0, 0, 2, 2, record));

        // String[] keys = { ".","abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx",
        // "yz" };

        // System.out.println(nokia_keyPad(keys, "173"));

        // tower_pf_hanoi_prac(3, 'a', 'b', 'c');
        // knight_all_matrix_filled(0, 0, 1, board);
        // knights_fill(0, 0, 64, 1, board);

        // System.out.println(encoding("1013"));
        // int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
        //         { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
        //         { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        // // sudoku(board,0);
        // sudoku(board, 0);

    }

    public static int factorial(int n) {
        if (n == 1 || n == 0)
            return 1;

        return n * factorial(n - 1);

    }

    public static int fibonaci(int n) {
        if (n == 0 || n == 1)
            return n;

        return fibonaci(n - 1) + fibonaci(n - 2);
    }

    public static void printIncreasing(int n) {
        if (n == 0)
            return;

        printIncreasing(n - 1);
        System.out.println(n);

    }

    public static void printDecreasing(int n) {
        if (n == 0)
            return;

        System.out.println(n);
        printDecreasing(n - 1);

    }

    public static int power01(int a, int b) {
        if (b == 0) // O(b)
            return 1;

        return a * power01(a, b - 1);
    }

    public static int power02(int a, int b) {
        if (b == 0) // O(b)
            return 1;

        if (b % 2 == 0)
            return (power02(a, b / 2) * power02(a, b / 2));

        else
            return (a * power02(a, b / 2) * power02(a, b / 2));
    }

    public static int power03(int a, int b) {
        if (b == 0) // O(b logb)
            return 1;

        int temp = power03(a, b / 2);
        if (b % 2 == 0)
            return (temp * temp);

        else
            return (a * temp * temp);
    }

    public static void tower_pf_hanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 1) {
            System.out.println("shift 1 disk from rod " + from_rod + " to the rod " + to_rod);
            return;
        }
        tower_pf_hanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("shift " + n + " disk from rod " + from_rod + " to the rod " + to_rod);
        tower_pf_hanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void displayArr(int idx, int[] arr) {
        if (idx == arr.length)
            return;

        System.out.print(arr[idx] + " ");
        displayArr(idx + 1, arr);

    }

    public static int findArr(int idx, int data, int[] arr) {
        if (idx == arr.length)
            return -1;

        if (arr[idx] == data)
            return idx;

        return findArr(idx + 1, data, arr);

    }

    public static Boolean findArr02(int idx, int data, int[] arr) {
        if (idx == arr.length)
            return false;

        if (arr[idx] == data)
            return true;

        return findArr02(idx + 1, data, arr);
    }

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static int max_in_array(int idx, int[] arr) {
        if (idx == arr.length)
            return max;

        if (arr[idx] > max)
            max = arr[idx];

        return max_in_array(idx + 1, arr);

    }

    public static int min_in_array(int idx, int[] arr) {
        if (idx == arr.length)
            return min;

        if (arr[idx] < min)
            min = arr[idx];

        return min_in_array(idx + 1, arr);
    }

    public static int[] Store_index(int idx, int count, int data, int[] arr) {
        if (idx == arr.length)
            return new int[count];

        int[] res = null;
        if (arr[idx] == data) {
            res = Store_index(idx + 1, count + 1, data, arr);
            res[count] = idx;
        } else
            res = Store_index(idx + 1, count, data, arr);

        return res;
    }

    public static int jump_game(int val, int target) {
        if (target == 0)
            return 1;

        int count = 0;

        if (target >= 1)
            count += jump_game(val, target - 1);

        if (target >= 2)
            count += jump_game(val, target - 2);

        if (target >= 3)
            count += jump_game(val, target - 3);

        return count;

    }

    static int res = 0;

    public static void jump_game02(int target) {
        if (target == 0) {
            res++;
            return;
        }

        // if (target >= 1)
        // jump_game02(target - 1);

        // if (target >= 2)
        // jump_game02( target - 2);

        // if (target >= 3)
        // jump_game02( target - 3);

        for (int i = 1; i <= 3 && target - i >= 0; i++) {
            jump_game02(target - i);
        }

    }

    public static int Coin_change_array_permu(int val, int target, int[] arr) {
        if (val == target)
            return 1;

        int count = 0;
        for (int i = 0; i < arr.length && val + arr[i] <= target; i++) {
            count += Coin_change_array_permu(val + arr[i], target, arr);
        }

        return count;
    }

    public static int Coin_change_array_permu02(int idx, int val, int target, int[] arr) {
        if (val == target)
            return 1;

        int count = 0;
        for (int i = idx; i < arr.length && val + arr[i] <= target; i++) {
            count += Coin_change_array_permu02(i, val + arr[i], target, arr);
        }

        return count;
    }

    public static void remove_Hi(int idx, String str, String ans) {
        if (idx >= str.length()) {
            System.out.println(ans);
            return;
        }

        if (idx + 1 < str.length() && str.charAt(idx) == 'h' && str.charAt(idx + 1) == 'i') {
            remove_Hi(idx + 2, str, ans);

        } else
            remove_Hi(idx + 1, str, ans + str.charAt(idx));

    }

    public static void remove_Hi_without_Hit(int idx, String str, String ans) {
        if (idx >= str.length()) {
            System.out.println(ans);
            return;
        }

        if (idx + 3 <= str.length() && str.substring(idx, idx + 3).equals("hit"))
            remove_Hi_without_Hit(idx + 3, str, ans + "hit");

        else if (idx + 2 <= str.length() && str.substring(idx, idx + 2).equals("hi"))
            remove_Hi_without_Hit(idx + 2, str, ans);

        else
            remove_Hi_without_Hit(idx + 1, str, ans + str.charAt(idx));

    }

    public static ArrayList<String> Subsequc_of_str(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> faith = Subsequc_of_str(str.substring(1));
        ArrayList<String> ans = new ArrayList<>();

        for (String s : faith) {
            ans.add(s);
            ans.add(ch + s);
        }

        return ans;
    }

    public static ArrayList<String> Subsequence_of_string02(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        ArrayList<String> faith = Subsequence_of_string02(str.substring(1));
        int size_of_faith_we_get=faith.size();
        for (int i = 0; i <size_of_faith_we_get; i++) {
            faith.add(str.charAt(0) + faith.get(i));
        }

        return faith;
    }

    public static ArrayList<String> subsequences(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> faith = subsequences(str.substring(1));
        int size = faith.size();
        for (int i = 0; i < size; i++) {
            faith.add(str.charAt(0) + faith.get(i));
        }
        return faith;
    }

    public static String compression(int count, String str) {
        if (str.length() <= 1) {
            return str + (count != 1 ? count + "" : "");
        }

        if (str.charAt(0) == str.charAt(1))
            return compression(count + 1, str.substring(1));

        else
            return str.charAt(0) + (count != 1 ? count + "" : "") + compression(1, str.substring(1));

    }

    public static String Compression02(String str) {
        if (str.length() == 0)
            return "";

        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                count++;
            else
                break;
        }

        String first = str.charAt(0) + (count != 1 ? count + "" : "");
        String last = Compression02(str.substring(count));

        return first + last;

    }

    public static int mazepath_answer_only(int row, int col) {
        if (row == 0 && col == 0)
            return 1;

        int count = 0;
        if (row - 1 >= 0)
            count += mazepath_answer_only(row - 1, col);

        if (col - 1 >= 0)
            count += mazepath_answer_only(row, col - 1);

        return count;

    }

    public static ArrayList<String> mazepath(int sc, int sr, int ec, int er) {
        if (sc == ec && sr == er) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;

        }

        ArrayList<String> answer = new ArrayList<>();

        if (sc + 1 <= ec) {
            ArrayList<String> hori = mazepath(sc + 1, sr, ec, er);
            for (String str : hori)
                answer.add('H' + str);

        }

        if (sr + 1 <= er) {
            ArrayList<String> verti = mazepath(sc, sr + 1, ec, er);
            for (String str : verti)
                answer.add('V' + str);

        }

        return answer;
    }

    public static int mazepath_count(int er, int ec) {
        if (er == 0 && ec == 0) {
            return 0;

        }
        int max = 0;
        if (er - 1 >= 0)
            max = Math.max(max, mazepath_count(er - 1, ec));

        if (ec - 1 >= 0)
            max = Math.max(max, mazepath_count(er, ec - 1));

        return max + 1;

    }

    public static ArrayList<String> mazepath_with_diagonal(int er, int ec) {
        if (ec == 0 && er == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();

        if (er - 1 >= 0) {
            ArrayList<String> hori = mazepath_with_diagonal(er - 1, ec);
            for (String s : hori)
                ans.add('H' + s);
        }

        if (ec - 1 >= 0) {
            ArrayList<String> verti = mazepath_with_diagonal(er, ec - 1);
            for (String s : verti)
                ans.add('V' + s);
        }

        if (ec - 1 >= 0 && er - 1 >= 0) {
            ArrayList<String> diag = mazepath_with_diagonal(er - 1, ec - 1);
            for (String s : diag)
                ans.add('D' + s);
        }

        return ans;
    }

    public static int floodfill_answerONLY(int er, int ec, boolean[][] record) {
        if (er == 0 && ec == 0) {
            return 1;

        }

        int count = 0;
        record[er][ec] = true;
        if (er - 1 >= 0 && !record[er - 1][ec])
            count += floodfill_answerONLY(er - 1, ec, record);

        if (ec - 1 >= 0 && !record[er][ec - 1])
            count += floodfill_answerONLY(er, ec - 1, record);

        if (er + 1 < record.length && !record[er + 1][ec])
            count += floodfill_answerONLY(er + 1, ec, record);

        if (ec + 1 < record[0].length && !record[er][ec + 1])
            count += floodfill_answerONLY(er, ec + 1, record);

        record[er][ec] = false;

        return count;
    }

    public static ArrayList<String> floodfill_all_answer(int sr, int sc, int er, int ec, boolean[][] record) {
        if (sc == ec && sr == er) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        record[sr][sc] = true;

        if (sr + 1 <= er && !record[sr + 1][sc]) {
            ArrayList<String> right = floodfill_all_answer(sr + 1, sc, er, ec, record);
            for (String s : right) {
                ans.add('R' + s);
            }
        }
        if (sc + 1 <= ec && !record[sr][sc + 1]) {
            ArrayList<String> down = floodfill_all_answer(sr, sc + 1, er, ec, record);
            for (String s : down) {
                ans.add('D' + s);
            }
        }
        if (sr - 1 >= 0 && !record[sr - 1][sc]) {
            ArrayList<String> left = floodfill_all_answer(sr - 1, sc, er, ec, record);
            for (String s : left) {
                ans.add('L' + s);
            }
        }

        if (sc - 1 >= 0 && !record[sr][sc - 1]) {
            ArrayList<String> up = floodfill_all_answer(sr, sc - 1, er, ec, record);
            for (String s : up) {
                ans.add('U' + s);
            }
        }

        record[sr][sc] = false;

        return ans;

    }

    static int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static String[] move = new String[] { "R", "D", "L", "U" };

    static String[] moves_knight = new String[] { "1", "2", "3", "4", "5", "6", "7", "8" };

    public static ArrayList<String> floodfill_with_hurdles(int sr, int sc, int er, int ec, boolean[][] record,
            int[][] hurdle_board) {
        if (sc == ec && sr == er) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < dir.length; i++) {
            record[sc][sr] = true;
            int y = sc + dir[i][1];
            int x = sr + dir[i][0];

            if (x >= 0 && y >= 0 && x < hurdle_board.length && y < hurdle_board[0].length && !record[x][y]
                    && hurdle_board[x][y] != 0) {
                ArrayList<String> recAns = floodfill_with_hurdles(x, y, er, ec, record, hurdle_board);
                for (String s : recAns) {
                    ans.add(move[i] + s);
                }
            }

            record[sc][sr] = false;
        }

        return ans;
    }

    static int[][] dir_knight = new int[][] { { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 }, { 1, 2 }, { -1, 2 },
            { -1, -2 }, { 1, -2 } };

    public static int knight_count_only(int sr, int sc, int er, int ec, boolean[][] record) {
        if (sc == ec && sr == er) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < dir_knight.length; i++) {
            record[sr][sc] = true;
            int x = sr + dir_knight[i][0];
            int y = sc + dir_knight[i][1];

            if (x >= 0 && y >= 0 && x <= er && y <= ec && !record[x][y]) {
                count += knight_count_only(x, y, er, ec, record);
            }

            record[sr][sc] = false;
        }

        return count;
    }

    public static ArrayList<String> knight_all_answer(int sr, int sc, int er, int ec, boolean[][] record) {
        if (sc == ec && sr == er) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        int count = 0;
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < dir_knight.length; i++) {
            record[sr][sc] = true;
            int x = sr + dir_knight[i][0];
            int y = sc + dir_knight[i][1];

            if (x >= 0 && y >= 0 && x <= er && y <= ec && !record[x][y]) {
                ArrayList<String> recAns = knight_all_answer(x, y, er, ec, record);
                for (String s : recAns) {
                    answer.add(moves_knight[i] + s);
                }
            }

            record[sr][sc] = false;
        }

        return answer;
    }

    public static ArrayList<String> nokia_keyPad(String[] keys, String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < keys[str.charAt(0) - '0'].length(); i++) {
            ArrayList<String> recAns = nokia_keyPad(keys, str.substring(1));
            for (String s : recAns) {
                answer.add(keys[str.charAt(0) - '0'].charAt(i) + s);
            }
        }

        return answer;
    }

    public static void tower_pf_hanoi_prac(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 1) {
            System.out.println("shift 1 disk from " + from_rod + " to rod " + to_rod);
            return;
        }

        tower_pf_hanoi_prac(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("shift " + n + " disk from " + from_rod + " to rod " + to_rod);
        tower_pf_hanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static boolean knight_all_matrix_filled(int sr, int sc, int count, int[][] board) {
        if (count == 64) {
            for (int[] row : board) {
                for (int ele : row) {
                    System.out.print(ele + " ");
                }
                System.out.println();
            }

            return true;
        }
        boolean res = false;
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < dir_knight.length; i++) {

            int x = sr + dir_knight[i][0];
            int y = sc + dir_knight[i][1];

            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 0) {
                board[x][y] = count;
                res = res || knight_all_matrix_filled(x, y, count + 1, board);

            }

        }
        board[sr][sc] = 0;
        return res;

    }

    public static Boolean knights_fill(int sr, int sc, int boxsize, int count, int[][] ans) {
        ans[sr][sc] = count;
        if (count == boxsize) {
            for (int[] a : ans) {
                for (int ele : a)
                    System.out.print(ele + " ");
                System.out.println();
            }
            return true;
        }
        Boolean res = false;
        for (int i = 0; i < dir_knight.length; i++) {

            int x = sr + dir_knight[i][0];
            int y = sc + dir_knight[i][1];
            if (x >= 0 && y >= 0 && x < ans.length && y < ans[0].length && ans[x][y] == 0)
                res = res || knights_fill(x, y, boxsize, count + 1, ans);
        }
        ans[sr][sc] = 0;
        return res;
    }

    // the main concept to uncderstand in this question is that when we have zero
    // after a number then we ignore it and call the substring from1 .but it comes
    // in mind that answer for 1013 can also
    // come as aac and jac and jm but it only comes as jm because when it get call
    // for 013 ->13->3->"" & 013 ->13->"" when it returned back the part which
    // we consider or return is the second one always so 013 ->13->"" this will be
    // returned in recAns and we get jac and jm as answer.
    public static ArrayList<String> encoding(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        int ch = str.charAt(0) - '0';

        ArrayList<String> answer = new ArrayList<>();
        if (ch == 0) {
            ArrayList<String> recAns = encoding(str.substring(1));
            // on adding these two lines we get aac and am the
            // explanation of above commented lines
            // for(String s:recAns)
            // answer.add(s);
        }
        if (ch != 0) {
            ArrayList<String> recAns = encoding(str.substring(1));
            for (String s : recAns)
                answer.add((char) (ch - 1 + 'a') + s);
        }

        if (str.length() > 1) {
            int num = (ch) * 10 + (str.charAt(1) - '0');
            if (num > 9 && num < 27) {
                ArrayList<String> recAns = encoding(str.substring(2));
                for (String s : recAns)
                    answer.add((char) (num - 1 + 'a') + s);

            }
        }

        return answer;

    }

    public static boolean is_safe_to_place(int r, int c, int val, int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == val)
                return false;

            if (board[i][c] == val)
                return false;

        }

        // for (int i = 0; i < 9; i++) {
        // if (board[i][c] == val)
        // return false;

        // }

        int x = (r / 3) * 3;
        int y = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[x + i][y + j] == val)
                    return false;
            }
        }

        return true;

    }

    public static void sudoku(int[][] board, int idx) {
        if (idx == (board.length * board[0].length)) {
            for (int[] row : board) {
                for (int ele : row)
                    System.out.print(ele + " ");

                System.out.println();
            }
            System.out.println("=======================================");
            return;
        }

        int r = (idx / board.length);
        int c = (idx % board[0].length);

        if (board[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (is_safe_to_place(r, c, i, board)) {
                    board[r][c] = i;
                    sudoku(board, idx + 1);
                    board[r][c] = 0;
                }
            }
        } else
            sudoku(board, idx + 1);

    }

}
