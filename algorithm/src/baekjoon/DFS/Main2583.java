package baekjoon.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2583 {
	static int[][] arr;
	static boolean[][] visit;
	static int n, m;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int Allcount;
	static int count;
	static ArrayList<Integer> result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new int[n][m];
		visit = new boolean[n][m];
		Allcount = 0;
		result = new ArrayList<>();
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			set(x1,y1,x2,y2);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visit[i][j] && arr[i][j] == 0) {
					Allcount++;
					count = 0;
					DFS(i,j);
					result.add(count);
				}
			}
		}
		Collections.sort(result);
		System.out.println(Allcount);
		for (int i = 0; i < result.size(); i++) {
			if(i == result.size()-1) {
				System.out.print(result.get(i));
			}else {
				System.out.print(result.get(i)+" ");
			}
		}
	}
	static void set(int x1, int y1, int x2, int y2) {
		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				arr[i][j] = 1;
			}
		}
	}
	static void DFS(int i, int j) {
		visit[i][j] = true;
		count++;
		for (int index = 0; index < 4; index++) {
			if(i+dx[index]>=0 && i+dx[index]<n && j+dy[index]>=0 && j+dy[index]<m) {
				if(!visit[i+dx[index]][j+dy[index]] && arr[i+dx[index]][j+dy[index]] == 0) {
					DFS(i+dx[index], j+dy[index]);
				}
			}
		}
	}
}
