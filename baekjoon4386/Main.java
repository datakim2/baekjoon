package baekjoon4386;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

class Edge {
	int s;
	int e;
	double w;

	public Edge(int s, int e, double w) {
		super();
		this.s = s;
		this.e = e;
		this.w = w;
	}
}

class Point {
	double x;
	double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int V, E;
	static int[] parent;
	static double[][] map;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	static ArrayList<Point> pos = new ArrayList<>();

	public static void makeSet() {
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	public static int findSet(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = findSet(parent[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;

		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		map = new double[V + 1][V + 1];

		for (int i = 1; i <= V; i++) {
			String[] s = br.readLine().split(" ");
			pos.add(new Point(Double.parseDouble(s[0]), Double.parseDouble(s[1])));
		}

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				map[i][j] = Math.sqrt((pos.get(i).x - pos.get(j).x) * (pos.get(i).x - pos.get(j).x)
						+ (pos.get(i).y - pos.get(j).y) * (pos.get(i).y - pos.get(j).y));
			}
		}

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i != j) {
					edgeList.add(new Edge(i, j, map[i - 1][j - 1]));
				}
			}
		}

		makeSet();
		Collections.sort(edgeList, (e1, e2) -> (int) e1.w - (int) e2.w);

		float res = 0, cnt = 0;

		for (Edge e : edgeList) {
			if (union(e.s, e.e)) {
				res += e.w;
				if (++cnt == V - 1)
					break;
			}
		}

		System.out.printf("%.2f", res);

	}
}
