package baekjoon16953;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Cal {
	long x;
	int cnt;

	public Cal(long x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}
}

public class Main {
	static long A, B, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		A = stoi(s[0]);
		B = stoi(s[1]);

		min = Long.MAX_VALUE;

		BFS();

		if (min == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static void BFS() {
		Queue<Cal> q = new LinkedList<>();
		q.add(new Cal(A, 1));
		while (!q.isEmpty()) {
			Cal c = q.poll();

			if (c.x == B) {
				min = Math.min(min, c.cnt);
			}

			long curNum = c.x * 2;// 2를 곱하는 경우
			if (curNum >= 0 && curNum <= 1000000000) {
				q.add(new Cal(curNum, c.cnt + 1));
			}

			String curNum2 = String.valueOf(c.x) + "1";
			if (Long.parseLong(curNum2) >= 0 && Long.parseLong(curNum2) <= 1000000000) {
				curNum = Long.parseLong(curNum2);

				q.add(new Cal(curNum, c.cnt + 1));
			}
		}
	}

	static long stoi(String s) {
		return Long.parseLong(s);
	}

}
