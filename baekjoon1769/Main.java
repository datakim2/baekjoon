package baekjoon1769;

import java.io.*;

public class Main {
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num = br.readLine();

		cal(num);
	}

	static String cal(String num) {

		int sum = 0;

		if (num.length() == 1) {
			System.out.println(cnt);
			
			if (Integer.parseInt(num) % 3 == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			System.exit(0);
		}
		
		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - '0';
		}

		num = String.valueOf(sum);
		cnt++;


		return cal(num);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
