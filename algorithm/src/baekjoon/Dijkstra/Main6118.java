package baekjoon.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main6118 {
	static int n, m;
	static ArrayList<Integer>[] arr;
	static int[] distance;
	static Queue<Integer> q;
	static int max = 0;
	static ArrayList<Integer> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = new ArrayList<>();
		}
		distance = new int[n + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a].add(b);
			arr[b].add(a);
		}

		dijkstra();

		ans = new ArrayList<>();
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] == max) {
				ans.add(i);
			}
		}
		Collections.sort(ans);
		
		System.out.println(ans.get(0)+" "+max+" "+ans.size());
	}

	static void dijkstra() {
		q = new LinkedList<>();

		q.add(1);

		while (!q.isEmpty()) {
			int num = q.poll();

			for (int i = 0; i < arr[num].size(); i++) {
				int next = arr[num].get(i);

				if (distance[next] > distance[num] + 1) {
					distance[next] = distance[num] + 1;
					max = Math.max(distance[next], max);
					q.add(next);
				}
			}
		}
	}
}
