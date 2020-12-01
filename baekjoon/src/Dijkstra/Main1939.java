package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1939 {
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		distance = new int[n+1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node n1, Node n2) {
				return n2.val - n1.val;
			}
		});

		int a, b, c;
		ArrayList<Node> temp;
		HashMap<Integer, ArrayList<Node>> map = new HashMap<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (map.containsKey(a)) {
				temp = map.get(a);
			} else {
				temp = new ArrayList<>();
			}

			temp.add(new Node(b, c));
			map.put(a, temp);

			if (map.containsKey(b)) {
				temp = map.get(b);
			} else {
				temp = new ArrayList<>();
			}

			temp.add(new Node(a, c));
			map.put(b, temp);
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int now = 0;
		distance[s] = Integer.MAX_VALUE;
		pq.add(new Node(s, Integer.MAX_VALUE));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			now = node.d;
			
			if(distance[now] > node.val) {
				continue;
			}
			
			temp = map.get(now);
			for (int i = 0; i < temp.size(); i++) {
				Node next = temp.get(i);
				
				int min = Math.min(node.val, next.val);
				
				if(distance[next.d] >= min) {
					continue;
				}
				
				distance[next.d] = min;
				pq.add(new Node(next.d, min));
			}
		}
		
		System.out.println(distance[e]);
	}

	static class Node {
		int d, val;

		public Node(int d, int val) {
			super();
			this.d = d;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Node [d=" + d + ", val=" + val + "]";
		}
	}
}
