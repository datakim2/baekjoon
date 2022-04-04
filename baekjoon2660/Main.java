package baekjoon2660;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class member implements Comparable<member> {
	int max;
	int idx;

	public member(int max, int idx) {
		super();
		this.max = max;
		this.idx = idx;
	}

	@Override
	public int compareTo(member o) {
		if (this.max == o.max)
			return this.idx - o.idx;
		else
			return this.max - o.max;
	}
}

public class Main {
	static final int INF = 10000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = stoi(br.readLine());

		int[][] graph = new int[V + 1][V + 1];

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j)
					graph[i][j] = 0;
				else
					graph[i][j] = INF;
			}
		}

		while (true) {
			String[] s = br.readLine().split(" ");
			int from = stoi(s[0]);
			int to = stoi(s[1]);

			if (from == -1 && to == -1)
				break;

			graph[from][to] = 1;
			graph[to][from] = 1;
		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		ArrayList<member> list = new ArrayList<>(20);

		for (int i = 1; i <= V; i++) {
			int max = -1;
			for (int j = 1; j <= V; j++) {
				max = Math.max(max, graph[i][j]);
			}
			list.add(new member(max, i));
		}
		Collections.sort(list);

		int min = list.get(0).max;
		int cnt = 1;
		int idx = 1;
		for (int i = 1; i < list.size(); i++) {
			if (min == list.get(i).max) {
				cnt++;
				idx = i + 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		System.out.println(min + " " + idx);
		for (member a : list) {
			if (a.max != min)
				break;
			sb.append(a.idx + " ");
		}
		System.out.println(sb.toString().trim());
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
