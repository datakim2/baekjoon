package baekjoon13907;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int e;
	int w;
	int cnt;

	public Node(int e, int w, int cnt) {
		super();
		this.e = e;
		this.w = w;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}

public class Main {
	static int V, E, K, end, taxSum;
	static ArrayList<Node>[] Graph;
	static int[][] dist;
	final static int INF = 987654321;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		V = stoi(s[0]);
		E = stoi(s[1]);
		K = stoi(s[2]);

		Graph = new ArrayList[V + 1];
		dist = new int[V + 2][V + 2]; // 거리, 카운트를 동시에 체크하기 위하여 2차원 배열 활용

		for (int i = 1; i <= V; i++) {
			Graph[i] = new ArrayList<>();
		}

		String[] s2 = br.readLine().split(" ");
		int start = stoi(s2[0]);
		end = stoi(s2[1]);

		for (int i = 1; i <= E; i++) {
			String[] s3 = br.readLine().split(" ");
			int sNum = stoi(s3[0]);
			int eNum = stoi(s3[1]);
			int wNum = stoi(s3[2]);
			Graph[sNum].add(new Node(eNum, wNum, 0));
			Graph[eNum].add(new Node(sNum, wNum, 0));
		}

		bfs(start);
		cal();

		for (int i = 0; i < K; i++) {
			taxSum += stoi(br.readLine());
			cal();
		}
		System.out.println(sb);

	}

	public static void cal() {
		int res = INF;
		for (int i = 1; i <= V; i++) {
			int distTemp = dist[end][i] + taxSum * i;
			res = Math.min(res, distTemp);
		}
		sb.append(res).append("\n");
	}

	public static void bfs(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0, 0));
		for (int i = 1; i <= V; i++) {
			for (int j = 0; j <= V; j++) {
				dist[i][j] = INF;
			}
		}

		dist[start][0] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.e;
			int nc = curNode.cnt;

			if (dist[cur][nc] < curNode.w)
				continue;

			if (nc >= V)
				continue;

			from: for (Node next : Graph[cur]) {

				for (int i = 0; i <= nc; i++) {
					if (dist[cur][nc] + next.w > dist[next.e][i])
						continue from;
				}

				if (dist[next.e][nc + 1] > dist[cur][nc] + next.w) {
					dist[next.e][nc + 1] = dist[cur][nc] + next.w;
					pq.add(new Node(next.e, next.w, nc + 1));
				}
			}
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
