package DataStructures;

public class HeapClient {
    public static void main(String[] args) {
    Heap heap = new Heap();
        heap.add(10);
        heap.add(20);
        heap.add(5);
        heap.add(15);
        heap.add(30);
    heap.display();
        System.out.println("Minimum element: " + heap.get());
        System.out.println("Removed element: " + heap.remove());
        heap.display();
    }
}
