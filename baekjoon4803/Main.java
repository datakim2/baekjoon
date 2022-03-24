package baekjoon4803;

import java.io.*;
import java.util.ArrayList;

public class Main {
	static int V, E;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static boolean isCycle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caseNum = 1;

		while (true) {

			String[] s = br.readLine().split(" ");
			V = stoi(s[0]);
			E = stoi(s[1]);

			if (V == 0 && E == 0)
				break;

			tree = new ArrayList[V + 1];
			visited = new boolean[V + 1];
			for (int i = 1; i <= V; i++) {
				tree[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				String[] s2 = br.readLine().split(" ");
				int from = stoi(s2[0]);
				int to = stoi(s2[1]);
				tree[from].add(to);
				tree[to].add(from);
			}

			int cnt = 0;

			for (int i = 1; i <= V; i++) {
				if (!visited[i]) {
					isCycle = false;
					dfs(i, 0);
					if (!isCycle)
						cnt++;
				}
			}

			if (cnt == 0)
				sb.append("Case "+caseNum+": No trees.").append("\n");
			else if (cnt == 1)
				sb.append("Case "+caseNum+": There is one tree.").append("\n");
			else {
				sb.append("Case "+caseNum+": A forest of " + cnt + " trees.").append("\n");

			}
			caseNum++;
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int cur, int pa) {
		visited[cur] = true;

		for (int next : tree[cur]) {
			if (next!=pa) {
				if(!visited[next]) {
				dfs(next, cur);
			}
			else {
				isCycle = true;
			}
			}
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
