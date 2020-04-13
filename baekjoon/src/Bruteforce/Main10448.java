package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10448 {
	static int[] arr;
	static int[] check;
	static int[] list = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		arr = new int[45];
		check = new int[1001];

		for (int i = 1; i <= 44; i++) {
			arr[i] = i * (i + 1) / 2;
		}

		check(0);
		
		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(check[num]);
		}
	}

	static void check(int cnt) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < list.length; i++) {
				sum += arr[list[i]];
			}
			if(sum <= 1000) {
				check[sum] = 1;
			}
			return;
		}
		for (int i = 1; i < 45; i++) {
			list[cnt] = i;
			check(cnt + 1);
		}
	}
}
