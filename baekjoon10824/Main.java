package baekjoon10824;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		System.out.println(stoi(s[0] + s[1]) + stoi(s[2] + s[3]));
	}

	static long stoi(String s) {
		return Long.parseLong(s);
	}

}
