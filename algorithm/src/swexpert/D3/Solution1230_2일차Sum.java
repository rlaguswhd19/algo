package swexpert.D3;

import java.io.IOException;
import java.util.Scanner;

public class Solution1230_2일차Sum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int ans = 0;

			int[] row = new int[100];
			int[] col = new int[100];
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					int num = sc.nextInt();
					col[j] += num;
					row[i] += num;
					if (i == j) {
						sum1 += num;
					} else if (i + j == 99) {
						sum2 += num;
					}
				}
				
			}

			for (int i = 0; i < 100; i++) {
				ans = Math.max(row[i], ans);
				ans = Math.max(col[i], ans);
			}
			
			ans = Math.max(sum1, ans);
			ans = Math.max(sum2, ans);

			System.out.println("#" + tc + " " + ans);
		}
	}
}
