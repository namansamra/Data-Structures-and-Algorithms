import java.util.Scanner;
import java.*;


public class arrays {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        // int n = scn.nextInt();
        // int[] arr = new int[n];

        // input(arr);
        // rotateWithMemory(arr, -3);
        // display(arr);
        // rotateWithoutMemory(arr, 9);
        // display(arr);

        // int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15
        // }, { 16, 17, 18, 19, 20 },
        // { 21, 22, 23, 24, 25 }, };
        // spiralMatrix(arr);

        // int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        // int p = SeachInRotatedArray(arr, 0);
        // System.out.println(p);

        // int[] arr=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        // int p=maxSubArray(arr);
        // System.out.println(p);

        // System.out.println(printSum());
        // System.out.println(reverse());
        // printStar();

    }

    public static void input(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void swap(int i, int j, int[] arr) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void reverse(int i, int j, int[] arr) {
        while (i < j) {

            swap(i, j, arr);
            i++;
            j--;
        }
    }

    public static void rotateWithMemory(int[] arr, int r) {
        r = r % arr.length;

        r = r < 0 ? r + arr.length : r;

        int[] ans = new int[arr.length];
        int k = 0;
        for (int i = r; i < arr.length; i++) {
            ans[k] = arr[i];
            k++;
        }

        for (int i = 0; i < r; i++) {
            ans[k] = arr[i];
            k++;
        }

        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }

    }

    public static void rotateWithoutMemory(int[] arr, int r) {
        r = r % arr.length;
        r = r < 0 ? r + arr.length : r;

        reverse(0, r - 1, arr);
        reverse(r, arr.length - 1, arr);
        reverse(0, arr.length - 1, arr);

    }

    public static void spiralMatrix(int[][] arr) {
        int rmin = 0;
        int rmax = arr.length - 1;
        int cmin = 0;
        int cmax = arr[0].length - 1;

        int tne = (arr.length) * (arr[0].length);
        while (tne > 0) {
            for (int i = cmin; i <= cmax && tne > 0; i++) {
                System.out.print(arr[rmin][i] + " ");
                tne--;
            }
            rmin++;

            for (int i = rmin; i <= rmax && tne > 0; i++) {
                System.out.print(arr[i][cmax] + " ");
                tne--;
            }
            cmax--;

            for (int i = cmax; i >= cmin && tne > 0; i--) {
                System.out.print(arr[rmax][i] + " ");
                tne--;
            }
            rmax--;

            for (int i = rmax; i >= rmin && tne > 0; i--) {
                System.out.print(arr[i][cmin] + " ");
                tne--;
            }
            cmin++;
        }
    }

    public static int SeachInRotatedArray(int[] arr, int data) {
        int left = 0;
        int right = arr.length - 1;
        int idx = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }

            else {
                right = mid;
            }
        }

        if (data > arr[arr.length - 1]) {
            right = left - 1;
            left = 0;
        } else {
            right = arr.length - 1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == data) {
                return mid;
            }

            else if (arr[mid] < data) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return -1;
    }

    public static int maxSubArray(int[] arr) {
        int max_so_far = Integer.MIN_VALUE;
        int max_here = 0;

        for (int i = 0; i < arr.length; i++) {
            max_here = max_here + arr[i];

            if (max_here > max_so_far) {
                max_so_far = max_here;
            }
            if (max_here < 0) {
                max_here = 0;
            }

        }

        return max_so_far;

    }

    public static int printSum() {
        int n = scn.nextInt();
        return printSumrec(n);

    }

    public static int printSumrec(int n) {
        if (n == 1) {
            return 1;
        }

        return n + printSumrec(n - 1);
    }




    public static String reverse(){
        String str = scn.nextLine();
        return reverseString(str);
        
    }

    public static String reverseString(String str) {
        if (str.length()==0)
            return str;
        // Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }


    public static void printStar(){
        int n=scn.nextInt();
        printStarrec(n,0);
    }
    
    public static void printStarrec(int n,int idx){
        if(idx>n){
            return ;
        }

        for(int i=1;i<=idx;i++)
        System.out.print('*');

        System.out.println();
        printStarrec(n,idx+1);
    }



    public static void findMax() {
        int A[] = { 1, 4, 45, 6, -50, 10, 2 };
        int n = A.length;

        System.out.println(findMaxRec(A, n));
    }

    public static int findMaxRec(int A[], int n) {
        if (n == 1)
            return A[0];

        return Math.max(A[n - 1], findMaxRec(A, n - 1));
    }

 
    


}