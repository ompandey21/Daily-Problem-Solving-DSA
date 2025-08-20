import java.util.PriorityQueue;

public class KthMaxElement {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < k; i++) {
                pq.add(nums[i]);
            }

            for (int i = k; i < nums.length; i++) {
                int cur = nums[i];
                if (cur > pq.peek()) {
                    pq.poll();
                    pq.add(cur);
                }

            }
            return pq.peek();

        }
    }
}
