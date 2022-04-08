package baekjoon14890;

import java.io.*;

public class Main {
	static int N, X, ans;
	static int[][] map;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		N = stoi(s[0]);
		X = stoi(s[1]);

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(s2[j]);
			}
		}

		ans = 0;

		for (int i = 0; i < N; i++)
			dfs(i, 0, 1, 1, false);
		for (int i = 0; i < N; i++)
			dfs(0, i, 0, 1, false); // flag : false 오르막길, true 내리막길
									// 가로 탐색 dir 1 , 세로 탐색 dir 0

		System.out.println(ans);

	}

	public static void dfs(int x, int y, int dir, int cnt, boolean flag) {

		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (nx == N || ny == N) {
			if (!flag || (flag && cnt >= X))
				ans++;
			return;
		}

		if (map[x][y] == map[nx][ny])
			dfs(nx, ny, dir, cnt + 1, flag);

		else {

			if (Math.abs(map[nx][ny] - map[x][y]) >= 2)
				return;

			if (map[nx][ny] > map[x][y] && !flag && cnt >= X) { // 오르막 -> 오르막
				dfs(nx, ny, dir, 1, false);
			} else if (map[nx][ny] > map[x][y] && flag && cnt >= 2 * X) { // 내리막 -> 오르막
				dfs(nx, ny, dir, 1, false);
			} else if (map[nx][ny] < map[x][y] && flag && cnt >= X) { // 내리막 -> 내리막
				dfs(nx, ny, dir, 1, true);
			} else if (map[nx][ny] < map[x][y] && !flag) { // 오르막 -> 내리막
				dfs(nx, ny, dir, 1, true);
			}
		}

	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
