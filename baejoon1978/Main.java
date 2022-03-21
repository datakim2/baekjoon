package baejoon1978;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		BigInteger[] arr = new BigInteger[N];
		
		String[] s = br.readLine().split(" ");
		int ans = 0;
		for(int i=0; i<N; i++) {
			if(BigInteger.valueOf(Long.parseLong(s[i])).isProbablePrime(3)) ans++;
		}
		
		System.out.println(ans);
		
	}

}
