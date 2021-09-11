package test.T2021_2.kakao;

import java.util.ArrayList;

public class Solution5 {
	static Node[] arr;
	static int ans, sum;
	public static void main(String[] args) {
		int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		solution(info, edges);
	}
	
	static int solution(int[] info, int[][] edges) {
		ans = 0;
		sum = 0;
		arr = new Node[info.length];
		for (int i = 0; i < info.length; i++) {
			int ani = info[i];
			if(ani == 0) {
				sum++;
			}
			
			arr[i] = new Node(i, ani, new ArrayList<>());
		}
		
		for (int i = 0; i < edges.length; i++) {
			int now = edges[i][0];
			int next = edges[i][1];
			
			Node n = arr[now];
			n.next.add(next);
			arr[now] = n;
		}
		
		dfs(0, 0, 0, new boolean[info.length], 0);
		
		System.out.println(ans);
		return ans;
	}
	
	static void dfs(int now, int s, int w, boolean[] visit, int help) {
		System.out.println(now);
		Node n = arr[now];
		if(!visit[now]) {
			if(n.animal == 0) {
				s++;
				help++;
			}else {
				w++;
				if(w == s) {
					return;
				}
			}
			
			visit[now] = true;
		}
		
		ArrayList<Integer> next = n.next;
		if(next.size() == 0) {
			if(help == 0) { // 구한 양이 없을 경우
				ans = Math.max(ans, s);
				return;
			}
			
			if(sum == s) { // 다 구했을 경우
				ans = Math.max(ans, s);
				return;
			}
			
			// 처음 노드로 돌아가서 다시 dfs
			dfs(0, s, w, visit, 0);
		}else {
			for (int i = 0; i < next.size(); i++) {
				int next_idx = next.get(i);
				
				dfs(next_idx, s, w, visit, help);
			}
		}
	}
	
	static class Node { 
		int now;
		int animal;
		ArrayList<Integer> next;
		
		public Node(int now, int animal, ArrayList<Integer> next) {
			super();
			this.now = now;
			this.animal = animal;
			this.next = next;
		}
	}
}
