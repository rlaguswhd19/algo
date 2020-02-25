package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1939 {
	static int n, m, start, end;
	static ArrayList<Node>[] map;
	static boolean[] visit;
	static Queue<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			map[i] = new ArrayList<>();
		}
		visit = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			map[a].add(new Node(b, cost));
			map[b].add(new Node(a, cost));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		bfs();
		System.out.println(visit[end]);
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(new Node(start, Integer.MAX_VALUE));
		visit[start] = true;

		while (!q.isEmpty()) {
			Node N = q.poll();

			int next = N.next;
			int cost = N.cost;
			
			if(next == end) {
				return;
			}
			
			for (int i = 1; i < map[next].size(); i++) {
				Node N2 = map[next].get(i);
				
				int next2 = N2.next;
				int cost2 = N2.cost;
				
			}
		}
	}

	static class Node {
		int next;
		int cost;

		public Node(int next, int cost) {
			super();
			this.next = next;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [next=" + next + ", cost=" + cost + "]";
		}
	}
}
