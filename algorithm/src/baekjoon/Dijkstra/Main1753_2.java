package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753_2 {
	static int v, e, k;
	static ArrayList<Node>[] list;
	static PriorityQueue<Node> pq;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		distance = new int[v + 1];
		list = new ArrayList[v + 1];
		for (int i = 1; i < v + 1; i++) {
			list[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			list[now].add(new Node(num, val));
		}

		dijkstra();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < v + 1; i++) {
			sb.append((distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]) + "\n");
		}

		System.out.println(sb.toString());
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

		pq.add(new Node(k, 0));
		distance[k] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (distance[now.num] < now.val) {
				continue;
			}

			ArrayList<Node> temp = list[now.num];

			for (int i = 0; i < temp.size(); i++) {
				Node next = temp.get(i);

				if (distance[now.num] + next.val < distance[next.num]) {
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
