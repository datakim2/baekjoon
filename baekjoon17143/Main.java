package baekjoon17143;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class shark {
	int r;
	int c;
	int oriR;
	int oriC;
	int speed; // 속력
	int oriSpeed; // 속력
	int d; // 이동 방향 1 위 2 아래 3 오른쪽 4 왼쪽
	int size; // 크기

	public shark(int r, int c, int oriR, int oriC, int speed, int oriSpeed, int d, int size) {
		super();
		this.oriR = oriR;
		this.oriC = oriC;
		this.r = r;
		this.c = c;
		this.speed = speed;
		this.oriSpeed = oriSpeed;
		this.d = d;
		this.size = size;
	}
}

public class Main {
	static int R, C, M, oriR, oriC;
	static shark[][] map;
	static shark[][] newMap;
	static Queue<shark> q = new LinkedList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = stoi(s[0]);
		C = stoi(s[1]);
		M = stoi(s[2]);

		map = new shark[R + 1][C + 1];
		newMap = new shark[R + 1][C + 1];

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				newMap[i][j] = new shark(i, j, i, j, 0, 0, 0, 0);
				map[i][j] = new shark(i, j, i, j, 0, 0, 0, 0);
			}
		}

		for (int i = 0; i < M; i++) {
			String[] s2 = br.readLine().split(" ");
			int r = stoi(s2[0]);
			int c = stoi(s2[1]);
			int speed = stoi(s2[2]);
			int d = stoi(s2[3]) - 1;
			if (d <= 1)
				speed = speed%((R-1)*2);
			else
				speed = speed%((C-1)*2);
			int size = stoi(s2[4]);
			map[r][c] = new shark(r, c, r, c, speed, speed, d, size);
		}

		int sum = 0;

		for (int i = 1; i <= C; i++) {

			for (int j = 1; j <= R; j++) {
				if (map[j][i] != null && map[j][i].size != 0) {
					sum += map[j][i].size;
					map[j][i] = null;

					break;
				} // 포획

			}
			setting();
			move();

		}

		System.out.println(sum);
	}

	public static void setting() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				newMap[i][j] = new shark(i, j, i, j, 0, 0, 0, 0);
				if (map[i][j] == null)
					map[i][j] = new shark(i, j, i, j, 0, 0, 0, 0);
				else if (map[i][j] != null && map[i][j].size > 0) {
					q.add(map[i][j]);
				}
			}
		}
	}

	public static void move() {

		while (!q.isEmpty()) {
			shark sh = q.poll();
			if (sh.speed == 0) {

				if (newMap[sh.r][sh.c] != null) {
					if (newMap[sh.r][sh.c].size <= sh.size) {
						if (newMap[sh.oriR][sh.oriC].size == sh.size) {
							newMap[sh.oriR][sh.oriC] = null;
						}
						newMap[sh.r][sh.c] = new shark(sh.r, sh.c, sh.r, sh.c, sh.oriSpeed, sh.oriSpeed, sh.d, sh.size);
					} else {
						if (newMap[sh.oriR][sh.oriC].size == sh.size) {
							newMap[sh.oriR][sh.oriC] = null; // 잡아먹힘
						}
					}
				} else if (newMap[sh.r][sh.c] == null) {
					if (newMap[sh.oriR][sh.oriC].size == sh.size) {
						newMap[sh.oriR][sh.oriC] = null; // 잡아먹힘
					}
					newMap[sh.r][sh.c] = new shark(sh.r, sh.c, sh.r, sh.c, sh.oriSpeed, sh.oriSpeed, sh.d, sh.size);
				}
				continue;
			}

			int nr = sh.r + dx[sh.d];
			int nc = sh.c + dy[sh.d];

			if (isAccesible(nr, nc)) {

				q.add(new shark(nr, nc, sh.oriR, sh.oriC, sh.speed - 1, sh.oriSpeed, sh.d, sh.size));

			} else {
				if (sh.d == 0 || sh.d == 2) {
					q.add(new shark(sh.r, sh.c, sh.oriR, sh.oriC, sh.speed, sh.oriSpeed, sh.d + 1, sh.size));
				} else if (sh.d == 1 || sh.d == 3) {
					q.add(new shark(sh.r, sh.c, sh.oriR, sh.oriC, sh.speed, sh.oriSpeed, sh.d - 1, sh.size));
				}
			}

		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = newMap[i][j];
			}
		}

	}

	public static boolean isAccesible(int r, int c) {
		if (r < 1 || c < 1 || r > R || c > C)
			return false;
		else
			return true;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
