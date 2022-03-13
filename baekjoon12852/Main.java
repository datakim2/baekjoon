package baekjoon12852;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
		return this.weight - o.weight;
	}
}

public class Main {
	static int V;
	static ArrayList<Node>[] Graph;
	static int dist[], path[];
	final static int INF = 1000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());

		Graph = new ArrayList[V + 1];
		dist = new int[V + 1];
		path = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= V; i++) {
			if (V % 3 == 0) {
				Graph[i].add(new Node(i / 3, 1));
			}
			if (V % 2 == 0) {
				Graph[i].add(new Node(i / 2, 1));
			}

			Graph[i].add(new Node(i - 1, 1));
		}

		System.out.println(bfs(V));
		
		HashSet<Integer> set = new HashSet<>();
		
		int end = V;
		while(true) {
			set.add(end);
			end = path[end];
			if(end==0) break;
		}
		for(int a : set) {
			System.out.print(a+" ");
		}
	}

	public static int bfs(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean[] visited = new boolean[V + 1];

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;

			if (dist[cur] < curNode.weight)
				continue;

			if (cur == 1)
				break;

			if (visited[cur])
				continue;

			visited[cur] = true;

			for (Node next : Graph[cur]) {
				if (dist[next.end] > dist[cur] + next.weight) {
					dist[next.end] = dist[cur] + next.weight;
					pq.add(new Node(next.end, dist[next.end]));
					path[cur] = next.end;
				}
			}
		}
		
		return dist[1];
	}

}
