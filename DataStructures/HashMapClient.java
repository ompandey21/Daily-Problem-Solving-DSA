package DataStructures;

public class HashMapClient {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 135);
        map.put("USA", 330);    
        map.put("China", 1400);
        map.put("India", 136); 
        map.put("UK", 69);

        System.out.println(map);
    }
}
