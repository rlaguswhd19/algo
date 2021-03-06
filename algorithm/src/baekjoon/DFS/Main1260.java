package baekjoon.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1260 {
	static int[][] arr;
	static ArrayList<Integer> result;
	static boolean[] visit;
	static int n, m, v;
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		arr = new int[n + 1][n + 1];

		for (int index = 0; index < m; index++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			arr[i][j] = 1;
			arr[j][i] = 1;
		}
		visit = new boolean[n + 1];
		result = new ArrayList<>();
		DFS(v);
		for (int i = 0; i < result.size(); i++) {
			if(i == result.size()-1) {
				System.out.print(result.get(i));
			}else {
				System.out.print(result.get(i)+" ");
			}
		}System.out.println();
		
		visit = new boolean[n + 1];
		result = new ArrayList<>();
		q = new LinkedList<>();
		
		//시작점
		q.add(v);
		int size = q.size();
		result.add(v);
		visit[v] = true;
		
		BFS(size);
		for (int i = 0; i < result.size(); i++) {
			if(i == result.size()-1) {
				System.out.print(result.get(i));
			}else {
				System.out.print(result.get(i)+" ");
			}
		}System.out.println();
	}

	static void DFS(int v) {
		result.add(v);
		visit[v] = true;
		for (int i = 1; i < arr.length; i++) {
			if (!visit[i] && arr[v][i] == 1) {
				DFS(i);
			}
		}
	}

	static void BFS(int size) {
		if(q.isEmpty()) {
			return;
		}
		for (int i = 0; i < size; i++) {
			int num = q.poll();
			visit[num] = true;
			for (int j = 1; j < arr.length; j++) {
				if (!visit[j] && arr[num][j] == 1) {
					result.add(j);
					visit[j] = true;
					q.add(j);
				}
			}
		}
		BFS(q.size());
	}
}
