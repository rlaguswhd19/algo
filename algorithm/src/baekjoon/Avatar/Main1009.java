package baekjoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1009 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int[][] arr = { { 10 }, { 1 }, { 6, 2, 4, 8 }, { 1, 3, 9, 7 }, { 6, 4 }, { 5 }, { 6 }, { 1, 7, 9, 3 },
				{ 6, 8, 4, 2 }, { 1, 9 } };

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int p = arr[a % 10].length;

			System.out.println(arr[a % 10][b % p]);
		}
	}
}
