import java.util.Scanner;
import java.*;

public class solution {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(printSum());
        System.out.println(reverse());
        printStar();
        findMax();

    }

//question1
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

    //question2
    public static String reverse() {
        String str = scn.nextLine();
        return reverseString(str);

    }

    public static String reverseString(String str) {
        if (str.length() == 0)
            return str;
        // Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void printStar() {
        int n = scn.nextInt();
        printStarrec(n, 0);
    }


///question 3
    public static void printStarrec(int n, int idx) {
        if (idx > n) {
            return;
        }

        for (int i = 1; i <= idx; i++)
            System.out.print('*');

        System.out.println();
        printStarrec(n, idx + 1);
    }
    


    //question4
    public static void findMax() {
        int arrayLength;
        int A[]=new int[arrayLength];
        for(int i=0;i<A.length;i++)
        {
            A[i]=scn.nextInt();
        }
        int n = A.length;

        System.out.println(findMaxRec(A, n));
    }

    public static int findMaxRec(int A[], int n) {
        if (n == 1)
            return A[0];

        return Math.max(A[n - 1], findMaxRec(A, n - 1));
    }

}