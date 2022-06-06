package baekjoon4101;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String[] s = br.readLine().split(" ");
			int A = stoi(s[0]);
			int B = stoi(s[1]);
			if (A == 0 && B == 0)
				break;

			if (A > B) {
				sb.append("Yes").append("\n");
			} else {
				sb.append("No").append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
