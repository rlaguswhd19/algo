package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main17135 {
	static int n, m, d, ans;
	static Point[] archer = new Point[3];
	static int[][] map;
	static ArrayList<Point> enemy = new ArrayList<>();
	static Point[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[n + 1][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					enemy.add(new Point(i, j));
				}
			}
		}
		
		com(0, 0);
		
		System.out.println(ans);
	}

	static void start() {
		
		ArrayList<Point> temp = new ArrayList<>();
		for (int i = 0; i < enemy.size(); i++) {
			temp.add(new Point(enemy.get(i).x, enemy.get(i).y));
		}

		int sum = 0;
		while (!temp.isEmpty()) {
			// 궁수가 공격한다.
			list = new Point[3];

			for (int i = 0; i < archer.length; i++) {

				Point Archer = archer[i];
				// 각 궁수마다 제거할 대상들 할당
				ArrayList<Point> remove = new ArrayList<>();

				// 최솟값 초기화
				int min = Integer.MAX_VALUE;

				for (int j = 0; j < temp.size(); j++) {
					Point Enemy = temp.get(j);

					// 거리 계산
					int distance = Math.abs(Archer.x - Enemy.x) + Math.abs(Archer.y - Enemy.y);

					// 사정거리 안에 들어올때
					if (distance > d) {
						continue;
					}

					// 짧다?
					if (distance < min) {
						// 새로운 거리가 나오니까 그전 적들 초기화
						remove = new ArrayList<>();
						// 적 추가
						remove.add(Enemy);
						// 최소값 갱신
						min = distance;
					} else if (distance == min) {
						// 같을땐 적만 추가
						remove.add(Enemy);
					}
				}

				if (remove.size() == 0) {
					continue;
				}

				// 하나의 궁수에게 적을 할당하자.
				Collections.sort(remove, new Comparator<Point>() {
					@Override
					public int compare(Point p1, Point p2) {
						if (p1.y < p2.y) {
							return -1;
						} else {
							return 1;
						}
					}
				});

				// 제거할 대상 넣어주기
				Point insert = remove.get(0);
				list[i] = insert;
			}

			// 적 제거
			for (int i = 0; i < 3; i++) {

				if (list[i] == null) {
					continue;
				}
				
				if(temp.remove(list[i])) {
					sum++;
				}
				
			}
			// 적이 이동한다.

			ArrayList<Point> koong = new ArrayList<>();
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).x + 1 == n) {
					koong.add(temp.get(i));
				} else {
					temp.get(i).x++;
				}
			}

			for (int i = 0; i < koong.size(); i++) {
				temp.remove(koong.get(i));
			}
		}
		
		ans = Math.max(ans, sum);
	}

	static void com(int cnt, int target) {
		if (cnt == 3) {
			start();
			return;
		} else if (target == m) {
			return;
		} else {
			archer[cnt] = new Point(n, target);
			com(cnt + 1, target + 1);
			com(cnt, target + 1);
		}
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
