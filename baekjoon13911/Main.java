package baekjoon13911;

import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int end;
	long weight;

	public Node(int end, long weight) {
		super();
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		if (this.weight == o.weight)
			return 0;
		else if (this.weight > o.weight)
			return 1;
		else
			return -1;
	}
}

class Point implements Comparable<Point> {
	int kind;
	int x;
	long y;

	public Point(int kind, int x, long y) {
		this.kind = kind;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		return this.x - o.x;
	}
}

public class Main {
	static int V, E;
	static long[] dist;
	static ArrayList<Integer> smNum1 = new ArrayList<>();
	static ArrayList<Integer> smNum2 = new ArrayList<>();
	static ArrayList<Point> list = new ArrayList<>();
	static LinkedList<Node>[] Graph;
	final static Long INF = 30000000000L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		V = Integer.parseInt(s[0]);
		E = Integer.parseInt(s[1]);

		Graph = new LinkedList[V + 1];
		dist = new long[V + 1];

		for (int i = 1; i <= V; i++) {
			Graph[i] = new LinkedList<>();
		}

		for (int i = 1; i <= E; i++) {
			String[] s2 = br.readLine().split(" ");
			int sNum = Integer.parseInt(s2[0]);
			int eNum = Integer.parseInt(s2[1]);
			int wNum = Integer.parseInt(s2[2]);
			Graph[sNum].add(new Node(eNum, wNum));
			Graph[eNum].add(new Node(sNum, wNum));
		}

		String[] s3 = br.readLine().split(" ");
		int t1 = Integer.parseInt(s3[0]); // 스타벅스 개수
		int m1 = Integer.parseInt(s3[1]); // 스타벅스 제한거리

		String[] s5 = br.readLine().split(" ");
		for (int i = 0; i < t1; i++) {
			smNum1.add(Integer.parseInt(s5[i]));
		}

		String[] s4 = br.readLine().split(" ");
		int t2 = Integer.parseInt(s4[0]); // 맥도날드 개수
		int m2 = Integer.parseInt(s4[1]); // 맥도날드 제한거리

		String[] s6 = br.readLine().split(" ");
		for (int i = 0; i < t2; i++) {
			smNum2.add(Integer.parseInt(s6[i]));
		}

		for (int i = 0; i < smNum1.size(); i++) {
			bfs(smNum1.get(i));
			for (int j = 1; j <= V; j++) {
				if (dist[j] <= m1 && dist[j] != 0) {
					list.add(new Point(0, j, dist[j]));
				}
			}
		}

		for (int i = 0; i < smNum2.size(); i++) {
			bfs(smNum2.get(i));
			for (int j = 1; j <= V; j++) {
				if (dist[j] <= m2 && dist[j] != 0) {
					list.add(new Point(1, j, dist[j]));
				}
			}
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			for(int j=1; j<=V; j++) {
			if(list.get(i).x==j) {
			}
			System.out.printf("%d %d %d\n", list.get(i).kind, list.get(i).x, list.get(i).y);
		}
		}

	}

	public static void bfs(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;

			if (dist[cur] < curNode.weight)
				continue;

			if (visited[cur])
				continue;

			visited[cur] = true;

			for (Node n : Graph[cur]) {
				if (dist[n.end] > dist[cur] + n.weight) {
					dist[n.end] = dist[cur] + n.weight;
					pq.add(new Node(n.end, dist[n.end]));
				}
			}
		}
	}

}
