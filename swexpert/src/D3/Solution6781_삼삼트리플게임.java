package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6781_삼삼트리플게임 {
	static int[][] arr;
	static boolean isOk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			isOk = true;
			arr = new int[3][10];
			String s1 = br.readLine();
			String s2 = br.readLine();

			for (int i = 0; i < 9; i++) {
				int num = s1.charAt(i) - '0';
				char color = s2.charAt(i);

				switch (color) {
				case 'R':
					arr[0][num]++;
					break;

				case 'G':
					arr[1][num]++;
					break;

				case 'B':
					arr[2][num]++;
					break;
				}
			}
			int cnt = 0;
			loop: for (int i = 0; i < 3; i++) {
				for (int j = 1; j < 10; j++) {
					if (arr[i][j] != 0) {
						if (arr[i][j] != 0) {
							if (arr[i][j] >= 3) { // 연속된 3개가 있으면 -3
								arr[i][j] -= 3;
							}

							while (arr[i][j] > 0) { // 1보다 크고
								if (j + 2 < 10) { // 연속되게 갈 수 있으면
									if (arr[i][j + 1] >= 1 && arr[i][j + 2] >= 1) { // 연속된 애들이 1개 이상있으면 사용하자
										arr[i][j]--;
										arr[i][j + 1]--;
										arr[i][j + 2]--;
									} else {
										isOk = false;
										break loop;
									}
								} else {
									isOk = false;
									break loop;
								}
							}
						}
					}
				}
			}

			System.out.println("#" + tc + " " + (isOk ? "Win" : "Continue"));
		}
	}

}
