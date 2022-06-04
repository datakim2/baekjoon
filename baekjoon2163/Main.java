package baekjoon2163;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = stoi(s[0]);
		int M = stoi(s[1]);
		System.out.println(N * M - 1);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
