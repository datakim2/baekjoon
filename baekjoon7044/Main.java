package baekjoon7044;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {
	int f;
	int t;
	long w;

	public Edge(int f, int t, long w) {
		super();
		this.f = f;
		this.t = t;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.w > o.w)
			return -1;
		else if (this.w == o.w)
			return 0;
		else
			return 1;
	}
}

public class Main {
	static int V, E;
	static int[] parent;
	static ArrayList<Edge> edgeList = new ArrayList<>();;

	static void makeSet() {
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = findSet(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;

		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		V = stoi(s[0]);
		E = stoi(s[1]);


		for (int i = 0; i < E; i++) {
			String[] s2 = br.readLine().split(" ");
			int f = stoi(s2[0]);
			int t = stoi(s2[1]);
			long w = Long.parseLong(s2[2]);

			edgeList.add(new Edge(f, t, w));
			edgeList.add(new Edge(t, f, w));
		}

		makeSet();
		Collections.sort(edgeList);

		int cnt = 0;
		long res = 0;

		for (Edge e : edgeList) {
			if (union(e.f, e.t)) {
				res += e.w;
				if (++cnt == V - 1) {
					System.out.println(res);
					System.exit(0);
				}
			}
		}
		System.out.println(-1);

	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}