package baekjoon15873;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int ans = 0;
		if (s.length() == 2) {
			ans = s.charAt(0) - '0' + s.charAt(1) - '0';
		} else if (s.length() == 3) {
			if (s.substring(0, 2).equals("10")) {
				ans = 10 + s.charAt(2) - '0';
			} else {
				ans = s.charAt(0) - '0' + 10;
			}
		} else {
			ans = 20;
		}
		System.out.println(ans);

	}

}
