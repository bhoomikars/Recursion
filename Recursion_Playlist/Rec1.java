package Recursion_Playlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    public void printSubSequencesWhoseSumIsK(ArrayList<Integer> list, int idx, int[] arr, int sum) {
        if (idx >= arr.length) {
            int val = list.stream().mapToInt(a -> a).sum();
//            int val2 = list.stream().reduce(0 ,(a, b)-> a+b);
            if(val == sum){
                System.out.println(list);
            }
            return;
        }
        list.add(arr[idx]);
        //pick
        printSubSequencesWhoseSumIsK(list, idx + 1, arr, sum);
        list.remove(list.size() - 1);
        //do not pick
        printSubSequencesWhoseSumIsK(list, idx + 1, arr, sum);
    }


    public void printSubSequencesOfString(int idx, String str, String out) {
        if(idx >= str.length()){
            System.out.println(out);
            return;
        }
        out = out + str.charAt(idx);
        printSubSequencesOfString(idx+1, str, out);

        out = out.substring(0, out.length()-1);
        printSubSequencesOfString(idx+1, str, out);

    }

    public boolean isSubsequence(String s, String t) {

        ArrayList<String> list = getSubsequence(new ArrayList<>(),t, 0 , "");
        if(list.contains(s)){
            return true;
        }
        return false;
    }

    public ArrayList<String> getSubsequence(ArrayList<String> list, String s, int idx, String out){
        if(idx >= s.length()){
            list.add(out);
            return list;
        }

        out = out + s.charAt(idx);
        getSubsequence(list, s, idx+1, out);
        out = out.substring(0, out.length()-1);
        getSubsequence(list, s, idx+1, out);

        return list;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        getResultListForCombinationSum1(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void getResultListForCombinationSum1(int[] arr, int target, int idx, ArrayList<Integer> list, List<List<Integer>> ans){
        if(idx >= arr.length){

            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[idx] <= target){
            list.add(arr[idx]);
            getResultListForCombinationSum1(arr, target - arr[idx] , idx, list, ans);
            list.remove(list.size()-1);
        }
        getResultListForCombinationSum1(arr, target, idx+1, list, ans);

    }

    public List<Integer> sumOfTheSubset(int[] arr, int idx, List<Integer> list, int sum){
        if(idx >= arr.length){
            list.add(sum);
            return list;
        }

        sumOfTheSubset(arr, idx+1, list, sum+arr[idx]);
        sumOfTheSubset(arr, idx+1, list, sum);

        return list;
    }


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        generateSubset(nums, new ArrayList<>(), 0, ans);
        return ans;

    }

    public void generateSubset(int [] arr, ArrayList<Integer> list, int idx, List<List<Integer>>  ans){

        if(idx >= arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[idx]);
        generateSubset(arr,list, idx+1, ans);
        list.remove(list.size()-1);
        generateSubset(arr,list, idx+1, ans);
    }


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        generatePermutation(nums, new ArrayList<>(),freq, 0, ans);
        return ans;

    }



    public void generatePermutation(int[] arr, ArrayList<Integer> ds, boolean[] freq, int idx, List<List<Integer>> ans){
        if(idx >= arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i =0; i<arr.length ; i++){
            if(!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);
                generatePermutation(arr, ds, freq, idx + 1, ans);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }

        }
    }

}
