package DataStructures;

import java.util.ArrayList;

public class HashMapM<K, V> {
    class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int size = 0;
    private ArrayList<Node> buckets = new ArrayList<>();

    public HashMapM(int n) {
        for (int i = 0; i < n; i++) {
            buckets.add(null);
        }
    }
    public HashMapM() {
        this(4);
    }
    public void put(K key, V value) {
        int idx = hashFunction(key);
        Node head = buckets.get(idx);
        Node curr = head;
        while (curr != null) {
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets.set(idx, newNode);
        size++;
        double threshold = 2.0;
        double loadFactor = (1.0 * size) / buckets.size();
        if (loadFactor > threshold) {
            rehash();
        }
        
    }
    private void rehash() {
        ArrayList<Node> oldBuckets = buckets;
        buckets = new ArrayList<>();
        for (int i = 0; i < oldBuckets.size() * 2; i++) {
            buckets.add(null);
        }
        size = 0;
        for (Node head : oldBuckets) {
            Node curr = head;
            while (curr != null) {
                put(curr.key, curr.value);
                curr = curr.next;
            }
        }
    }
    public int hashFunction(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % buckets.size();
    }
    public V get(K key) {
        int idx = hashFunction(key);
        Node curr = buckets.get(idx);
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }
    public boolean containsKey(K key) {
        int idx = hashFunction(key);
        Node curr = buckets.get(idx);
        while (curr != null) {
            if (curr.key.equals(key)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    public V remove(K key) {
        int idx = hashFunction(key);
        Node curr = buckets.get(idx);
        Node prev = null;
        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) {
                    buckets.set(idx, curr.next);
                } else {
                    prev.next = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Node head : buckets) {
            Node curr = head;
            while (curr != null) {
                sb.append(curr.key).append("=").append(curr.value).append(", ");
                curr = curr.next;
            }
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }
}
