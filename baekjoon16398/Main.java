package baekjoon16398;

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
	static int V,E,K;
	static ArrayList<Edge> edgeList = new ArrayList<>(20);
	static int parent[];
	
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		V = Integer.parseInt(s[0]);
		E = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		String[] s2 = br.readLine().split(" ");
		
		for(int i=1; i<=E; i++) {
			String[] s3 = br.readLine().split(" ");
			int sNum = Integer.parseInt(s3[0]);
			int eNum = Integer.parseInt(s3[1]);
			int wNum = Integer.parseInt(s3[2]);
			edgeList.add(new Edge(sNum, eNum, wNum));
			edgeList.add(new Edge(eNum, sNum, wNum));
		}
		
		makeSet();
		
		for(int i=0; i<K; i++) {
			parent[Integer.parseInt(s2[i])] = 0;
		}
		//발전소 부모노드를 0으로 설정.
		
		Collections.sort(edgeList);
		
		long res=0, cnt = 0;
		
		for(Edge e : edgeList) {
			System.out.printf("%d %d %s\n", e.s, e.e, union(e.s, e.e));
			if(union(e.s,e.e)) {
				res+=e.w;
				if(++cnt == V-1) break;
			}
		}
		
		System.out.println(res);

	}

}
