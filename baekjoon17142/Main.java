package baekjoon17142;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x;
	int y;
	int time;

	public Point(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class Main {
	static int N, M, ans, time = 0;
	static int[] count;
	static int[][] map;
	static int[][] map2;
	static int[][] dist;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static boolean[] visit;
	static ArrayList<Point> pos = new ArrayList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		N = Integer.parseInt(s[0]); // 가로 세로 맵 크기
		M = Integer.parseInt(s[1]); // 바이러스 개수
		map = new int[N + 1][N + 1];
		map2 = new int[N + 1][N + 1];
		dist = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(s2[j - 1]);
				map2[i][j] = map[i][j];
				dist[i][j] = 1;
				if (map[i][j] == 2) {
					pos.add(new Point(i, j, 0));
				}
			}
		}

		visit = new boolean[pos.size()];
		count = new int[pos.size()];
		for (int i = 0; i < pos.size(); i++) {
			count[i] = i;
		}

		comb(count, visit, 0, pos.size(), M);

		ans = Integer.MAX_VALUE;

		for (int i = 0; i < list.size(); i++) {

			map[pos.get(list.get(i)).x][pos.get(list.get(i)).y] = 3;
			q.add(pos.get(list.get(i)));
			visited[pos.get(list.get(i)).x][pos.get(list.get(i)).y] = true;

			if ((i + 1) % M == 0) {
				bfs();
				if (mapCheck()) {
					ans = Math.min(ans, time);
					time = 0;
				}
				visited = new boolean[N + 1][N + 1];
				q = new LinkedList<>();
				for (int j = 1; j <= N; j++) {
					for (int k = 1; k <= N; k++) {
						map[j][k] = map2[j][k];
					}
				}
			}
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);

		}
	}

	public static void bfs() {

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];

				if (x < 1 || y < 1 || x > N || y > N)
					continue;
				if (!visited[x][y] && (map[x][y] == 0 || map[x][y]==2)) {
					visited[x][y] = true;
					if (mapCheck()) {
						break;
					}
					time = p.time + 1;
					map[x][y] = 2;
					q.add(new Point(x, y, p.time + 1));
				}
			}
		}
	}

	public static void comb(int[] count, boolean[] visit, int start, int n, int r) {
		if (r == 0) {
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					list.add(count[i]);
				}
			}
			return;
		}

		for (int i = start; i < n; i++) {
			visit[i] = true;
			comb(count, visit, i + 1, n, r - 1);
			visit[i] = false;
		}
	}

	public static boolean mapCheck() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
