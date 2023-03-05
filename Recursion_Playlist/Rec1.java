package Recursion_Playlist;

import java.util.ArrayList;

public class Rec1 {

    int count = 0;

    //swap function
    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void printCount() {
        if (count == 4) {
            return;
        }
        System.out.println(count);
        count++;
        printCount();
    }

    public void printSumN(int n, int sum) {
        if (n < 0) {
            System.out.println(sum);
            return;
        }
        printSumN(n - 1, sum + n);
    }

    public int printSumN1(int n) {
        if (n == 0) {
            return 0;
        }
        return n + printSumN1(n - 1);
    }

    public int printFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * printFactorial(n - 1);
    }

    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return factorial(n - 1) + factorial(n - 2);
    }

    public void reverse(int i, int n, int[] arr) {
        if (i >= n / 2)
            return;
        swap(i, n - i - 1, arr);
        reverse(i + 1, n, arr);
    }

    public boolean palindrome(String s, int i) {
        if (i >= s.length() / 2)
            return true;

        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }
        return palindrome(s, i + 1);
    }


    public void printSubSequences(ArrayList<Integer> list, int idx, int[] arr) {
        if (idx >= arr.length) {
            System.out.println(list);
            return;
        }
        list.add(arr[idx]);
        //pick
        printSubSequences(list, idx + 1, arr);
        list.remove(list.size() - 1);
        //do not pick
        printSubSequences(list, idx + 1, arr);
    }


}
