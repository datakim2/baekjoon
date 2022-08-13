package baekjoon13565;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, M;
	static boolean[][] visited;
	static int[][] map;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		N = stoi(s[0]);
		M = stoi(s[1]);

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String[] s2 = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				map[i][j] = stoi(s2[j - 1]);

				if (i == 1) {
					if (map[i][j] == 0) {
						q.add(new Point(i, j));
					}
				}
			}
		}

		bfs();

		for (int i = 1; i <= M; i++) {
			if (visited[N][i]) {
				System.out.println("YES");
				System.exit(0);
			}
		}

		System.out.println("NO");

	}

	static void bfs() {
		
		boolean isFirst = false;

		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if(!isFirst) {
				visited[p.x][p.y] = true;
				isFirst = true;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (!isPossible(nx, ny))
					continue;

				if (!visited[nx][ny] && map[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}

		}
	}

	static boolean isPossible(int nx, int ny) {
		if (nx < 1 || nx > N || ny < 1 || ny > M)
			return false;
		else
			return true;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
