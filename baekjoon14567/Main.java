package baekjoon14567;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		int[] indegree = new int[N + 1];
		int[] ans = new int[N + 1];

		ArrayList<ArrayList<Integer>> subject = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			subject.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			String[] s2 = br.readLine().split(" ");
			int parent = Integer.parseInt(s2[0]);
			int child = Integer.parseInt(s2[1]);
			subject.get(parent).add(child);
			indegree[child]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		Arrays.fill(ans, 1);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : subject.get(cur)) {
				if (--indegree[next] == 0) {
					q.add(next);
					ans[next] = ans[cur] + 1;
				}
			}
		}
		for(int i=1; i<=N; i++)
		sb.append(ans[i]+" ");
		System.out.println(sb);
	}

}
