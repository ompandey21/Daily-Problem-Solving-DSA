package DP;

import java.util.Arrays;
import java.util.Scanner;

public class FairDivision {
    public static void main(String[] args){
        Scanner sc = new Scanner((System.in));

        int t = sc.nextInt();

        while( t-- > 0 ){
            int n = sc.nextInt();

            int[] arr = new int[n];

            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();

            }
            Arrays.sort(arr);
            int res = 0;
            for(int i = n-1; i>=0; i--){
                
                if(res <= 0) res += arr[i];
                else res -= arr[i];

            }
            System.out.println(res == 0 ? "YES" : "NO");

            
        }
        sc.close();
    }
}
