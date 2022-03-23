package baekjoon8012;

import java.io.*;
import java.util.ArrayList;

public class Main {
	static int V, E, h;
	static int[] dist, depth;
	static int[][] parent;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = stoi(br.readLine());
		E = V - 1;

		tree = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}

		dist = new int[V + 1];
		depth = new int[V + 1];

		h = getTreeH();

		parent = new int[V + 1][h];

		for (int i = 0; i < E; i++) {
			String[] s = br.readLine().split(" ");
			int from = stoi(s[0]);
			int to = stoi(s[1]);
			tree[from].add(to);
			tree[to].add(from);
		}

		init(1, 1, 0);
		fillParents();
		
		int M = stoi(br.readLine());

		int[] city = new int[M];

		for (int i = 0; i < M; i++) {
			city[i] = stoi(br.readLine());
		}

		int ans = 0;

		for (int i = 0; i < M - 1; i++) {
			int a = city[i];
			int b = city[i + 1];
			int res = LCA(a, b);

			ans += dist[a] + dist[b] - 2 * dist[res];
		}

		System.out.println(ans);

	}

	public static int getTreeH() {
		return (int) Math.ceil(Math.log(V) / Math.log(2)) + 1;
	}

	public static void init(int cur, int h, int pa) {
		depth[cur] = h;
		for (int next : tree[cur]) {
			if (next != pa) {
				dist[next] = dist[cur] + 1;
				init(next, h + 1, cur);
				parent[next][0] = cur;
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

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
