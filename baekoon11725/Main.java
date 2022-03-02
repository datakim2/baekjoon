package baekoon11725;

import java.io.*;
import java.util.LinkedList;

public class Main {
	static int v;
	static int[] parents;
	static LinkedList<Integer>[] adjList;

	static class Graph {

		Graph(int v) {
			adjList = new LinkedList[v + 1];
			parents = new int[v + 1];
			for (int i = 1; i <= v; i++) {
				adjList[i] = new LinkedList<>();
			}
		}

		public static void addEdge(int s, int e) {
			adjList[s].add(e);
			adjList[e].add(s);
		}

		public static void dfs(LinkedList<Integer>[] adjList, int parents[], int start, int parent) {

			parents[start] = parent;

			for (int i : adjList[start]) {
				if (i != parent) {
					dfs(adjList, parents, i, start);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		Graph g = new Graph(v);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < v - 1; i++) {
			String[] s = br.readLine().split(" ");
			g.addEdge(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}

		g.dfs(adjList, parents, 1, 0);
		
		for(int i=2; i<=v; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb);
	}

}
