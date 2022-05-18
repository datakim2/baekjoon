package baekjoon15964;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);

		System.out.println((A + B) * (A - B));

	}

}
