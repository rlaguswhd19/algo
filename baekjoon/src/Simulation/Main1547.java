package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1547 {
	static int[] list = { 0, 1, 2, 3 };
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			int num = list[c1];
			list[c1] = list[c2];
			list[c2] = num;
		}

		for (int i = 1; i < 4; i++) {
			if (list[i] == 1) {
				System.out.println(i);
				break;
			}
		}
	}
}
