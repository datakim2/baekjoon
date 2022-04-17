package baekjoon20295;

import java.io.*;
import java.util.ArrayList;

class Node {
	int to;
	int weight;

	public Node(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}
}

public class Main {
	static int[] depth;
	static long[] dist;
	static int[][] parent;
	static ArrayList<Node>[] tree;
	static int V, E, Q, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = stoi(br.readLine());
		E = V - 1;

		tree = new ArrayList[V + 1];
		depth = new int[V+1];
		dist = new long[V+1];
		for (int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}
		
		String[] s = br.readLine().split(" ");

		for (int i = 0; i < E; i++) {
			String[] s2 = br.readLine().split(" ");
			int from = stoi(s2[0]);
			int to = stoi(s2[1]);
			int weight = 1;
			tree[from].add(new Node(to, weight));
			tree[to].add(new Node(from, weight));
		}

		h = getTreeH();
		parent = new int[V+1][h];

		init(1, 1, 0);
		fillParents();

		StringBuilder sb = new StringBuilder();
		Q = stoi(br.readLine());

		for (int i = 0; i < Q; i++) {
			String[] s2 = br.readLine().split(" ");
			int from = stoi(s2[0]);
			int to = stoi(s2[1]);
			long min = Math.min(dist[from]+dist[to]-2*dist[LCA(from,to)], dist[from]+dist[to]-2*dist[LCA(to,from)]);
			sb.append(min).append("\n");
		}
		
		System.out.println(sb.toString());

	}

	public static void init(int cur, int h, int pa) {
		depth[cur] = h;

		for (Node next : tree[cur]) {
			if (next.to != pa) {
				dist[next.to] = dist[cur] + next.weight;
				init(next.to, h + 1, cur);
				parent[next.to][0] = cur;
			}
		}
	}

	public static void fillParents() {
		for (int i = 1; i < h; i++) {
			for (int j = 1; j <= V; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
	}

	public static int LCA(int a, int b) {
		int ah = depth[a];
		int bh = depth[b];

		if (ah < bh) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		for (int i = h - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				a = parent[a][i];
			}
		}

		if (a == b)
			return a;

		for (int i = h - 1; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}

		return parent[a][0];
	}

	public static int getTreeH() {
		return (int) Math.ceil(Math.log(V) / Math.log(2)) + 1;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
