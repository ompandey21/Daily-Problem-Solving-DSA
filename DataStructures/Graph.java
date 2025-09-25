package DataStructures;

import java.util.*;

public class Graph {
	private HashMap<Integer, HashMap<Integer, Integer>> map;

	Graph(int v) {
		map = new HashMap<>();
		for (int i = 0; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void AddEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	public boolean ContainsEdge(int v1, int v2) {
		return map.get(v1).containsKey(v2);
	}

	public boolean ContainsVertex(int v1) {
		return map.containsKey(v1);
	}

	public int noofEdge() {
		int sum = 0;
		for (int vtx : map.keySet()) {
			sum += map.get(vtx).size();
		}
		return sum / 2;
	}

	public void removeEdge(int v1, int v2) {
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}

	public void removeVertex(int v1) {
		for (int nbrs : map.get(v1).keySet()) {
			map.get(nbrs).remove(v1);
		}
		map.remove(v1);
	}

	public void Display() {
		for (int v : map.keySet()) {
			System.out.println(v + " " + map.get(v));
		}
	}
	
	public boolean HasPath(int src,int des) {
		HashSet<Integer> visited = new HashSet<>();
		return HasPath(src,des,visited);
	}
	public void PrintPath(int src,int des) {
		HashSet<Integer> visited = new HashSet<>();
		PrintPath(src,des,visited, new StringBuilder());
	}
	
	private boolean HasPath(int src, int des, HashSet<Integer> visited) {
		if (src == des) {
			return true;
		}
		visited.add(src);
		for (int nbrs : map.get(src).keySet()) {
			if (!visited.contains(nbrs)) {
				boolean ans = HasPath(nbrs, des, visited);
				if (ans) {
					return true;
				}
			}
		}
		return false;
	}
	private void PrintPath(int src, int des, HashSet<Integer> visited, StringBuilder sb) {
		if (src == des) {
            System.out.println(sb.toString());
			return;
		}
		visited.add(src);
		for (int nbrs : map.get(src).keySet()) {
			if (!visited.contains(nbrs)) {
                sb.append(nbrs);
			    HasPath(nbrs, des, visited);
                sb.deleteCharAt(sb.length()-1);
			}
		}
        visited.remove(src);
	}

	public static void main(String[] args) {

	}
}