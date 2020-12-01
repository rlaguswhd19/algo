package BinerySerch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10815 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			bw.write(binerySerch(arr, num)+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	static int binerySerch(int[] arr, int num) {
		int left = 0;
		int right = arr.length - 1;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			if (arr[mid] > num) {
				right = mid - 1;
			} else if (arr[mid] < num) {
				left = mid + 1;
			} else {
				return 1;
			}
		}

		return 0;
	}
}
