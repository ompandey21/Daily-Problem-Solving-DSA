package DataStructures;

import java.util.ArrayList;

public class Heap {
    
    private ArrayList<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void add(int value) {
        heap.add(value);
        upHeap(heap.size() - 1);
    }
    private void upHeap(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && heap.get(index) < heap.get(parentIndex)) {
            swap(index, parentIndex);
            upHeap(parentIndex);
        }
    }
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public int remove() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }   
        int rootValue = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        downHeap(0);
        return rootValue;
    }
    public void downHeap(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;   
        if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }   
        if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(index, smallest);
            downHeap(smallest);
        }   
    }
    public int get(){
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0); 
    } 
    public void display() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
}
