package baekjoon6118;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int to;
	int weight;

	public Node(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

public class Main {
	static int N, M;
	static int dist[];
	static final int INF = 20000;
	static ArrayList<Node>[] Graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		N = stoi(s[0]);
		M = stoi(s[1]);

		Graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] s2 = br.readLine().split(" ");
			int from = stoi(s2[0]);
			int to = stoi(s2[1]);
			int weight = 1;

			Graph[from].add(new Node(to, weight));
			Graph[to].add(new Node(from, weight));
		}

		djikstra(1); // 최단 거리 다익스트라

		int max = -1;
		int maxIdx = 0;
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dist[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (max == dist[i]) {
				cnt++;
				if (maxIdx == 0) {
					maxIdx = i;
				}
			}
		}

		System.out.println(maxIdx + " " + dist[maxIdx] + " " + cnt);

	}

	static void djikstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean[] visited = new boolean[N + 1];
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.to;

			if (dist[cur] < curNode.weight)
				continue;

			if (visited[cur])
				continue;

			visited[cur] = true;

			for (Node n : Graph[cur]) {
				if (dist[n.to] > dist[cur] + n.weight) {
					dist[n.to] = dist[cur] + n.weight;
					pq.add(new Node(n.to, dist[n.to]));
				}
			}
		}

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
