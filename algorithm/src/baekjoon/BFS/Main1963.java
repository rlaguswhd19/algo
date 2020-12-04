package baekjoon.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1963 {
	static boolean[] visit;
	static boolean[] temp;
	static Queue<Integer> q;
	static int[] arr;
	static int a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		visit = new boolean[10000];

		decimal();
		
		for (int tc = 0; tc < t; tc++) {
			a = sc.nextInt();
			b = sc.nextInt();
			temp = visit.clone();
			
			dfs();
			
		}
	}

	static void dfs() {
		q = new LinkedList<>();

		q.add(a);
		temp[a] = true;
		arr = new int[4];
		
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int num = q.poll();
				if(num == b) {
					System.out.println(count);
					return;
				}
				String s = ""+num;
				
				for (int j = 0; j < 4; j++) {
					arr[j] = s.charAt(j)-'0';
				}
				
				for (int j = 0; j < 4; j++) {
					int number = arr[j];
					
					for (int j2 = 0; j2 < 10; j2++) {
						arr[j] = j2;
						
						s = "";
						for (int k = 0; k < 4; k++) {
							s += arr[k];
						}
						
						int change = Integer.parseInt(s);
						
						if(change < 1000) {
							continue;
						}
						
						if(!temp[change]) {
							temp[change] = true;
							q.add(change);
						}
					}
					
					arr[j] = number;
				}
			}
			count++;
		}
	}

	static void decimal() {
		visit[0] = true;
		visit[1] = true;

		for (int i = 2; i < 10000; i++) {
			if (visit[i]) {
				continue;
			}

			visit[i] = false;

			for (int j = i * i; j < 10000; j += i) {
				visit[j] = true;
			}
		}
	}
}
