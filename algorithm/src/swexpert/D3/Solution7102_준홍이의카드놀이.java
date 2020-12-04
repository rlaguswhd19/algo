package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7102_준홍이의카드놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int arr[] = new int[n + m + 1];

			int max = 0;
			ArrayList<Integer> list = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					arr[i + j]++;
				}
			}

			for (int i = 0; i < n + m; i++) {
				if (max < arr[i]) {
					max = arr[i];
					list = new ArrayList<>();
					list.add(i);
				}else if(max == arr[i]) {
					list.add(i);
				}
			}
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < list.size(); i++) {
				sb.append(" "+list.get(i));
			}
			System.out.println("#" + tc + sb);
		}
	}
}
