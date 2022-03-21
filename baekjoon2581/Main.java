package baekjoon2581;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int min = 10000;
		for(int i=M; i<=N; i++) {
			if(BigInteger.valueOf(i).isProbablePrime(3)) {
				sum+=i;
				min = Math.min(min, i);
			}
		}
		
		if(sum==0) {
			sb.append(-1).append("\n");
		}
		else {
			sb.append(sum).append("\n");
			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

}
