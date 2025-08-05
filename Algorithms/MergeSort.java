package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(int[] array, int start, int end) {
        
        if (start < end - 1) {
            int mid = start + (end - start)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }
    public static void merge(int[] arr, int start,int mid, int end){
        int left = start;
        int right = mid ;
        ArrayList<Integer> res = new ArrayList<>();
        
        while(left < mid && right < end){
            if(arr[left] > arr[right]){
                res.add(arr[right++]);
            }else{
                res.add(arr[left++]);
            }
        }
        while(left < mid) res.add(arr[left++]);
        while(right < end) res.add(arr[right++]);
        for(int i = 0; i<res.size(); i++){
            arr[i + start] = res.get(i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();
        mergeSort(array, 0, n);
        for (int i : array) {
            System.out.println(i);
        }
    }
}