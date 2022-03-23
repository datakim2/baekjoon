package baekjoon3584;

import java.io.*;
import java.util.ArrayList;

public class Main {
	static int V, E, h;
	static ArrayList<Integer>[] tree;
	static int[] depth;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			V = stoi(br.readLine());
			E = V - 1;

			tree = new ArrayList[V + 1];

			for (int i = 1; i <= V; i++) {
				tree[i] = new ArrayList<>();
			}
			
			boolean[] isVisited = new boolean[V+1];

			for (int i = 0; i < E; i++) {
				String[] s = br.readLine().split(" ");
				int from = stoi(s[0]);
				int to = stoi(s[1]);
				
				isVisited[to] = true;

				tree[from].add(to);
				tree[to].add(from);
			}

			String[] s2 = br.readLine().split(" ");

			int first = stoi(s2[0]);
			int second = stoi(s2[1]);

			h = getTreeH();

			depth = new int[V + 1];
			dp = new int[V + 1][h];
			
			int root = 0;
			for(int i=1; i<=V; i++) {
				if(!isVisited[i]) {
					root = i;
				}
			}

			init(root, 1, 0);
			fillParents();

			sb.append(LCA(first, second)).append("\n");
		}

		System.out.println(sb.toString());

	}

	public static int getTreeH() {
		return (int) (Math.ceil(Math.log(V) / Math.log(2)) + 1);
	}

	public static void init(int cur, int h, int pa) {
		depth[cur] = h;
		for (int next : tree[cur]) {
			if (next != pa) {
				init(next, h + 1, cur);
				dp[next][0] = cur;
			}
		}
	}

	public static void fillParents() {
		for (int i = 1; i < h; i++) {
			for (int j = 1; j <= V; j++) {
				dp[j][i] = dp[dp[j][i - 1]][i - 1];
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
				a = dp[a][i];
			}
		}

		if (a == b)
			return a;

		for (int i = h - 1; i >= 0; i--) {
			if (dp[a][i] != dp[b][i]) {
				a = dp[a][i];
				b = dp[b][i];
			}
		}
		return dp[a][0];
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
