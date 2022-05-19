package baekjoon14225;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static boolean[] used;
	static int[] arr;
	static Set<Integer> set = new HashSet<Integer>();
	static int N, min, sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		
		String[] s = br.readLine().split(" ");
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = stoi(s[i]);
		}
		
		solve(0);
		
		for(int i=0; i<2000000; i++) {
			if(!set.contains(i)) {
				System.out.println(i);
				System.exit(0);
			}
		}
	}
	
	static void solve(int idx) {
		if(idx==N) {
			set.add(sum);
			return;
		}
		
		sum+=arr[idx];
		solve(idx+1);
		sum-=arr[idx];
		
		solve(idx+1);
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
