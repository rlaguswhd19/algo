package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2667 {
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int result;
	static int count;
	static ArrayList<Integer> List;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		arr = new int[n][n];
		visit = new boolean[n][n];
		result = 0;
		List = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j] && arr[i][j] == 1) {
					count = 0;
					DFS(i, j);
					List.add(count);
					result++;
				}
			}
		}
		System.out.println(result);
		Collections.sort(List);
		
		for (int i = 0; i < List.size(); i++) {
			System.out.println(List.get(i));
		}
	}
	
	static void DFS(int i, int j) {
		visit[i][j] = true;
		count++;
		for (int j2 = 0; j2 < 4; j2++) {
			if(i+dx[j2] >= 0 && i+dx[j2] < arr.length && j+dy[j2] >= 0 && j+dy[j2] < arr.length) {
				if(!visit[i+dx[j2]][j+dy[j2]] && arr[i+dx[j2]][j+dy[j2]] == 1) {
					DFS(i+dx[j2],j+dy[j2]);
				}
			}
		}
	}
}
