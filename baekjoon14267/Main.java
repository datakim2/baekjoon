package baekjoon14267;

import java.io.*;
import java.util.ArrayList;

public class Main {
	static int V, E, h;
	static int[] w;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		V = stoi(s[0]);
		E = stoi(s[1]);

		tree = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}

		String[] s2 = br.readLine().split(" ");

		for (int i = 2; i <= V; i++) {
			tree[stoi(s2[i - 1])].add(i);
		}

		w = new int[V + 1];

		for (int i = 0; i < E; i++) {
			String[] s3 = br.readLine().split(" ");
			int t = stoi(s3[0]);
			w[t] += stoi(s3[1]);
		}

		dfs(1); // 루트노드는 항상 1

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= V; i++) {
			sb.append(w[i] + " ");
		}

		System.out.println(sb.toString());
	}

	public static void dfs(int cur) {

		for (int next : tree[cur]) {
			w[next] += w[cur];
			dfs(next);
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
