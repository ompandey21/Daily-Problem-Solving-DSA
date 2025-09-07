import java.util.*;

public class RunningMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt(); // number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt(); // size of data stream
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // left side
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // right side
            
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                
                // Insert into appropriate heap
                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
                
                // Balance the heaps
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                }
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
                
                // Calculate and print median
                if (maxHeap.size() > minHeap.size()) {
                    System.out.print(maxHeap.peek() + " ");
                } else {
                    int median = (maxHeap.peek() + minHeap.peek()) / 2;
                    System.out.print(median + " ");
                }
            }
            System.out.println();
        }
        
        sc.close();
    }
}

