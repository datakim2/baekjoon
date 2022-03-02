package baekjoon14621;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {
	int s;
	int e;
	int w;

	public Edge(int s, int e, int w) {
		super();
		this.s = s;
		this.e = e;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}

public class Main {
	static int V,E;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	static int[] parent;
	
	public static void makeSet() {
		parent = new int[V+1];
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a==parent[a]) return a;
		return parent[a]=findSet(parent[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		V = Integer.parseInt(s[0]);
		E = Integer.parseInt(s[1]);
		int[] node = new int[V+1];
		int visitedCnt = 0;
		String[] s3 = br.readLine().split(" ");
		for(int i=1; i<=V; i++) {
			if(s3[i-1].equals("M")) {
			node[i] = 0;
			}
			else node[i] = 1;
		}
		
		for(int i=1; i<=E; i++) {
			String[] s2 = br.readLine().split(" ");
			int sNum = Integer.parseInt(s2[0]);
			int eNum = Integer.parseInt(s2[1]);
			int wNum = Integer.parseInt(s2[2]);
			edgeList.add(new Edge(sNum, eNum, wNum));
		}
		
		makeSet();
		Collections.sort(edgeList);
		
		int res = 0, cnt = 0;
		
		for(Edge e : edgeList) {
			if(node[e.s]!=node[e.e]) {
			if(union(e.s, e.e)) {
				visitedCnt++;
				res+=e.w;
				if(++cnt == V-1) break;
			}
			}
		}
		if(visitedCnt!=V-1) System.out.println(-1);
		else System.out.println(res);
	}

}
