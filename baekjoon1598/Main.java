package baekjoon1598;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int a = stoi(s[0])-1;
		int b = stoi(s[1])-1;

		System.out.println(Math.abs(a / 4 - b / 4) + Math.abs(a % 4 - b % 4));
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
