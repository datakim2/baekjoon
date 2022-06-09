package baekjoon9506;

import java.io.*;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = stoi(br.readLine());

			if (N == -1) {
				break;
			}

			list = new ArrayList<>();

			if (check(N)) {
				sb.append(N + " = ");
				for (int i = 0; i < list.size(); i++) {
					sb.append(list.get(i));
					if (i != list.size() - 1) {
						sb.append(" + ");
					} else if (i == list.size() - 1) {
//						sb.append("\n");
					}
				}
			} else {
				sb.append(N + " is Not perfect.").append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	static boolean check(int N) {
		int sum = 0;
		for (int i = 1; i < N; i++) {
			if (N % i == 0) {
				list.add(i);
				sum += i;
			}
		}
		if (sum == N) {
			return true;
		} else
			return false;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
