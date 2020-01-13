package DFS;

import java.util.Scanner;

public class Main1613 {
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		arr = new int[n + 1][n + 1];
		for (int i = 0; i < k; i++) {
			int f = sc.nextInt();
			int b = sc.nextInt();
			arr[f][b] = -1;
			arr[b][f] = 1;
		}

		// 1 > ... > 3
		// 이게 바깥쪽 라인이다. (...)
		for (int a = 1; a <= n; a++) {

			// 이게 안쪽 라인 (1)
			for (int i = 1; i <= n; i++) {

				// 이게 그다음 라인 (3)
				for (int j = 1; j <= n; j++) {
					if (arr[i][a] == 0 || arr[i][a] != arr[a][j]) {
						continue;
					}
					arr[i][j] = arr[i][a];
				}
			}
		}

		int s = sc.nextInt();
		for (int i = 0; i < s; i++) {
			int f = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(arr[f][b]);
		}
	}
}
