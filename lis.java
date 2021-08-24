import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        if(n == 0 || n == 1){
            System.out.println(n);
            return;
        }
        //int[][] dp = new int[n][n+1];
        //System.out.println(lis(arr, 0, -1, dp));
        
        int ans = 0;
        int[] dp = new int[n];
        for(int i=0; i<arr.length; i++){
            ans = Math.max(ans, lis2(arr, i, dp));
        }
        System.out.println(ans);
        
        
        // System.out.println(lisTab(arr, n));
    }
    
    public static int lis(int[] arr, int idx, int liu, int[][] dp){
        
        if(idx == arr.length){
            return 0;
        }
        
        if(dp[idx][liu+1] != 0){
            return dp[idx][liu+1];
        }
        
        int l1 = lis(arr, idx+1, liu, dp); // no
        int l2 = 0;
        if(liu == -1 || arr[idx] > arr[liu]){
         l2 = 1 + lis(arr, idx+1, idx, dp); // yes   
        }
        
        int max = Math.max(l1, l2);
        dp[idx][liu+1] = max;
        return max;
    }

    public static int lis2(int[] arr, int idx, int[] dp){
        
        if(dp[idx] != 0){
            return dp[idx];
        }
        int max = 0;
        for(int i=idx+1; i<arr.length; i++){
            if(arr[i] > arr[idx]){
                max = Math.max(max, lis2(arr, i, dp));
            }
        }
        
        dp[idx] = max+1;
        return max + 1;
    }
    
    public static int lisTab(int[] arr, int n){
        int[] dp = new int[n];
        dp[n-1] = 1;
        
        for(int i=n-2; i>=0; i--){
            int max = 0;
            for(int j=i+1; j<dp.length; j++){
                if(arr[j] > arr[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            
            dp[i] = max + 1;
        }
        
       int max = 0;
       for(int i=0; i<n; i++){
           max = Math.max(max, dp[i]);
       }
       return max;
    }

}
