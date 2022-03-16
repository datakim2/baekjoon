package baekjoon2003;

import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		int[] arr = new int[N];

		String[] s2 = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s2[i]);
		}

		int start = 0;
		int end = 0;
		int cnt = 0;
		int sum = arr[start];

		while (true) {
			if(sum==M) cnt++;
			end++;
			if (end == N) {
				start++;
				end = start;
				sum = 0;
			}
			if (start == N)
				break;
			
			sum += arr[end];
			if (sum >= M) {
				if(sum==M) cnt++;
				start++;
				if(start==N) break;
				end = start;
				sum = arr[start];
			}

		}
		System.out.println(cnt);
	}

}
