package Algorithms.BitMasking.PowerSet.CF_1325D;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long xor = sc.nextLong();
        long sum = sc.nextLong();
        if(xor > sum || Math.abs(xor - sum) % 2 != 0){
            System.out.println(-1);
            return;
        }
        if(xor == sum){
            if(sum == 0){
                System.out.println(0);
                return;
            }
            System.out.println(1);
            System.out.println(sum);
            return;
        }
        long x = (sum - xor)/2;
        long y = xor ^ x;
        if(y == xor + x){
            System.out.println(2);
            System.out.println((xor + x) + " " + x);
            return;
        }

        
        System.out.println(3);
        System.out.println(xor + " " + x + " " + x);
        

    }
}
