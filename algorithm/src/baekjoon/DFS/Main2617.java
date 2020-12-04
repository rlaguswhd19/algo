package baekjoon.DFS;

import java.util.Scanner;

public class Main2617 {
	static int[][] arr;
	static int ans = 0;
	static int standard;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		standard = n/2;
		arr = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = -1;
		}
		
		// ...
		for (int a = 1; a < n+1; a++) {
			
			// a
			for (int i = 1; i < n+1; i++) {
				if(arr[i][a] == 0) {
					continue;
				}
				// b
				for (int j = 1; j < n+1; j++) {
					if(arr[i][a] == arr[a][j]) {
						arr[i][j] = arr[i][a];
					}
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			int M = 0;
			int P = 0;
			for (int j = 1; j < n+1; j++) {
				if(arr[i][j] == -1) {
					M++;
				}else if(arr[i][j] == 1){
					P++;
				}
			}
			if(M > standard || P > standard) {
				ans++;
			}
		}
		
		System.out.println(ans);
//		for (int i = 1; i < n+1; i++) {
//			for (int j = 1; j < n+1; j++) {
//				System.out.print(arr[i][j]+" ");
//			}System.out.println();
//		}
	}
}
