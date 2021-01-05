package programmers.level3;

public class 방문길이 {
	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		System.out.println(solution(dirs));
	}
	static int solution(String dirs) {
		boolean[][][][] visit = new boolean[11][11][11][11];
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		// d, r, u, l
		int ans = 0;

		int x = 5, y = 5, nx = 0, ny = 0;
		for (int i = 0; i < dirs.length(); i++) {
			switch (dirs.charAt(i)) {
			case 'D':
				nx = x + dx[0];
				ny = y + dy[0];
				break;
			case 'R':
				nx = x + dx[1];
				ny = y + dy[1];
				break;
			case 'U':
				nx = x + dx[2];
				ny = y + dy[2];
				break;
			case 'L':
				nx = x + dx[3];
				ny = y + dy[3];
				break;
			}

			if (!isOk(nx, ny)) {
				continue;
			}

			if (!visit[x][y][nx][ny]) {
				ans++;
				visit[x][y][nx][ny] = true;
				visit[nx][ny][x][y] = true;
			}

			x = nx;
			y = ny;
		}
		
		return ans;
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < 11 && ny < 11) {
			return true;
		} else {
			return false;
		}
	}
}
