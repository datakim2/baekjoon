package baekjoon10991;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = stoi(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			for(int j=N-1; j>i; j--)
			System.out.print(" ");
			
			for(int k=0; k<=i; k++)
			System.out.print("* ");
			
			System.out.println();
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
