package baekjoon2566;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = -1;
		int x = -1;
		int y = -1;
		for (int i = 1; i <= 9; i++) {

			String[] s = br.readLine().split(" ");

			for (int j = 1; j <= 9; j++) {
				if (max < stoi(s[j - 1])) {
					max = stoi(s[j - 1]);
					x = i;
					y = j;
				}
			}
		}
		System.out.println(max);
		System.out.println(x + " " + y);

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
