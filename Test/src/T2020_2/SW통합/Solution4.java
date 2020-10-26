package T2020_2.SW통합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 764;
		System.out.println(countperms(n));
	}

	static int countperms(int n) {
		int[] arr = new int[5];
		Arrays.fill(arr, 1);
		// a e i o u
		int cnt = 1;
		while(cnt < n) {
			int[] temp = new int[5];
			temp[1] += arr[0];
			temp[1] %= 1000000007;
			
			temp[0] += arr[1];
			temp[0] %= 1000000007;
			temp[2] += arr[1];
			temp[2] %= 1000000007;
			
			temp[0] += arr[2];
			temp[0] %= 1000000007;
			temp[1] += arr[2];
			temp[1] %= 1000000007;
			temp[3] += arr[2];
			temp[3] %= 1000000007;
			temp[4] += arr[2];
			temp[4] %= 1000000007;
			
			temp[2] += arr[3];
			temp[2] %= 1000000007;
			temp[4] += arr[3];
			temp[4] %= 1000000007;
			
			temp[0] += arr[4];
			temp[0] %= 1000000007;
			
			for (int i = 0; i < 5; i++) {
				arr[i] = temp[i];
			}
			
			cnt++;
		}
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			sum %= 1000000007;
		}
		
		return sum;
	}
}
