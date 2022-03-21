package baekjoon2234;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class pos {
	int x;
	int y;
	int binary;

	public pos(int x, int y, int binary) {
		super();
		this.x = x;
		this.y = y;
		this.binary = binary;
	}
}

public class Main {
	static int N, M, cnt, roomArea = 1, maxRoomArea = -1;
	static int[][] map, temp;
	static boolean[][] visited;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] s = br.readLine().split(" ");

		N = stoi(s[1]);
		M = stoi(s[0]);

		map = new int[N][M];
		temp = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = stoi(s2[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j, map);
					cnt++; // 방 개수 카운트
				}
			}
		}
		sb.append(cnt).append("\n");
		sb.append(maxRoomArea).append("\n");

		for (int i = 0; i < N; i++) {
			temp[i] = map[i].clone();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] > 0) {
					for (int k = 1; k <= 8; k = k << 1) {
						visited = new boolean[N][M];
						roomArea = 1;

						if ((temp[i][j] & k) == k) {
							temp[i][j] = temp[i][j] - k;
							visited[i][j] = true;
							bfs(i, j, temp);
							temp[i][j] = temp[i][j] + k; // 백트래킹
						}
					}
				}
			}
		}
		sb.append(maxRoomArea).append("\n");

		System.out.println(sb.toString());

	}

	public static void bfs(int x, int y, int[][] arr) {
		Queue<pos> q = new LinkedList<>();
		q.add(new pos(x, y, arr[x][y]));

		while (!q.isEmpty()) {
			pos p = q.poll();

			for (int i = 1; i <= 8; i = i << 1) {

				if ((arr[p.x][p.y] & i) != i) { // and 연산 후 자기 자신이 나오지 않을 경우 벽이 없는곳

					int dir = baseLog(i, 2);
					int nx = p.x + dx[dir];
					int ny = p.y + dy[dir];

					if (!isAccesible(nx, ny))
						continue;

					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						roomArea++;
						q.add(new pos(nx, ny, arr[nx][ny]));
					}
				}
			}
		}

		maxRoomArea = Math.max(roomArea, maxRoomArea);
		roomArea = 1;
	}

	public static int baseLog(int x, int base) {
		return (int) (Math.log10(x) / Math.log10(base));
	}

	public static boolean isAccesible(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= N || ny >= M)
			return false;
		else
			return true;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
