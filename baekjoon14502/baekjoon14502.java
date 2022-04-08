package baekjoon145022;

import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M, ans = -1;
	static int[][] map;
	static int[][] originMap;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Point> pos = new ArrayList<>();
	static ArrayList<Point> virus = new ArrayList<>();
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		N = stoi(s[0]);
		M = stoi(s[1]);

		map = new int[N + 1][M + 1];
		originMap = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = stoi(s2[j - 1]);
				originMap[i][j] = map[i][j];
				if (map[i][j] == 0) {
					pos.add(new Point(i, j));
				}
				if (map[i][j] == 2) {
					virus.add(new Point(i, j));
				}
			}
		}

		for (int i = 0; i < pos.size() - 2; i++) {
			for (int j = i + 1; j < pos.size() - 1; j++) {
				for (int k = j + 1; k < pos.size(); k++) {
					map[pos.get(i).x][pos.get(i).y] = 1;
					map[pos.get(j).x][pos.get(j).y] = 1;
					map[pos.get(k).x][pos.get(k).y] = 1;
					for (Point v : virus) {
						q.add(v);
					}
					bfs();
					ans = Math.max(ans, mapCheck());
					mapReset();
				}
			}
		}
		System.out.println(ans);
	}

	public static void bfs() {
		boolean[][] visited = new boolean[N + 1][M + 1];
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (isAccesible(nx, ny)) {
					if (!visited[nx][ny] && map[nx][ny] != 1) {
						visited[nx][ny] = true;
						map[nx][ny] = 2;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static void mapReset() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = originMap[i][j];
			}
		}
	}

	public static int mapCheck() {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static boolean isAccesible(int x, int y) {
		if (x < 1 || y < 1 || x > N || y > M)
			return false;
		else
			return true;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
