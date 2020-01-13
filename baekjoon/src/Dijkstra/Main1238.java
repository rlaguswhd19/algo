package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1238 {
	static int n, m, x;
	static int[][] distance;
	static ArrayList<Node>[] arr;
	static PriorityQueue<Node> pq;
	static int ans = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
		}
		arr = new ArrayList[n+1];
		
		for (int i = 1; i < n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		distance = new int[n+1][n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				arr[u].add(new Node(v, w));
			}
		}
		for (int j = 1; j < n+1; j++) {
			for (int i = 1; i < n+1; i++) {
				if(i == j) {
					distance[j][i] = 0;
				}else {
					distance[j][i] = Integer.MAX_VALUE;
				}
			}
			dijkstra(j);
		}
		
		for (int i = 1; i < distance[x].length; i++) {
			if(i == x) {
				continue;
			}
			ans = Math.max(ans , distance[i][x]+distance[x][i]);
		}
		System.out.println(ans);
	}
	static void dijkstra(int start) {
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
			
			if(distance[start][node.num] < node.value) {
				continue;
			}
			ArrayList<Node> list = arr[node.num];
			for (int i = 0; i < list.size(); i++) {
				Node temp = list.get(i);
				if(distance[start][temp.num] > distance[start][node.num] + temp.value) {
					distance[start][temp.num] = distance[start][node.num] + temp.value;
					pq.add(new Node(temp.num, distance[start][temp.num]));
				}
			}
		}
	}
	static class Node{
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
