package baekjoon2573;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, ans, time;
	static boolean[][] visited;
	static boolean zeroCheck = true;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		N = stoi(s[0]);
		M = stoi(s[1]);
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = stoi(s2[j]);
			}
		}

		while (true) {
			time++;
			melt();
			if(zeroCheck) {
				ans = 0;
				break;
			}
			if (doubleCheck()) {
				ans = time;
				break;
			}
		}

		System.out.println(ans);

	}

	static boolean doubleCheck() {
		int cnt = 0;
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j);
					cnt++;
				}
			}
		}

		if (cnt >= 2)
			return true;
		else
			return false;
	}

	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (!isPossible(nx, ny))
					continue;

				if (!visited[nx][ny] && map[nx][ny]!=0) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}

		}

	}

	static boolean isPossible(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= M)
			return false;
		else
			return true;
	}

	static void melt() {
		int[][] tempMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				int water = 0;
				if(map[i][j]!=0) {
					zeroCheck = false;
				for (int t = 0; t < 4; t++) {
					int x = i + dx[t];
					int y = j + dy[t];
					if(!isPossible(x,y)) continue;
					if (map[x][y] == 0) {
						water++;
					}
				}
				tempMap[i][j] -= water;
				if(tempMap[i][j]<0) tempMap[i][j] = 0;
			}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = tempMap[i][j];
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
