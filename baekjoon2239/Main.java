package baekjoon2239;

import java.awt.Point;
import java.io.*;
import java.util.ArrayList;

public class Main {
	static int[][] sdoku;
	static int N, M;
	static ArrayList<Point> pos = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 10;
		M = 10;

		sdoku = new int[10][10];

		for (int i = 1; i <= 9; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= 9; j++) {
				sdoku[i][j] = Integer.parseInt(s[j - 1]);
				if (sdoku[i][j] == 0)
					pos.add(new Point(i, j));
			}
		}

		solve(0);
	}

	public static void solve(int idx) {
		if (pos.size() == idx) {
			ans();
			System.exit(0);
		}

		boolean[] check = new boolean[10];
		int x = pos.get(idx).x;
		int y = pos.get(idx).y;

		for (int i = 1; i <= 9; i++) {
			if (sdoku[x][i] != 0) {
				check[sdoku[x][i]] = true;
			}
		} // 가로

		for (int i = 1; i <= 9; i++) {
			if (sdoku[i][y] != 0) {
				check[sdoku[i][y]] = true;
			}
		} // 세로

		int tempX = (x - 1) / 3 * 3 + 1;
		int tempY = (y - 1) / 3 * 3 + 1;
		for (int i = tempX; i <= tempX + 2; i++) {
			for (int j = tempY; j <= tempY + 2; j++) {
				if (sdoku[i][j] != 0) {
					check[sdoku[i][j]] = true;
				}
			}
		} // 3 X 3

		for (int i = 1; i <= 9; i++) {
			if (!check[i]) {
				sdoku[x][y] = i;
				solve(idx + 1);
				sdoku[x][y] = 0;
			}
		}

	}

	public static void ans() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				sb.append(sdoku[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		return;
	}

}
