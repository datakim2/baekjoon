package baekjoon10162;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = stoi(br.readLine());

		int[] arr = new int[3];
		
		if(N%10!=0) {
			System.out.println(-1);
			System.exit(0);
		}

		while (true) {
			if (300 <= N) {
				N -= 300;
				arr[0]++;
			} else if (60 <= N) {
				N -= 60;
				arr[1]++;
			} else if (10 <= N) {
				N -= 10;
				arr[2]++;
			}
			if (N == 0)
				break;
		}

		for (int a : arr) {
			System.out.print(a + " ");
		}

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
