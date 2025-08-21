import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public static void main(String[] args) {
        int[][] intervals = {{10, 30}, {5, 10}, {15, 20}, {2,6}, {12,18}, {19,15}, {1,5}, {3,5}};
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0; 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();    
        for(int[] interval : intervals) {
            if (!heap.isEmpty() && heap.peek() <= interval[0]) {
                heap.poll();
            }
            heap.add(interval[1]);
        }   
        return heap.size();
    }
}
