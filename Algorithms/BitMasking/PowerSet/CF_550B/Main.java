package Algorithms.BitMasking.PowerSet.CF_550B;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int x = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int count = 0;
        for(int i = 3; i < 1 << n; i++){
            if(countSetBit(i) < 2){
                continue;
            }
            if(isPossible(arr, l, r, x, i)) count++;
        }
        System.out.println(count);
    }
    public static int countSetBit(int n){
        int ans = 0;

        while( n > 0 ){
            ans++;
            n = n & (n-1);
        }
        return ans;
    }
    public static boolean isPossible(int[] arr, int l, int r, int x, int i){
        int sum = 0, min = Integer.MAX_VALUE , max = Integer.MIN_VALUE, idx = 0;

        while( i > 0 ){
            if((i & 1) == 1){
                sum += arr[idx];
                min = Math.min(min, arr[idx]);
                max = Math.max(max, arr[idx]);
            }
            i >>= 1;
            idx++;
        }
        return sum >= l && sum <= r && max - min >= x;
    }
}