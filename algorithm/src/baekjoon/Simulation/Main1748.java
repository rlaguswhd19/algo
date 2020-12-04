package baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1748 {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int sum = 0;

		int index = Integer.toString(n).length();

		int mok = (int) Math.pow(10, index - 1);
		int nmg = n - mok;

		sum += (nmg + 1) * index;

		n = n - (nmg + 1);
		index--;
		
		while (index > 0) {
			int num = (int) Math.pow(10, index - 1);
			sum += (n - num + 1) * index;

			n = num - 1;

			index--;
		}

		System.out.println(sum);

	}
}
