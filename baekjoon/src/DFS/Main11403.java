package DFS;

import java.util.Scanner;

public class Main11403 {
	static int[][] arr;
	static int[][] result;
	static int start;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		arr = new int[N][N];
		result = new int[N][N];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < arr.length; i++) {
			visit = new boolean[N];
			start = i;
			go(i);
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void go(int a) {
		for (int i = 0; i < arr.length; i++) {
			if (!visit[i] && arr[a][i] == 1) {
				result[start][i] = 1;
				visit[i] = true;
				go(i);
			}
		}
	}
}

