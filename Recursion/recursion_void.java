import java.util.*;

public class recursion_void {
    public static void main(String[] args) {
        // mazepath(0, 0, 2, 2, "");
        // removeHi("hihihittttthiiiiiiihhhhi", "");
        // remove_repeated("aaaabbbbccccdddefffghhi", "");
        // remove_repeated("NNNNNNAMMMMANNNNNNSAMMMMMMRRRAAA", "");
        // mazepath_multi_move(0, 0, 2, 2, "");
        // boolean[][] record=new boolean[3][3];
        // floodfill(0, 0, 2, 2, record, "");
        // System.out.println(board_path(10, 5, ""));
        // System.out.println(subsequence("abc",""));
        // System.out.println();
        System.out.println(string_permu_with_rep("abc", ""));
        // System.out.println(string_permu_without_rep("acbc", ""));
        // System.out.println(string_combi("abc", ""));
        // System.out.println(find_singly_repeated_no(0, "defgg"));
        // boolean[] record = new boolean[4];
        // System.out.println(queens_permu(4, 0, "", record));
        // System.out.println(queens_combi(0, 4, 0, "", record));
        // System.out.println();
        // boolean[] record2 = new boolean[4];
        // System.out.println(queens_permu_by_suseq(0, 4, 0, "", record2));

        // boolean[][] record = new boolean[4][4];
        // System.out.println(N_Queens_main(0, 4, 0, "", record));

        // int[] arr = new int[] { 2, 3, 5, 7 };
        // int target = 10;
        // boolean[] record1 = new boolean[4];
        // boolean[] record2 = new boolean[4];

        // System.out.println(coin_change_permu_with_rep(arr, target, ""));
        // System.out.println();
        // System.out.println(coin_change_permu_with_rep_by_susb(0, target, "", arr));
        // System.out.println();
        // System.out.println(coin_change_permu_without_rep(arr, target, "", record1));
        // System.out.println();
        // System.out.println(coin_change_permu_without_rep_by_susb(0, target, "", arr,
        // record2));

        // System.out.println(coin_change_combi_with_rep(0, arr, target, ""));
        // System.out.println(coin_change_combi_with_rep_by_susb(0, target, "", arr));

        // int[] arr=new int[]{10,20,30};
        // System.out.println(equiSet(arr, 0, 0, "", "", 0));

    }

    public static void mazepath(int sr, int sc, int er, int ec, String answer) {
        if (sr == er && sc == ec) {
            System.out.print(answer + " ");
            return;
        }

        if (sr + 1 <= er)
            mazepath(sr + 1, sc, er, ec, answer + 'H');

        if (sc + 1 <= ec)
            mazepath(sr, sc + 1, er, ec, answer + 'V');

        if (sc + 1 <= ec && sr + 1 <= er)
            mazepath(sr + 1, sc + 1, er, ec, answer + 'D');

    }

    public static void removeHi(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        char ch = str.charAt(0);
        if (str.length() > 1) {
            if (str.substring(0, 2).equals("hi"))
                removeHi(str.substring(2), ans);
            else
                removeHi(str.substring(1), ans + ch);
        } else
            removeHi(str.substring(1), ans + ch);
    }

