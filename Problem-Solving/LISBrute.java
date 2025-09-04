import java.util.*;

public class LISBrute {
	class Solution {
	    public int lengthOfLIS(int[] nums) {
	    	return LIS(nums);
	    }

		private int LIS(int[] nums) {
			int[] lis = new int[nums.length];
			Arrays.fill(lis, 1);
			
			for(int i=0;i<nums.length;i++) {
				for(int j=i-1;j>=0;j--) {
					if(nums[j] < nums[i]) {
						int l = lis[j];
						lis[i] = Math.max(lis[i], l+1);
					}
				}
			}
			int max = lis[0];
			for(int i=0;i<lis.length;i++) {
				max = Math.max(max, lis[i]);
			}
			
			return max;
		}
	}
}