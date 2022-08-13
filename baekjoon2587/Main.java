package baekjoon2587;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[5];
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			arr[i] = stoi(br.readLine());
			sum += arr[i];
		}

		Arrays.sort(arr);

		System.out.println(sum / 5);
		System.out.println(arr[2]);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
