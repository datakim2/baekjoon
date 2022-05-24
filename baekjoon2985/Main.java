package baekjoon2985;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int A = stoi(s[0]);
		int B = stoi(s[1]);
		int C = stoi(s[2]);

		if (A + B == C)
			System.out.println(A + "+" + B + "=" + C);
		else if (A - B == C)
			System.out.println(A + "-" + B + "=" + C);
		else if (A * B == C)
			System.out.println(A + "*" + B + "=" + C);
		else if (A / B == C)
			System.out.println(A + "/" + B + "=" + C);
		else if (A == B + C)
			System.out.println(A + "=" + B + "+" + C);
		else if (A == B - C)
			System.out.println(A + "=" + B + "-" + C);
		else if (A == B * C)
			System.out.println(A + "=" + B + "*" + C);
		else if (A == B / C)
			System.out.println(A + "=" + B + "/" + C);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
