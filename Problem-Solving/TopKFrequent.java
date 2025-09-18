import java.util.*;

public class TopKFrequent {
    class Solution {
    class Pair{
        int val;
        int freq;
        Pair(int x, int y){
            this.val = x;
            this.freq = y;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.freq, a.freq);
        });
        for(int a : map.keySet()){
            Pair cur = new Pair(a, map.get(a));
            heap.add(cur);
        }
        int[] res = new int[k];
        int idx = 0;

        while(k-- > 0){
            Pair p = heap.poll();
            res[idx++] = p.val;
        }
        return res;
    }
}
}
