package baekjoon1746;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		HashMap<String, String> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < Integer.parseInt(s[0]); i++) {
			String a = br.readLine();
			map.put(a, a);
		}
		Object[] mapkey = map.keySet().toArray();
		Arrays.sort(mapkey);

		for (int i = 0; i < Integer.parseInt(s[1]); i++) {
			String b = br.readLine();
			if(map.get(b)!=null) {
				list.add(b);
		}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(String a : list) {
			sb.append(a).append("\n");
		}
		System.out.println(sb);
		
	}

}
