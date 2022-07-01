package baekjoon2745;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		System.out.println(Long.parseLong(s[0], stoi(s[1])));
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
