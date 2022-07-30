package baekjoon1439;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		StringTokenizer st1 = new StringTokenizer(word, "0");
		StringTokenizer st2 = new StringTokenizer(word, "1");
		
		System.out.println(Math.min(st1.countTokens(), st2.countTokens()));
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
