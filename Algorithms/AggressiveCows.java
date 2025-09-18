package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();

        }
        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[n-1];
        
        

        int low = 1;
        int high = max - min;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(arr, mid, c)){ 
                low = mid + 1;
                ans = mid;
            }
            else high = mid - 1;
        }
        System.out.println(ans);

    }
    public static boolean isPossible(int[] arr, int gap, int cows){
        int last = arr[0];
        cows--;
        for(int i = 1; i<arr.length; i++){
            if(cows == 0) return true;
            if(arr[i] - last >= gap){ 
                cows--;
                last = arr[i];
            }
        }
        return cows == 0;
        

    }
}
