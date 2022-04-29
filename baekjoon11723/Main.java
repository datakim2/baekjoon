package baekjoon11723;

import java.io.*;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		HashSet<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int a = 0;

			if (s.length == 2) {
				a = Integer.parseInt(s[1]);
			}

			switch (s[0]) {
			case "add":
				set.add(a);
				break;
			case "check":
				if (set.contains(a)) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
				break;
			case "remove":
				set.remove(a);
				break;
			case "toggle":
				if (set.contains(a)) {
					set.remove(a);
				} else {
					set.add(a);
				}
				break;
			case "all":
				set = new HashSet<>();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
				break;
			case "empty":
				set = new HashSet<>();
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
