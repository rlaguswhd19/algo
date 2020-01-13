package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753 {
	static int v, e, k;
	static PriorityQueue<Node> pq;
	static ArrayList<Node>[] arr;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
		}
		k = Integer.parseInt(br.readLine());
		distance = new int[v + 1];
		arr = new ArrayList[v + 1];

		for (int i = 1; i < v + 1; i++) {
			if(i == k) {
				distance[i] = 0;
			}else {
				distance[i] = Integer.MAX_VALUE;
			}
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				arr[u].add(new Node(v, w));
			}
		}

		dijkstra();
		for (int i = 1; i < distance.length; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}

	static void dijkstra() {
		pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node n1, Node n2) {
				if (n1.value < n2.value) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new Node(k, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if(distance[node.num] < node.value) {
				continue;
			}
			ArrayList<Node> list = arr[node.num];
			for (int i = 0; i < list.size(); i++) {
				Node temp = list.get(i);
				if(distance[temp.num] > distance[node.num] + temp.value) {
					distance[temp.num] = distance[node.num] + temp.value;
					pq.add(new Node(temp.num, distance[temp.num]));
				}
			}
		}
	}

	static class Node {
		int num;
		int value;

		public Node(int num, int value) {
			super();
			this.num = num;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", value=" + value + "]";
		}

	}
}
