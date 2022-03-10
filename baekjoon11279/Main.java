package baekjoon11279;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a==0) {
				if(!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
			else {
			pq.add(a);
			}
		}
		System.out.println(sb);
		
	}

}
