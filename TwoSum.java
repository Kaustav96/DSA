package interview.Microsoft.DSA1;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr = {0, -1, 2, -3, 1};
        int n = arr.length;
        int x = -2;

        twoSumBrute(arr,n,x);
        twoSum2Point(arr,n,x);
        twoSumOpt(arr,n,x);
    }

    private static void twoSumOpt(int[] arr, int n, int x) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int tgt = x-arr[i];

            if(set.contains(tgt)){
                System.out.println(arr[i]+","+tgt);
            }
            set.add(arr[i]);
        }
    }

    private static void twoSum2Point(int[] arr, int n, int x) {
        int l = 0, h = n-1;

        Arrays.sort(arr);
        while(l<h){
            int sum = arr[l]+arr[h];

            if(sum==x){
                System.out.println(arr[l]+","+arr[h]);
                l++;h--;
            }
            if(sum<x){
                l++;
            }else{
                h--;
            }
        }
    }

    private static void twoSumBrute(int[] arr, int n, int x) {
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==x){
                    System.out.println(arr[i]+","+arr[j]);
                }
            }
        }
    }
}
