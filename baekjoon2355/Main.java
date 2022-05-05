package baekjoon2355;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		if (A <= B)
			System.out.println(((B + A) * (B - A + 1)) / 2);
		else
			System.out.println(((A + B) * (A - B + 1)) / 2);
	}

}
