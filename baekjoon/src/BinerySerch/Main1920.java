package BinerySerch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			System.out.println(binerySerch(arr, num));
		}
	}

	static int binerySerch(int[] arr, int num) {
		int left = 0;
		int right = arr.length - 1;
		int mid = 0;
		int ans = 0;
		
		while (left <= right) {
			mid = (left + right) / 2;

			if (num < arr[mid]) {
				right = mid - 1;
			} else if(num > arr[mid]){
				left = mid + 1;
			}else {
				return 1;
			}
		}

		return ans;
	}
}
