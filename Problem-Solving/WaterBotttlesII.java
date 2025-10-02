// LeetCode 3100 --> POTD 2nd Oct 2025

public class WaterBotttlesII {
    class Solution {
    public int maxBottlesDrunk(int n, int m) {
        return findMax(n, 0, 0, m);
    }
    public int findMax(int full, int empty, int drunk, int rate){
        if( full == 0 && empty < rate) return drunk;
        if( empty >= rate) return findMax( full + 1, empty - rate, drunk, rate + 1);
        return findMax(0, empty + full, drunk + full, rate);
    }
}
}
