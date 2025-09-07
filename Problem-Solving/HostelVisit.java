import java.util.*;
public class HostelVisit {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		int k = sc.nextInt();
		PriorityQueue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());
		while( q-- > 0 ){
			int type = sc.nextInt();
			if(type == 1) addDistance(heap, sc.nextInt(), sc.nextInt(), k);
			if(type == 2) System.out.println(heap.peek());
		}
    }
	public static void addDistance(PriorityQueue<Long> pq, int a, int b, int k){
		long distance = (long)a * a + (long)b * b;

		if(pq.size() < k) {
			pq.add(distance);
		} else if(distance < pq.peek()) {
			pq.poll();
			pq.add(distance);
		}
	}

	
}
