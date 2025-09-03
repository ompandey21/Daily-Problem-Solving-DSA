import java.util.*;
public class MergeKSorted {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();

		PriorityQueue<Integer> ans = new PriorityQueue<>();

		for(int i = 0; i<k*n; i++){
			ans.add(sc.nextInt());
		}

		while(!ans.isEmpty()){
			System.out.print(ans.poll() + " ");
		}
    }
}
