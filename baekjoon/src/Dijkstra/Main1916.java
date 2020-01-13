package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916 {
	static int[] cost;
	static ArrayList<Node>[] arr;
	static int start, end;
	static PriorityQueue<Node> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		cost = new int[n+1];
		arr = new ArrayList[n+1];
		
		StringTokenizer st;
		for (int i = 0; i < n+1; i++) {
			cost[i] = Integer.MAX_VALUE;
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				arr[u].add(new Node(v, w));
			}
		}
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
		}
		
		cost[start] = 0;
		dijkstra();
		
		System.out.println(cost[end]);
	}
	
	static void dijkstra() {
		pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if(n1.value < n2.value) {
					return -1;
				}else {
					return 1;
				}
			}
		});
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(node.value > cost[node.num]) {
				continue;
			}
			
			ArrayList<Node> list = arr[node.num];
			for (int i = 0; i < list.size(); i++) {
				Node temp = list.get(i);
				if(cost[temp.num] > cost[node.num] + temp.value) {
					cost[temp.num] = cost[node.num] + temp.value;
					pq.add(new Node(temp.num, cost[node.num]+temp.value));
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
