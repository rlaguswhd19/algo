package Level3;

public class 기둥과보설치 {
	static int[][] pillar, bo;

	public static void main(String[] args) {
		int n = 5;
//		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
//				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
		int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
		solution(n, build_frame);
	}

	static int[][] solution(int n, int[][] build_frame) {
		pillar = new int[n + 1][n + 1];
		bo = new int[n + 1][n + 1];

		int cnt = 0;

		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][1];
			int y = build_frame[i][0];
			int a = build_frame[i][2];
			int b = build_frame[i][3];

			if (b == 1) { // 설치
				if (install_check(x, y, a)) {
					if (a == 0) {
						pillar[x][y] = 1;
					} else {
						bo[x][y] = 1;
					}
					cnt++;
				}
			} else { // 삭제
//				System.out.println(1);
				if (a == 0) { // 기둥일 경우
					pillar[x][y] = 0; // 지워 놓고
					// 위쪽 양쪽에 보, 기둥이 있는지 확인하기
					boolean isOk = true;

					if (pillar[x + 1][y] == 1) { // 위에 기둥이 있으면?
						if (!install_check(x + 1, y, 0)) { // 없어도 설치할 수 있는지
							isOk = false;
						}
					}
					if(y != 0) {
						if (isOk && bo[x + 1][y - 1] == 1) {
							if (!install_check(x + 1, y - 1, 1)) {
								isOk = false;
							}
						}
					}
					
					if (isOk && bo[x + 1][y] == 1) {
						if (!install_check(x + 1, y, 1)) {
							isOk = false;
						}
					}

					if (!isOk) { // 하나라도 안돼면 다시 설치
						pillar[x][y] = 1;
					} else {
						cnt--;
					}

				} else { // 보일 경우
					bo[x][y] = 0;
					boolean isOk = true;

					if (pillar[x][y] == 1) {
						if (!install_check(x, y, 0)) {
							isOk = false;
						}
					}

					if (isOk && pillar[x][y + 1] == 1) {
						if (!install_check(x, y + 1, 0)) {
							isOk = false;
						}
					}

					if (isOk && bo[x][y + 1] == 1) {
						if (!install_check(x, y + 1, 1)) {
							isOk = false;
						}
					}
					if (y != 0) { // 끝이 아니면 확인해봐
						if (isOk && bo[x][y - 1] == 1) {
							if (!install_check(x, y - 1, 1)) { // 얘는 상관이 있니?
								isOk = false;
							}
						}
					}

					if (!isOk) {
						bo[x][y] = 1;
					} else {
						cnt--;
					}
				}
			}
		}

		int[][] ans = new int[cnt][3];
		int idx = 0;

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (pillar[j][i] == 1) {
					ans[idx][0] = i;
					ans[idx][1] = j;
					ans[idx][2] = 0;
					idx++;
				}

				if (bo[j][i] == 1) {
					ans[idx][0] = i;
					ans[idx][1] = j;
					ans[idx][2] = 1;
					idx++;
				}
			}
		}

//		for (int i = 0; i < cnt; i++) {
//			System.out.println(Arrays.toString(ans[i]));
//		}

		return ans;
	}

	static boolean install_check(int x, int y, int a) {
		if (a == 0) { // 기둥
			if (x == 0) { // 바닥이면 설치 가능
				return true;
			} else { // 바닥이 아니면 확인하기
				// 밑에 기둥 || 오른쪽으로 가는 보
				if (pillar[x - 1][y] == 1 || (bo[x][y] == 1)) {
					return true;
				}

				if (y == 0) {
					return false;
				}

				if (bo[x][y - 1] == 1) { // 왼쪽에서 온 보
					return true;
				}

			}
		} else { // 보
			if (pillar[x - 1][y] == 1 || pillar[x - 1][y + 1] == 1) { // 양쪽 밑에 기둥이 있는지 확인하자
				return true;
			}

			if (y == 0) { // 기둥이 없다면? 첫부분은 설치할 수 없어 왼쪽을 보지 못하기 때문에
				return false;
			}

			if (bo[x][y - 1] == 1 && bo[x][y + 1] == 1) { // 양쪽 끝 부분이 보와 연결되어 있는지 확인
				return true;
			}
		}

		return false;
	}
}
