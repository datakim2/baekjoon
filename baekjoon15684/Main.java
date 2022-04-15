package baekjoon15684;

import java.io.*;

public class Main {
	static int N, M, H, ans;
	static int[][] map;
	static boolean isPossible = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		N = stoi(s[0]);
		M = stoi(s[1]);
		H = stoi(s[2]);
		map = new int[H + 1][N + 1];

		int x, y;

		for (int i = 0; i < M; i++) {
			String[] s2 = br.readLine().split(" ");
			x = stoi(s2[0]);
			y = stoi(s2[1]);
			map[x][y] = 1;
			map[x][y + 1] = 2;
		}

		for (int i = 0; i <= 3; i++) {
			ans = i;
			dfs(1, 0);
			if (isPossible) {
				System.out.println(ans);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}

	public static void dfs(int idx, int count) {
		if (isPossible)
			return;

		if (ans == count) {
			if (check()) {
				isPossible = true;
			}
			return;
		}

		for (int i = idx; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1;
					map[i][j + 1] = 2;
					dfs(i, count + 1);
					map[i][j] = 0;
					map[i][j + 1] = 0;
				}
			}
		}
	}

	public static boolean check() {
		for (int i = 1; i <= N; i++) {
			int x = 1, y = i;
			for (int j = 0; j < H; j++) {
				if (map[x][y] == 1) {
					y++;
				} else if (map[x][y] == 2) {
					y--;
				}
				x++;
			}
			if (y != i)
				return false;
		}
		return true;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
