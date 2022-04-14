package baekjoon1629;

import java.io.*;

public class Main {
	static long mod;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		long A = stoi(s[0]);
		long B = stoi(s[1]);
		mod = stoi(s[2]);

		System.out.println(cal(A, B));

	}

	public static long cal(long base, long index) {

		long r = 1;
		while (index != 0) {
			if ((index & 1) == 1) {
				r = r * base % mod;
			}
			index >>= 1;
			base = base * base % mod;
		}
		return r;
	}

	public static long stoi(String s) {
		return Long.parseLong(s);
	}

}
