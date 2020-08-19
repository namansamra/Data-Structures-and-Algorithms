
import java.util.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class question {

    public static void GreatestKele(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : arr) {
            pq.add(val);
        }

        while (k > 0) {
            System.out.println(pq.poll());
            k--;
        }

    }

    public static void GreatestKele1(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (k > 0) { // we fill the pq to atleast of the k values;
                pq.add(arr[i]);
                k--;
                continue;
            }

            if (pq.peek() < arr[i]) { // in this the peek will be always at risk so if we found a better one we pop
                                      // the peek and add the new
                pq.remove();
                pq.add(arr[i]);
            }
        }

        while (pq.size() != 0) {
            System.out.println(pq.remove());
        }
    }

    public static void SortASortedArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if (k >= arr.length) { // not possible for the element theoretically but if there is any test case then
                               // it will handle.
            k = arr.length - 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                for (int j = 0; j < k + 1; j++) {
                    pq.add(arr[j]);
                }

                System.out.print(pq.poll() + " ");
            } else if ((i + k) < arr.length) {
                pq.add(arr[i + k]);
                System.out.print(pq.poll() + " ");
            }

        }
        while (pq.size() != 0) {
            System.out.print(pq.poll() + " ");
        }
    }

    public static void SortASortedArray2(int[] arr, int k) {
        // elegant code
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < arr.length; i++) {
            System.out.println(pq.poll());
            pq.add(arr[i]);
        }

        while (pq.size() != 0) {
            System.out.println(pq.poll());
        }

    }

    // first or general approach
    public static ArrayList<Integer> mergeKSortedListsINTUTION(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ArrayList<Integer> a : lists) {
            for (int i : a) {
                pq.add(i);
            }
        }

        while (pq.size() != 0) {
            rv.add(pq.remove());
        }

        return rv;
    }

    public static class pair implements Comparable<pair> {
        int li;
        int di;
        int val;

        pair(int li, int di, int val) {
            this.li = li; // list index
            this.di = di; // data index
            this.val = val; // value
        }

        @Override
        public int compareTo(pair other) {
            if (this.val > other.val)
                return 1;
            else
                return -1;

        }

    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<pair> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            pq.add(new pair(i, 0, lists.get(i).get(0)));
        }

        while (pq.size() != 0) {
            pair head = pq.remove();
            ans.add(head.val);
            head.di++;

            if (head.di < lists.get(head.li).size())
                pq.add(new pair(head.li, head.di, lists.get(head.li).get(head.di)));

        }

        return ans;

    }

    public static void main(String[] args) {
        // int[] arr = { 2, 4, 6, 11, 345, 43, 3, 44, 0 };
        // GreatestKele(arr, 4);
        // System.out.println();
        // GreatestKele1(arr, 4);

        int[] arr = { 2, 3, 1, 4, 6, 7, 5, 8, 9 };
        SortASortedArray(arr, 2);

    }
}