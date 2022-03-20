package baekjoon1966;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class document {
	int idx;
	int imp;

	public document(int idx, int imp) {
		this.idx = idx;
		this.imp = imp;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");

			int n = stoi(s[0]); // 큐 개수
			int findIdx = stoi(s[1]); // 찾고자 하는 문서 인덱스

			Queue<document> q = new LinkedList<>();

			String[] s2 = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				q.add(new document(i, stoi(s2[i])));
			}


			int ans = 1;

			while (!q.isEmpty()) {

				document first = q.poll();
				boolean check = true;

				Iterator iter = q.iterator();
				while (iter.hasNext()) {
					document next = (document) iter.next();
					if (first.imp < next.imp) {
						check = false;
						break;
					}
				}

				if (!check) {
					q.add(first);
				}

				else {
					if (findIdx == first.idx) {
						sb.append(ans).append("\n");
					} else
						ans++;
				}
			}
		}
		System.out.println(sb.toString());
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
