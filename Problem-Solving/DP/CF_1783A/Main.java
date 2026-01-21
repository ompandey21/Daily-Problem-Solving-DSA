package DP.CF_1783A;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++) arr[i] = sc.nextInt();
            if(n > 1 && arr[0] == arr[1]){
                boolean flag = false;
                for(int i = 1; i<n; i++){
                    if(arr[i] != arr[0]){
                        int temp = arr[0];
                        arr[0] = arr[i];
                        arr[i] = temp;
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    System.out.println("NO");
                    continue;
                }
            }
            int[] prefix = new int[n];
            prefix[0] = arr[0];
            List<Integer> li = new ArrayList<>();
            boolean isUgly = false;
            for(int i = 1; i<n; i++){
                prefix[i] = prefix[i-1] + arr[i];
                if(arr[i] == prefix[i-1]){ 
                    li.add(i);
                    isUgly = true;
                }
            }

            // System.out.println(Arrays.toString(arr));
            if(!isUgly){
                System.out.println("YES");
                for(int a : arr) System.out.print(a + " ");
                System.out.println();
                continue;
            }
            for(int idx : li){
                if(arr[0] != arr[idx]){
                    int temp = arr[0];
                    arr[0] = arr[idx];
                    arr[idx] = temp;
                }
            }
            // System.out.println(Arrays.toString(arr));

            isUgly = false;
            prefix[0] = arr[0];
            for(int i = 1; i<n; i++){
                prefix[i] = prefix[i-1] + arr[i];
                if(arr[i] == prefix[i-1]){ 
                    li.add(i);
                    isUgly = true;
                }
            }
            if(!isUgly){
                System.out.println("YES");
                for(int a : arr) System.out.print(a + " ");
                System.out.println();
                continue;
            }

            
        }
    }
}