    public static void remove_repeated(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans + " ");
            return;
        }

        if (str.length() > 1 && str.charAt(0) == str.charAt(1)) {
            remove_repeated(str.substring(1), ans);
        } else
            remove_repeated(str.substring(1), ans + str.charAt(0));

    }

    public static void mazepath_multi_move(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 1; sc + i <= ec; i++) {
            mazepath_multi_move(sr, sc + i, er, ec, ans + "H" + i + "");
        }

        for (int i = 1; sr + i <= er; i++) {
            mazepath_multi_move(sr + i, sc, er, ec, ans + "V" + i + "");
        }
        for (int i = 1; sr + i <= er && sc + i <= ec; i++) {
            mazepath_multi_move(sr + i, sc + i, er, ec, ans + "D" + i + "");
        }
    }

    public static void floodfill(int sr, int sc, int er, int ec, boolean[][] record, String ans) {
        if (sc == ec && sr == er) {
            System.out.print(ans + " ");
            return;
        }

        record[sr][sc] = true;
        if (sc + 1 <= ec && !record[sr][sc + 1]) {
            floodfill(sr, sc + 1, er, ec, record, ans + 'R');

        }
        if (sr + 1 <= ec && !record[sr + 1][sc]) {
            floodfill(sr + 1, sc, er, ec, record, ans + 'D');

        }
        if (sc - 1 >= 0 && !record[sr][sc - 1]) {
            floodfill(sr, sc - 1, er, ec, record, ans + 'L');

        }
        if (sr - 1 >= 0 && !record[sr - 1][sc]) {
            floodfill(sr - 1, sc, er, ec, record, ans + 'U');

        }
        record[sr][sc] = false;

    }

    public static int board_path(int target, int val, String ans) {
        if (val == target) {
            System.out.print(ans + " ");
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= 6 && val + i <= target; i++) {
            count += board_path(target, val + i, ans + i + "");
        }

        return count;
    }

    public static int subsequence(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return 1;
        }
        int count = 0;
        count += subsequence(str.substring(1), ans + str.charAt(0));
        count += subsequence(str.substring(1), ans);

        return count;
    }

    public static int string_permu_with_rep(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return 1;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            count += string_permu_with_rep((str.substring(0, i) + str.substring(i + 1)), ans + ch);
        }

        return count;
    }

    public static int string_permu_without_rep(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return 1;
        }
        int count = 0;

     
        int visited = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int mask = (1 << (ch - 'a'));
            if ((visited & mask) == 0) {

                visited = visited | mask;
                count += string_permu_without_rep((str.substring(0, i) + str.substring(i + 1)), ans + ch);

            }

        }

        return count;
    }

    // not known the authencity::::::::
    public static int string_combi(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return 1;

        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += string_combi(str.substring(i + 1), ans + str.charAt(i));
        }

        return count;

    }

    static int val = 0;

    public static int find_singly_repeated_no(int idx, String str) {
        if (idx == str.length())
            return -1;

        char ch = str.charAt(idx);
        int index = 0;
        int mask = (1 << (ch - 'a'));
        if ((mask & val) == 0) {
            val = val | mask;
            index = find_singly_repeated_no(idx + 1, str);

        } else
            return idx;

        return index;
    }

    // question is that we are given an array of any length k and we have to place
    // given n no of queens.(IT IS NOT NECCESSARY THAT n==k).
    public static int queens_permu(int tnq, int qpsf, String ans, boolean[] record) {
        if (qpsf == tnq) {
            System.out.print(ans + " ");
            return 1;
        }

        int count = 0;
        for (int i = 0; i < tnq; i++) {
            if (!record[i]) {
                record[i] = true;
                count += queens_permu(tnq, qpsf + 1, ans + "q" + i + "", record);
                record[i] = false;
            }
        }

        return count;
    }

    public static int queens_combi(int idx, int tnq, int qpsf, String ans, boolean[] record) {
        if (qpsf == tnq) {
            System.out.print(ans + " ");
            return 1;
        }

        int count = 0;
        for (int i = idx; i < tnq; i++) {

            count += queens_combi(i + 1, 4, qpsf + 1, ans + "q" + i + "", record);

        }

        return count;
    }

    public static int queens_permu_by_suseq(int idx, int tnq, int qpsf, String ans, boolean[] record) {
        if (idx == record.length || qpsf == tnq) {
            if (qpsf == tnq) {
                System.out.print(ans + " ");
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (!record[idx]) {
            record[idx] = true;
            count += queens_permu_by_suseq(0, tnq, qpsf + 1, ans + "q" + idx + "", record);
            record[idx] = false;

        }

        count += queens_permu_by_suseq(idx + 1, tnq, qpsf, ans, record);

        return count;
    }

    public static int queens_combi_by_subeq(int idx, int tnq, int qpsf, String ans, boolean[] arr) {
        if (idx == arr.length || qpsf == tnq) {
            if (qpsf == tnq) {
                System.out.print(ans + " ");
                return 1;
            }
            return 0;
        }

        int count = 0;

        count += queens_combi_by_subeq(idx + 1, tnq, qpsf + 1, ans + idx + "", arr);
        count += queens_combi_by_subeq(idx + 1, tnq, qpsf, ans, arr);

        return count;

    }

    static int[][] dir_queen = new int[][] { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 },
            { 0, -1 } };

    public static boolean is_safe_to_place_queen(int r, int c, boolean[][] board) {
        for (int i = 0; i < dir_queen.length; i++) {
            for (int rad = 1; rad < board.length; rad++) {
                int x = r + rad * dir_queen[i][0];
                int y = c + rad * dir_queen[i][1];

                if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y]) {
                    return false;
                }

            }

        }

        return true;

    }

    public static int N_Queens_main(int idx, int tnq, int qpsf, String ans, boolean[][] record) {
        if (idx == (record.length * record[0].length))
            return 0;

        if (qpsf == tnq) {
            System.out.println(ans + " ");
            return 1;

        }

        int count = 0;

        for (int i = idx; i < (record.length * record[0].length); i++) {
            int r = i / record.length;
            int c = i % record.length;
            if (is_safe_to_place_queen(r, c, record)) {
                record[r][c] = true;
                count += N_Queens_main(i + 1, tnq, qpsf + 1, ans + '[' + r + ',' + c + ']' + " ", record);
                record[r][c] = false;

            }
        }

        return count;
    }

    public static int coin_change_permu_with_rep(int[] arr, int target, String ans) {
        if (target == 0) {
            System.out.print(ans + " ");
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (target - arr[i] >= 0) {

                count += coin_change_permu_with_rep(arr, target - arr[i], ans + arr[i] + "");

            }
        }
        return count;
    }

    public static int coin_change_permu_with_rep_by_susb(int idx, int target, String ans, int[] arr) {
        if (idx == arr.length || target == 0) {
            if (target == 0) {
                System.out.print(ans + " ");
                return 1;
            }

            return 0;
        }
        int count = 0;
        if (target - arr[idx] >= 0) {

            count += coin_change_permu_with_rep_by_susb(0, target - arr[idx], ans + arr[idx] + "", arr);

        }
        count += coin_change_permu_with_rep_by_susb(idx + 1, target, ans, arr);

        return count;
    }

    public static int coin_change_permu_without_rep(int[] arr, int target, String ans, boolean[] record) {
        if (target == 0) {
            System.out.print(ans + " ");
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (target - arr[i] >= 0 && !record[i]) {
                record[i] = true;
                count += coin_change_permu_without_rep(arr, target - arr[i], ans + arr[i] + "", record);
                record[i] = false;

            }
        }
        return count;
    }

    public static int coin_change_permu_without_rep_by_susb(int idx, int target, String ans, int[] arr,
            boolean[] record) {
        if (idx == arr.length || target == 0) {
            if (target == 0) {
                System.out.print(ans + " ");
                return 1;
            }

            return 0;
        }
        int count = 0;
        if (target - arr[idx] >= 0 && !record[idx]) {
            record[idx] = true;
            count += coin_change_permu_without_rep_by_susb(0, target - arr[idx], ans + arr[idx] + "", arr, record);
            record[idx] = false;

        }
        count += coin_change_permu_without_rep_by_susb(idx + 1, target, ans, arr, record);

        return count;
    }

    public static int coin_change_combi_with_rep(int idx, int[] arr, int target, String ans) {
        if (target == 0) {
            System.out.print(ans + " ");
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (target - arr[i] >= 0) {

                count += coin_change_combi_with_rep(i, arr, target - arr[i], ans + arr[i] + "");

            }
        }
        return count;
    }

    public static int equiSet(int[] arr, int sum1, int sum2, String ans1, String ans2, int idx) {

        if (idx == arr.length) {
            if (sum1 == sum2) {
                System.out.println("[" + ans1 + "]" + "=" + "[" + ans2 + "]");
                return 1;
            }

            return 0;
        }

        int count = 0;
        count += equiSet(arr, sum1 + arr[idx], sum2, ans1 + arr[idx] + " ", ans2, idx + 1);
        count += equiSet(arr, sum1, sum2 + arr[idx], ans1, ans2 + arr[idx] + " ", idx + 1);

        return count;

    }

    public static int coin_change_combi_with_rep_by_susb(int idx, int target, String ans, int[] arr) {
        if (idx == arr.length || target == 0) {
            if (target == 0) {
                System.out.print(ans + " ");
                return 1;
            }

            return 0;
        }
        int count = 0;
        if (target - arr[idx] >= 0) {

            count += coin_change_combi_with_rep_by_susb(idx, target - arr[idx], ans + arr[idx] + "", arr);

        }
        count += coin_change_combi_with_rep_by_susb(idx + 1, target, ans, arr);

        return count;
    }

}