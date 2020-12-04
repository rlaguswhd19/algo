package swexpert.D3;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution3456_직사각형의길이찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean[] visit = new boolean[101];

			int[] arr = new int[3];

			for (int i = 0; i < 3; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;

				if (!visit[num]) {
					visit[num] = true;
				} else {
					visit[num] = false;
				}
			}

			int ans = 0;

			for (int i = 0; i < 3; i++) {
				if (visit[arr[i]]) {
					ans = arr[i];
					break;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
