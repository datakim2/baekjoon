package baekjoon10953;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(",");
			System.out.println(Integer.parseInt(s[0])+Integer.parseInt(s[1]));
		}
	}

}
