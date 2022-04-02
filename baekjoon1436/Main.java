package baekjoon1436;

import java.io.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> desNum = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<=100000000; i++) {
			if(String.valueOf(i).contains("666")) {
			desNum.add(i);
			if(desNum.size()==n) {
				System.out.println(i);
				break;
			}
			}
		}
	}

}
