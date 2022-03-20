package baekjoon4792;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

class Edge{
	int s;
	int e;
	char color;

	public Edge(int s, int e, char color) {
		super();
		this.s = s;
		this.e = e;
		this.color = color;
	}
}

public class Main {
	static int V, E, K;
	static ArrayList<Edge> minBlueEdgeList; // blue 간선 최소인
	static ArrayList<Edge> maxBlueEdgeList; // blue 간선 최대인
	static int parent[];

	public static void makeSet() {
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	public static int findSet(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = findSet(parent[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;

		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String[] s = br.readLine().split(" ");

			V = stoi(s[0]); // 정점 개수
			E = stoi(s[1]); // 간선 개수
			K = stoi(s[2]); // K 개수, Blue인 간선이 정확히 k개

			if (V == 0 && E == 0 && K == 0)
				break; // 0 0 0 입력 시 종료

			minBlueEdgeList = new ArrayList<>();
			maxBlueEdgeList = new ArrayList<>();

			for (int i = 0; i < E; i++) {
				String[] s2 = br.readLine().split(" ");

				int sNum = stoi(s2[1]);
				int eNum = stoi(s2[2]);

				if (s2[0].equals("B")) {
					minBlueEdgeList.add(new Edge(sNum, eNum, 'B'));
					minBlueEdgeList.add(new Edge(eNum, sNum, 'B'));
					maxBlueEdgeList.add(new Edge(sNum, eNum, 'B'));
					maxBlueEdgeList.add(new Edge(eNum, sNum, 'B'));
				} else {
					minBlueEdgeList.add(new Edge(sNum, eNum, 'R'));
					minBlueEdgeList.add(new Edge(eNum, sNum, 'R'));
					maxBlueEdgeList.add(new Edge(sNum, eNum, 'R'));
					maxBlueEdgeList.add(new Edge(eNum, sNum, 'R'));
				}
			}

			Collections.sort(minBlueEdgeList, (o1, o2)->o2.color-o1.color); // 빨간 간선 우선 정렬
			makeSet();
			int res = 0, cnt = 0;
			for (Edge e : minBlueEdgeList) {
				if (union(e.s, e.e)) {
					if(e.color=='B') res++;
					if (++cnt == V - 1)
						break;
				}
			}
	
			Collections.sort(maxBlueEdgeList, (o1, o2)->o1.color-o2.color); // 파란 간선 우선 정렬
			makeSet();
			int res2 = 0, cnt2 = 0;
			for (Edge e : maxBlueEdgeList) {
				if (union(e.s, e.e)) {
					if(e.color=='B') res2++;
					if (++cnt2 == V - 1)
						break;
				}
			}
			
			if(K>=res && K<=res2) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
