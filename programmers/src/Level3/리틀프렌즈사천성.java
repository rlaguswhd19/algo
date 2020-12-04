package Level3;

public class 리틀프렌즈사천성 {
	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		String[] board = { "DBA", "C*A", "CDB" };
		solution(m, n, board);
	}

	static String solution(int m, int n, String[] board) {
		char[][] map = new char[m][n];
		// 순서대로 해야한다.
		int[] visit = new int[91];
		Point[][] list = new Point[91][2];
		int amount = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char temp = board[i].charAt(j);
				if(temp >= 65 && 90 >= temp) {
					list[temp][visit[temp]++] = new Point(i, j);
					amount++;
				}
				
				map[i][j] = temp;
			}
		}

		StringBuilder sb = new StringBuilder();
		int cnt = 0;

		while (cnt < amount) {
			boolean isOk = false;
			for (int i = 65; i < visit.length; i++) { // 알파벳 돌면서 남아있는것을 찾는다.
				if (visit[i] == 2) { // 남아있으면
					if (check(list[i][0], list[i][1])) { // 할 수 있는지 체크해서 할 수 있으면 지운다.
						sb.append((char) i);
						isOk = true;
						visit[i] = 0;
						break;
					}
				}
			}
			
			// 쭉 돌았는데 더이상 못없애면
			if (!isOk) {
				return "IMPOSSIBLE";
			}
			
			cnt += 2;
		}

		return "";
	}

	static boolean check(Point p1, Point p2) {
		
		// p1이 기준이고 p2가 어디에 위치해있는지 확인해서 로직을 짜야한다.
		return false;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
