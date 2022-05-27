package bakejoon1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int v = Integer.parseInt(s[1]);
		int start = Integer.parseInt(s[2]);
		ArrayList<ArrayList> Graph = new ArrayList<ArrayList>();
		for(int i=0; i<v; i++) {
			String[] s2 = br.readLine().split(" ");
			Graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s2[1]));
		}
		System.out.println(Graph.size());
		for(int i=0; i<Graph.size(); i++) {
			Graph.get(start).get(i);
			
		}
		
		/*public void bfs(int k) {
			
		}*/
	}

}
