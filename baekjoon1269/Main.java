package baekjoon1269;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int N = stoi(s[0]);
		int M = stoi(s[1]);
		HashMap<Integer, Integer> map = new HashMap<>();

		String[] s2 = br.readLine().split(" ");
		String[] s3 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int key = stoi(s2[i]);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		for (int i = 0; i < M; i++) {
			int key = stoi(s3[i]);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int cnt = 0;
		
		 Iterator<Integer> keys = map.keySet().iterator();
	        while( keys.hasNext() ){
	            int key = keys.next();
	            if(map.get(key)==1) cnt++;
	        }

		System.out.println(cnt);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
