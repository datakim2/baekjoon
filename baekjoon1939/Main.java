package baekjoon1939;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int end;
	int weight;

	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return o.weight - this.weight;
	}
}

public class Main {
	static int V, E, end;
	static int[] dist;
	static ArrayList<Node>[] Graph;
	final static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		V = stoi(s[0]);
		E = stoi(s[1]);
		Graph = new ArrayList[V + 1];
		dist = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			String[] s2 = br.readLine().split(" ");
			int sNum = stoi(s2[0]);
			int eNum = stoi(s2[1]);
			int wNum = stoi(s2[2]);
			Graph[sNum].add(new Node(eNum, wNum));
			Graph[eNum].add(new Node(sNum, wNum));
		}
		String[] s3 = br.readLine().split(" ");
		int start = stoi(s3[0]);
		end = stoi(s3[1]);

		System.out.println(bfs(start));
	}

	public static int bfs(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dist, -1);
		dist[start] = INF;
		pq.add(new Node(start, INF));
		boolean[] visited = new boolean[V+1];

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;

			if (dist[cur] < curNode.weight)
				continue;
			
			if(cur==end) break;
			
			if(visited[cur]) continue;
			
			visited[cur] = true;

			for (Node next : Graph[cur]) {
				int weight = Math.min(curNode.weight, next.weight);
				if (dist[next.end] < weight) {
					dist[next.end] = weight;
					pq.add(new Node(next.end, weight));
				}
			}
		}

		return dist[end];
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
