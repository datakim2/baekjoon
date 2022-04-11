package baekjoon2146;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x;
	int y;
	int cnt;

	public Point(int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	static int N, t, ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(s[j]);
			}
		}

		t = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j]!=0) {
					t++;
					map[i][j] = t;
					bfs(i, j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited = new boolean[N][N];
				if (map[i][j] != 0) {
					bfs2(i, j, map[i][j]);
				}
			}
		}

		System.out.println(ans);

	}

	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();

		visited[x][y] = true;
		q.add(new Point(x, y, 0));

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (isAccesible(nx, ny)) {

					if (!visited[nx][ny] && map[nx][ny] != 0) {
						visited[nx][ny] = true;
						map[nx][ny] = t;
						q.add(new Point(nx, ny, 0));
					}
				}
			}
		}
	}

	public static void bfs2(int x, int y, int val) {
		Queue<Point> q2 = new LinkedList<>();

		visited[x][y] = true;
		q2.add(new Point(x, y, 0));
		while (!q2.isEmpty()) {
			Point p = q2.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (isAccesible(nx, ny)) {

					if (!visited[nx][ny] && map[nx][ny] != val) {
						visited[nx][ny] = true;
						if (map[nx][ny] == 0) {
							q2.add(new Point(nx, ny, p.cnt + 1));
						} else {
							ans = Math.min(ans, p.cnt);
						}
					}
				}
			}
		}
	}

	public static boolean isAccesible(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;
		else
			return true;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
