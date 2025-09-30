package Algorithms;

import java.util.*;

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
    
        int[] res =  new int[length];

        for(int[] arr : updates){
            int start = arr[0];
            int end = arr[1];
            int val = arr[2];
            res[start]+=val;
            if(end < length - 1) res[end + 1]-=val;
        }
        for(int i = 1; i<length; i++){
            res[i]+= res[i-1];
        }
        return res;
    }
}

public class DifferenceArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int k = sc.nextInt();


        int[][] updates = new int[k][3];
        for (int i = 0; i < k; i++) {
            updates[i][0] = sc.nextInt(); // start
            updates[i][1] = sc.nextInt(); // end
            updates[i][2] = sc.nextInt(); // inc
        }
        Solution sol = new Solution();
        int[] result = sol.getModifiedArray(length, updates);

        System.out.println("Modified array: " + Arrays.toString(result));

        sc.close();
    }
}

