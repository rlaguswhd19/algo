package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution5948_새샘이의735게임 {
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[7];

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			list = new ArrayList<>();

			int ans = 0;
			for (int i = 0; i < 7; i++) {
				for (int j = i + 1; j < 7; j++) {
					for (int k = j + 1; k < 7; k++) {
						ans = arr[i] + arr[j] + arr[k];
						if (!list.contains(ans)) {
							list.add(ans);
						}
					}
				}
			}
			
			Collections.sort(list);
			System.out.println("#" + tc + " " + list.get(list.size() - 5));
		}

	}
}
