package baekjoon2696;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	static String[] s = null;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = stoi(br.readLine());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

			sb.append(((N + 1) / 2) + "\n");
			int cnt = 0;

			for (int i = 0; i < N; i++) {

				if (i % 10 == 0) {
					s = br.readLine().split(" ");
				}

				int x = stoi(s[i % 10]);

				if (minHeap.size() == maxHeap.size()) {
					maxHeap.add(x);
				} else {
					minHeap.add(x);
				}

				if (!minHeap.isEmpty()) {
					if (maxHeap.peek() > minHeap.peek()) {
						int x1 = maxHeap.poll();
						int x2 = minHeap.poll();

						maxHeap.add(x2);
						minHeap.add(x1);
					}
				}

				if (i % 2 == 0) {
					if (cnt == 9 || i == N - 1) {
						sb.append(maxHeap.peek() + "\n");
						cnt = 0;
					} else {
						sb.append(maxHeap.peek() + " ");
					}
					cnt++;
				}
			}
		}

		System.out.println(sb.toString());

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
