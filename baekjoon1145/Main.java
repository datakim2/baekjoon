package baekjoon1145;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		for (int i = 1; i <= 98 * 99 * 100; i++) {

			int cnt = 0;

			for (int j = 0; j < 5; j++) {
				if (i % Integer.parseInt(s[j]) == 0)
					cnt++;
				
			}

			if (cnt >= 3) {
				System.out.println(i);
				System.exit(0);
			}

		}

	}

}
