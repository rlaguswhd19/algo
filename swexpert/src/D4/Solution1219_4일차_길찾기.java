package D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1219_4일차_길찾기 {
	static int[][] arr;
	static boolean[] visit;
	static int ans;
	static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			arr = new int[2][100];
			visit = new boolean[100];
			q = new LinkedList<>();
			ans = 0;
			
			for (int i = 0; i < n; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				
				if(arr[0][s] == 0) {
					arr[0][s] = e;
				}else {
					arr[1][s] = e;
				}
			}
			
			q.add(0);
			visit[0] = true;
			
			while(!q.isEmpty()) {
				int s = q.poll();
				
				if(s == 99) {
					ans = 1;
				}
				
				for (int i = 0; i < 2; i++) {
					int next = arr[i][s];
					
					if(next == 0) {
						break;
					}
					
					if(visit[next]) {
						continue;
					}
					
					q.add(next);
					visit[next] = true;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		
		
	}
}
