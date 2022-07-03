package baekjoon25238;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int A = stoi(s[0]);
		int B = stoi(s[1]);

		if ((float) A * (1 - (float) B * 0.01) < 100) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
