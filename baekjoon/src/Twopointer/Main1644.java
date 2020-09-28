package Twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1644 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n + 1];

		for (int i = 2; i < n + 1; i++) {
			if (arr[i] == 0) {
				for (int j = i * 2; j < n + 1; j += i) {
					arr[j] = 1;
				}
			}
		}

		int s = 2;
		int e = 2;
		int sum = 0;
		int ans = 0;

		while (s <= n) {
			if (sum < n) {
				while (e <= n) {
					if (arr[e] == 0) {
						break;
					}

					e++;
				}

				if (e > n) {
					break;
				}

				sum += e++;
			} else {
				while (s <= n) {
					if (arr[s] == 0) {
						break;
					}

					s++;
				}
				
				sum -= s++;
			}

			if (sum == n) {
				ans++;
			}
		}

		System.out.println(ans);
	}
}
