package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution5293_이진문자열복원 {
	static int[] arr = new int[4]; // 00 01 10 11
	// 00 -> 0, 1 (0
	// 01 -> 2, 3 (1
	// 10 -> 0, 1 (2
	// 11 -> 2, 3 (3
	static int[] list;
	static boolean isOk;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			int idx = 0;
			int sum = 0;
			isOk = false;

			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				sum += num;
				arr[idx++] = num;
			}

			list = new int[sum];
			Arrays.fill(list, -1);

			for (int i = 0; i < 4; i++) {
				if (arr[i] != 0) {
					per(0, i);
				}

				if (isOk) {
					break;
				}
			}

			System.out.println("#" + tc + " " + (isOk ? sb : "impossible"));
		}
	}

	static void per(int cnt, int idx) {
		if (isOk) { // 찾으면 나머지 필요없어
			return;
		}

		if (arr[1] - arr[2] > 1 || arr[2] - arr[1] > 1) {
			return;
		}

		list[cnt] = idx;
		arr[idx]--;

		if (cnt == list.length - 1) {

			int num = list[0];

			if (num == 0) {
				sb.append(0);
			} else if (num == 1) {
				sb.append(0);
			} else if (num == 2) {
				sb.append(1);
			} else if (num == 3) {
				sb.append(1);
			}

			for (int i = 0; i < list.length; i++) {

				num = list[i];

				if (num == 0) {
					sb.append(0);
				} else if (num == 1) {
					sb.append(1);
				} else if (num == 2) {
					sb.append(0);
				} else if (num == 3) {
					sb.append(1);
				}
			}

			isOk = true;
			return;
		}

		if (idx % 2 == 0) {
			for (int i = 0; i <= 1; i++) {
				if (arr[i] != 0) {
					per(cnt + 1, i);
				}
			}
		} else {
			for (int i = 2; i <= 3; i++) {
				if (arr[i] != 0) {
					per(cnt + 1, i);
				}
			}
		}

		arr[idx]++;
		list[cnt] = -1;
	}
}
