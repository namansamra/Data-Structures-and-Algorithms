import java.util.*;

public class question {
    public static Scanner scn = new Scanner(System.in);

    public static char highestfreq(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        char maxchar = 'a';

        Set<Character> set = map.keySet();
        for (Character s : set) {
            if (map.get(s) > max) {
                maxchar = s;
                max = map.get(s);
            }
        }

        return maxchar;
    }

    public static void getCommonEle1() {
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scn.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
                System.out.println(arr2[i]);
                map.remove(arr2[i]);
            }
        }
    }

    public static void getCommonEle2() {
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scn.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
                System.out.println(arr2[i]);
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        }
    }

    public static void LongestConseSeq(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - 1)) {
                map.put(arr[i], false);
            }
        }

        int msp = 0;
        int maxsize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == true) {
                int tempsize = 1;
                int tsp = arr[i];
                while (map.containsKey(tsp + tempsize)) {
                    tempsize++;
                }

                if (tempsize > maxsize) {
                    msp = arr[i];
                    maxsize = tempsize;
                }
            }

        }

        for (int i = 0; i < maxsize; i++) {
            System.out.println(msp + i);
        }

    }

   

    public static void main(String[] args) {
        // String s = scn.nextLine();
        // System.out.println(highestfreq(s));

        int[] arr = { 10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2 };
        LongestConseSeq(arr);
    }
}