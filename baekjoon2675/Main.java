package baekjoon2675;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");

			int A = Integer.parseInt(s[0]);
			String B = s[1];

			for (int j = 0; j < B.length(); j++) {

				for (int k = 0; k < A; k++)
					sb.append(B.charAt(j));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
