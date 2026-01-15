package Pasha_and_String;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt() - 1;
        }
        
        
        int l = s.length();
        int[] sum = new int[l/2];
        for(int i = 0; i<n; i++){
            sum[arr[i]]++;
        }
        for(int i = 1; i<l/2; i++){
            sum[i]+= sum[i-1];
        }
        char[] ch = s.toCharArray();
        for(int i = 0; i<l/2; i++){
            
            
            if(sum[i] % 2== 0) continue;
            char temp = ch[i];
            // System.out.println(i);
            ch[i] = ch[l - i -1];
            ch[l - i - 1] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : ch){
            sb.append(c);
        }
        
        System.out.println(sb.toString());
        
        
    }
}