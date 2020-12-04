package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[2 * n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] robots = new int[n];

		int cnt = 0;
		int ans = 0;
		while (cnt < k) {
			// 벨트 회전
			// 먼저 끝에 있는애는 내려
			robots[robots.length - 1] = 0; // 내리고 로테이트 한다.
			rotate(arr);
			rotate(robots);

			// 로봇 이동
			robots[robots.length - 1] = 0; // 벨트가 이동해서 또 끝이면 내린다.
			for (int i = robots.length - 2; i >= 0; i--) {
				if (robots[i] == 1) { // 로봇이 있으면
					if (robots[i + 1] == 0 && arr[i + 1] > 0) { // 앞자리가 비었고 내구도가 남아있으면 이동
						robots[i] = 0;
						robots[i + 1] = 1;
						arr[i + 1]--;
						if (arr[i + 1] == 0) {
							cnt++;
						}
					}
				}
			}

			if (arr[0] > 0) {
				robots[0] = 1;
				arr[0]--;
				if (arr[0] == 0) {
					cnt++;
				}
			}

			ans++;
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(robots));
		}
		System.out.println(ans);
	}

	static void rotate(int[] arr) {
		int idx = 0;
		int input = arr[arr.length - 1];
		int temp = 0;

		while (idx < arr.length) {
			temp = arr[idx];
			arr[idx] = input;
			input = temp;
			idx++;
		}
	}
}
