package Algorithms.BitMasking.PowerSet.LeetCode_2683;

class Solution {
    public int minimizeXor(int num1, int num2) {
        int bits = 0;
        int n = num2;
		while(n>0) {
			bits++;
			n = (n&(n-1));
		}
        System.out.println(bits);
        
        int x = 0;

        for(int i = 30; i >= 0; i--){
            int cur = (1 << i);
            if((num1 & cur) != 0){
                x|=cur;
                bits--;
            }
            if(bits == 0) return x;
        }
        // System.out.println(x);
        for(int i = 0; i <= 30; i++){
            int cur = (1 << i);
            if((num1 & cur) == 0){
                x|=cur;
                bits--;
            }
            if(bits == 0) return x;
        }
        return x;
    }
}