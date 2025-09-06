import java.util.*;

public class SortGame {
    public static void main(String args[]) {
        class Pair {
            String name;
            int salary;
            Pair(String name, int salary) {
                this.name = name;
                this.salary = salary;
            }
        }

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();  // minimum salary
        int n = sc.nextInt();  // number of employees

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.salary != b.salary) {
                    return Integer.compare(b.salary, a.salary); // salary descending
                } else {
                    return a.name.compareTo(b.name); // name ascending
                }
            }
        );

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int salary = sc.nextInt();
            if (salary >= x) {  // filter at insertion
                pq.add(new Pair(name, salary));
            }
        }

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            System.out.println(cur.name + " " + cur.salary);
        }
    }
}
