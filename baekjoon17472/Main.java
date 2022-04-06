package baekjoon17472;

import java.awt.Point;
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int fidx;
	int tidx;
	Point from;
	Point to;
	int weight;

	public Edge(int fidx, int tidx, Point from, Point to, int weight) {
		super();
		this.fidx = fidx;
		this.tidx = tidx;
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class Main {
	static int[] parent;
	static int V;
	static int N, M, k = 2;
	static int[][] map;
	static int[][] index;
	static boolean[][] visited;
	static ArrayList<Edge> edgeList;

	static void makeSet() {
		parent = new int[101];
		for (int i = 1; i <= 100; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = findSet(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;

		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		N = stoi(s[0]);
		M = stoi(s[1]);

		map = new int[N + 1][M + 1];
		index = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		edgeList = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = stoi(s2[j - 1]);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j); // 군집찾기
					k++;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (index[i][j] > 0) {
					Point from = new Point(i, j);
					int tempVal = index[i][j];

					for (int k = 1; k <= N; k++) {
						for (int l = 1; l <= M; l++) {
							if (tempVal != index[k][l] && index[k][l] > 0) {
								Point to = new Point(k, l);
								if (from.x == to.x) {
									if (Math.abs(from.y - to.y) >= 3 && check(from, to)) {
										edgeList.add(new Edge(index[i][j], index[k][l], from, to,
												Math.abs(from.y - to.y) - 1));
										edgeList.add(new Edge(index[k][l], index[i][j], to, from,
												Math.abs(from.y - to.y) - 1));
									}
								} else if (from.y == to.y) {
									if (Math.abs(from.x - to.x) >= 3 && check(from, to)) {
										edgeList.add(new Edge(index[i][j], index[k][l], from, to,
												Math.abs(from.x - to.x) - 1));
										edgeList.add(new Edge(index[k][l], index[i][j], to, from,
												Math.abs(from.x - to.x) - 1));
									}
								}
							}
						}
					}
				}
			}
		}

		makeSet(); // 집합 생성
		Collections.sort(edgeList);

		int res = 0;

		for (Edge e : edgeList) {
			if (union(e.fidx, e.tidx)) {
				res += e.weight;
			}
		}

		HashSet<Integer> checkSet = new HashSet<>();
		for (int i = 2; i < k; i++) {
			checkSet.add(findSet(i));
		}

		if (res == 0 || checkSet.size() != 1) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}

	}

	public static boolean check(Point from, Point to) {
		int maxX = Math.max(from.x, to.x);
		int minX = Math.min(from.x, to.x);
		int maxY = Math.max(from.y, to.y);
		int minY = Math.min(from.y, to.y);
		boolean result = true;

		if (minX == maxX) {
			for (int j = minY + 1; j < maxY; j++) {
				if (map[minX][j] != 0) {
					result = false;
					break;
				}
			}
		} else if (minY == maxY) {
			for (int i = minX + 1; i < maxX; i++) {
				if (map[i][minY] != 0) {
					result = false;
					break;
				}
			}
		}
		return result;

	}

	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		visited[x][y] = true;
		index[x][y] = k;
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (isAccesible(nx, ny)) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						index[nx][ny] = k;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static boolean isAccesible(int x, int y) {
		if (x < 1 || y < 1 || x > N || y > M || map[x][y] == 0)
			return false;
		else
			return true;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
