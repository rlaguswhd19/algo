package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916_2 {
	static int n, m, s, e;
	static ArrayList<Node>[] list;
	static int[] distance;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		distance = new int[n + 1];
		list = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			list[now].add(new Node(next, val));
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		dijkstra();

		System.out.println(distance[e]);
	}

	static void dijkstra() {
		pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node n1, Node n2) {
				if (n1.val < n2.val) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new Node(s, 0));
		distance[s] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (now.val > distance[now.num]) {
				continue;
			}

			ArrayList<Node> temp = list[now.num];

			for (int i = 0; i < temp.size(); i++) {
				Node next = temp.get(i);

				if (distance[next.num] > distance[now.num] + next.val) {
					distance[next.num] = distance[now.num] + next.val;
					pq.add(new Node(next.num, distance[next.num]));
				}
			}
		}
	}

	static class Node {
		int num, val;

		public Node(int num, int val) {
			super();
			this.num = num;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", val=" + val + "]";
		}
	}
}
