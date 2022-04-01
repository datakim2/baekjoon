package baekjoon4485;

import java.io.*;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int x;
	int y;
	int weight;

	public Node(int x, int y, int weight) {
		super();
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

public class Main {
	static int[][] map;
	static int[][] dist;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = 0;

		while (true) {
			tc++;
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
					dist[i][j] = 2251;
				}
			}
			sb.append("Problem " + tc + ": " + bfs()).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		br.close();
		bw.close();
	}

	public static int bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = map[0][0];
		pq.add(new Node(0, 0, dist[0][0]));

		while (!pq.isEmpty()) {
			Node n = pq.poll();

			for (int i = 0; i < 4; i++) {

				int x = n.x + dx[i];
				int y = n.y + dy[i];

				if (x < 0 || y < 0 || x >= N || y >= N)
					continue;

				if (dist[x][y] > dist[n.x][n.y] + map[x][y]) {
					dist[x][y] = dist[n.x][n.y] + map[x][y];
					pq.add(new Node(x, y, dist[x][y]));
				}
			}
		}
		return dist[N - 1][N - 1];
	}

}
