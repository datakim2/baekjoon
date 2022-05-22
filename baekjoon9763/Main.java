package baekjoon9763;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

class Point {
	int x;
	int y;
	int z;

	public Point(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = stoi(br.readLine());

		Point p[] = new Point[10001];

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
			p[i] = new Point(stoi(s[0]), stoi(s[1]), stoi(s[2]));
		}

		int ans = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {

			int min1 = Integer.MAX_VALUE;
			int min2 = Integer.MAX_VALUE;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;

				int d = Math.abs(p[i].x - p[j].x) + Math.abs(p[i].y - p[j].y) + Math.abs(p[i].z - p[j].z);

				if (min1 > d) {
					min2 = min1;
					min1 = d;
				} else if (min2 > d) {
					min2 = d;
				}
			}
			ans = Math.min(ans, min1 + min2);
		}
		System.out.println(ans);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
