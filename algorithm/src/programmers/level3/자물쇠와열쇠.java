package programmers.level3;

public class 자물쇠와열쇠 {
	static int n, m, cnt;

	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(solution(key, lock));
	}

	static boolean solution(int[][] key, int[][] lock) {
		n = key.length;
		m = lock.length;
		cnt = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(lock[i][j] == 0) {
					cnt++;
				}
			}
		}
		

		if (check(key, lock)) {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			key = rotate(key);

			if (check(key, lock)) {
				return true;
			}
		}

		return false;
	}

	static boolean check(int[][] key, int[][] lock) {
		int count = 0;
		
		for (int i = -n + 1; i < m; i++) {
			for (int j = -n + 1; j < m + n - 1; j++) {
				count = 0;
				
				loop: for (int r = i; r < i + n; r++) {
					for (int c = j; c < j + n; c++) {
						if (!isOk(r, c)) {
							continue;
						}
						
						if(lock[r][c] == 1 && key[r-i][c-j] == 1) { // 돌기 끼리 만나면
							break loop;
						}
						
						if(lock[r][c] == 0) {
							if(key[r-i][c-j] == 0) { // 홈끼리 만나면
								break loop;
							}else { // 홈을 채울 수 있으면
								count++;
							}
						}
					}
				}
				
				if(count == cnt) {
					return true;
				}
			}
		}
		
		return false;
	}

	static int[][] rotate(int[][] key) {
		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[j][n - i - 1] = key[i][j];
			}
		}

		return result;
	}

	static boolean isOk(int r, int c) {
		if (r >= 0 && c >= 0 && r < m && c < m) {
			return true;
		} else {
			return false;
		}
	}
}
