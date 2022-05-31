package baekjoon1684;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = stoi(br.readLine());
		
		String[] s = br.readLine().split(" ");
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = stoi(s[i]);
		}
		
		for(int i=1; i<N; i++) {
			arr[i-1] = arr[i] - arr[i-1];
		}
		int r = arr[0];
		
		for(int i=1; i<N-1; i++) {
			r = gcd(r, arr[i]);
		}
		
		System.out.println(r);
		
	}
	
	static int gcd(int r1, int r2) {
		
		while(true) {
			if(r1>r2) {
				int temp = r1;
				r1 = r2;
				r2 = temp;
			}
			if(r1==0) return r2;
			if(r2%r1==0) return r1;
			else r2=r2%r1;
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
