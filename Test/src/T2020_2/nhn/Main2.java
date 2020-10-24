package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int day = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] blocks = new int[day][n];
		StringTokenizer st;
		for (int i = 0; i < blocks.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				blocks[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum = 0;

		solution(day, n, blocks);
	}

	static void solution(int day, int n, int[][] blocks) {
		int[] map = new int[n];

		int now = 0;
		while (now < day) {
//			System.out.println(now);

			// 벽돌
			for (int i = 0; i < n; i++) {
				map[i] += blocks[now][i];
			}

			// 시멘트
			int h1 = map[0]; // 시작 높이
			int idx1 = 0; // 시작 인덱스

			while (idx1 < n - 1) { // 끝까지 도달하기
//			while (cnt < 2) {
				int h2 = 0; // 두번째 높이
				int idx2 = 0;
				boolean isOk = false;
				for (int i = idx1 + 1; i < n; i++) {
					// 자기 자신보다 크거나 같은것을 만나면
					if (h1 <= map[i]) {
						// 시멘트 채우기
						for (int j = idx1 + 1; j < i; j++) {
							sum += h1 - map[j]; // 사용한 시멘트 수
							map[j] = h1;
						}

						// 높이랑 인덱스 갱신
						h1 = map[i];
						idx1 = i;

						// 다음으로 가자
						isOk = true;
						break;

					} else { // h1보다 작으면 그중에서 제일 큰거를 저장하기
						if (h2 < map[i]) {
							h2 = map[i];
							idx2 = i;
						}
					}
				}
				
				if (!isOk) { // 못찾았으면 두번째로 큰 애로 채우기
					// 기준부터 두번째로 큰 애전까지
					for (int i = idx1 + 1; i < idx2; i++) {
						sum += h2 - map[i]; // 사용한 시멘트 수
						map[i] = h2;
					}

					// 높이랑 인덱스 갱신
					h1 = h2;
					idx1 = idx2;
				}
			}
			
			now++;
			
//			System.out.println(Arrays.toString(map));
		}
		System.out.println(sum);
	}
}
