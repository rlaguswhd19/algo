package baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2309 {
	static int[] arr = new int[9];
	static int[] result = new int[7];
	static boolean stop;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		stop = false;
		com(0, 0);
	}

	static void com(int target, int cnt) {
		if(stop) {
			return;
		}
		
		if (cnt == 7) {
			int sum = 0;

			for (int i = 0; i < result.length; i++) {
				sum += result[i];
			}

			if (sum == 100) {
				Arrays.sort(result);
				
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
				
				stop = true;
			}
			
			return;
		} else if (target == arr.length) {
			return;
		} else {
			result[cnt] = arr[target];

			com(target + 1, cnt + 1);
			com(target + 1, cnt);
		}
	}
}
