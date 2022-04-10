package baekjoon1937;

import java.io.*;

public class Main {
	static int N, ans;
	static int[][] dist;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine());

		map = new int[N][N];
		dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(s[j]);
				dist[i][j] = 1;
			}
		}

		int ans = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(ans, dfs(i,j));
			}
		}
		System.out.println(ans);

	}

	public static int dfs(int x, int y) {

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isAccesible(nx, ny) && map[x][y] < map[nx][ny]) {

				dist[nx][ny] = Math.max(dist[x][y] + 1, dfs(nx,ny));
				dfs(nx, ny);
			}
		}
		return dist[x][y];
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
