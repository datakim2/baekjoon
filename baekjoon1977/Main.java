package baekjoon1977;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = stoi(br.readLine());
		int B = stoi(br.readLine());

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = A; i <= B; i++) {

			if (check(i)) {
				min = Math.min(min, i);
				sum += i;
			}
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {

			System.out.println(sum);
			System.out.println(min);
		}
	}

	static boolean check(int num) {
		int x = (int) Math.sqrt((double) num);
		if (x * x == num) {
			return true;
		} else
			return false;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
