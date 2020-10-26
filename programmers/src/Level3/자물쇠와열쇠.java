package Level3;

public class 자물쇠와열쇠 {
	static int n, m;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
//		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] key = { { 0, 0, 0, 0 }, { 1, 0, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		solution(key, lock);
	}

	static boolean solution(int[][] key, int[][] lock) {
		boolean ans = false;
		n = lock.length;
		m = key.length;

		// 4방향 돌려보기 시계방향 90도
		int idx = 0;
		int s = 0;
		int e = m - 1;
		int size = m - 1;

		int[][] temp = new int[m][m];

		for (int a = 0; a < m / 2; a++) { // 전체 한칸씩 내려가기

			int x = idx;
			int y = idx;
			int nx = 0;
			int ny = 0;

			for (int i = 0; i < 4; i++) { // 4방향 돌거야

				for (int j = s; j < e; j++) { // 사이즈 만큼 이동할거야
					System.out.println(x + " " + y);
					
					if (i == 0) {
						if (y + size > e) {
							ny = e;
							nx = e - y;
						} else {
							ny = e;
						}
					} else if (i == 1) {
						if (x + size > e) {
							nx = e;
							ny = e - x;
						} else {
							nx = e;
						}
					} else if (i == 2) {
						if(y - size > s) {
							ny = s;
							nx = y;
						}else {
							ny = s;
						}
					} else {
					}
					
					System.out.println("#" + nx + " " + ny);
					x += dx[i];
					y += dy[i];
				}
			}

			idx++;
			size -= 2;
			s++;
			e--;
		}

//			System.out.println();
//			for (int i = 0; i < m; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(temp[i][j] + " ");
//				}
//				System.out.println();
//			}

		return ans;
	}

	static void move(int x, int y) {

	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
			return true;
		} else {
			return false;
		}
	}
}
