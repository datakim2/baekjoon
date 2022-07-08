package baekjoon14489;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int A = stoi(s[0]);
		int B = stoi(s[1]);
		int C = stoi(br.readLine());

		if (A + B < 2*C) {
			System.out.println(A + B);
		} else {
			System.out.println(A + B - C * 2);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
