package baekjoon1292;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int[] arr = new int[1001];

		int sidx = stoi(s[0]);
		int eidx = stoi(s[1]);

		int k = 1;
		int t = 0;
		for (int i = 1; i <= 1000; i++) {
			arr[i] = k;
			t++;
			if (k == t) {
				k++;
				t = 0;
			}
		}

		int sum = 0;
		for (int i = sidx; i <= eidx; i++) {
			sum += arr[i];
		}

		System.out.println(sum);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
