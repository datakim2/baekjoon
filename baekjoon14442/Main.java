package baekjoon14442;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class drill {
	int x;
	int y;
	int drillNum;
	int dist;

	public drill(int x, int y, int drillNum, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.drillNum = drillNum;
		this.dist = dist;
	}
}

public class Main {
	static int N, M, K, ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		N = stoi(s[0]);
		M = stoi(s[1]);
		K = stoi(s[2]);

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			String[] s2 = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				map[i][j] = stoi(s2[j - 1]);
			}
		}

		bfs();

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	static void bfs() {
		Queue<drill> q = new LinkedList<>();
		q.add(new drill(1, 1, K, 1));

		while (!q.isEmpty()) {
			drill d = q.poll();

			if (d.x == N && d.y == M) {
				ans = Math.min(ans, d.dist);
			}

			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];

				if (isAceesible(nx, ny) && map[nx][ny] == 0) {
					if (!visited[nx][ny][d.drillNum]) {
						visited[nx][ny][d.drillNum] = true;
						q.add(new drill(nx, ny, d.drillNum, d.dist + 1));
					}
				}

				if (isAceesible(nx, ny) && d.drillNum > 0 && map[nx][ny] == 1) {
					if (!visited[nx][ny][d.drillNum]) {
						visited[nx][ny][d.drillNum] = true;
						q.add(new drill(nx, ny, d.drillNum - 1, d.dist + 1));
					}
				}
			}
		}
	}

	static boolean isAceesible(int x, int y) {
		if (x < 1 || y < 1 || x > N || y > M)
			return false;
		else
			return true;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
