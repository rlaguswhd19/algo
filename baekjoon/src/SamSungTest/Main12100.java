package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12100 {
	static Point[][] map;
	static int n, ans;
	static Queue<Point[][]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new Point[n][n];
		ans = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				ans = Math.max(ans, num);
				map[i][j] = new Point(num, false);

			}
		}

		bfs();

		System.out.println(ans);
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(map);
		int count = 0;

		while (count < 5) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point[][] temp = q.poll();
				up(deepCopy(temp));
//				System.out.println();
//				for (int j = 0; j < temp.length; j++) {
//					for (int j2 = 0; j2 < temp.length; j2++) {
//						System.out.print(temp[j][j2].num + " ");
//					}
//					System.out.println();
//				}
				right(deepCopy(temp));
				
//				System.out.println();
//				for (int j = 0; j < temp.length; j++) {
//					for (int j2 = 0; j2 < temp.length; j2++) {
//						System.out.print(temp[j][j2].num + " ");
//					}
//					System.out.println();
//				}
				down(deepCopy(temp));
				left(deepCopy(temp));
			}
			// 최대 5번
			count++;
		}
	}
	static Point[][] deepCopy(Point[][] t) {
		Point[][] copy = new Point[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int num = t[i][j].num;
				boolean add = t[i][j].add;
				copy[i][j] = new Point(num, add);
			}
		}
		
		return copy;
	}
	
	static void up(Point[][] clone) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Point p = clone[i][j];

				if (p.num == 0) {
					continue;
				}

				int x = i;
				int y = j;
				int num = p.num;
				loop: while (x >= 0) {
					x -= 1;
					if (x < 0) {

						clone[x + 1][y].num = num;

						if (x + 1 != i) {
							p.num = 0;
						}

						break loop;
					}

					// 올라갔는데 0이아니야
					if (clone[x][y].num != 0) {
						if (clone[x][y].num == num && !clone[x][y].add) {
							clone[x][y].num += num;
							ans = Math.max(ans, clone[x][y].num);
							clone[x][y].add = true;

							if (x != i) {
								p.num = 0;
							}
						} else {
							clone[x + 1][y].num = num;

							if (x + 1 != i) {
								p.num = 0;
							}
						}
						break loop;
					}
				}
			}
		}

		// reset
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				clone[i][j].add = false;
			}
		}

		q.add(clone);
	}

	static void down(Point[][] clone) {
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				Point p = clone[i][j];

				if (p.num == 0) {
					continue;
				}

				int x = i;
				int y = j;
				int num = p.num;

				loop: while (x <= n - 1) {
					x += 1;
					if (x > n - 1) {
						clone[x - 1][y].num = num;

						if (x - 1 != i) {
							p.num = 0;
						}
						break loop;
					}

					if (clone[x][y].num != 0) {
						if (clone[x][y].num == num && !clone[x][y].add) {
							clone[x][y].num += num;
							ans = Math.max(ans, clone[x][y].num);
							clone[x][y].add = true;

							if (x != i) {
								p.num = 0;
							}
						} else {
							clone[x - 1][y].num = num;

							if (x - 1 != i) {
								p.num = 0;
							}
						}
						break loop;
					}
				}
			}
		}

		// reset
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				clone[i][j].add = false;
			}
		}

		q.add(clone);
	}

	static void left(Point[][] clone) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Point p = clone[j][i];

				if (p.num == 0) {
					continue;
				}
				int x = j;
				int y = i;
				int num = p.num;
				loop: while (y >= 0) {
					y -= 1;

					if (y < 0) {
						clone[x][y + 1].num = num;

						if (y + 1 != i) {
							p.num = 0;
						}
						break loop;
					}

					if (clone[x][y].num != 0) {
						if (clone[x][y].num == num && !clone[x][y].add) {
							clone[x][y].num += num;
							ans = Math.max(ans, clone[x][y].num);
							clone[x][y].add = true;

							if (y != i) {
								p.num = 0;
							}
						} else {
							clone[x][y + 1].num = num;

							if (y + 1 != i) {
								p.num = 0;
							}
						}
						break loop;
					}
				}
			}
		}

		// reset
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				clone[i][j].add = false;
			}
		}

		q.add(clone);
	}

	static void right(Point[][] clone) {
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				Point p = clone[j][i];
				if (p.num == 0) {
					continue;
				}
				int x = j;
				int y = i;
				int num = p.num;
				loop: while (y <= n - 1) {
					y += 1;

					if (y > n - 1) {
						clone[x][y - 1].num = num;

						if (y - 1 != i) {
							p.num = 0;
						}
						break loop;
					}

					if (clone[x][y].num != 0) {
						if (clone[x][y].num == num && !clone[x][y].add) {
							clone[x][y].num += num;
							ans = Math.max(ans, clone[x][y].num);
							clone[x][y].add = true;

							if (y != i) {
								p.num = 0;
							}
						} else {
							clone[x][y - 1].num = num;

							if (y - 1 != i) {
								p.num = 0;
							}
						}
						break loop;
					}
				}
			}
		}

		// reset
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				clone[i][j].add = false;
			}
		}

		q.add(clone);
	}

	static class Point {
		int num;
		boolean add;

		public Point(int num, boolean add) {
			super();
			this.num = num;
			this.add = add;
		}

		@Override
		public String toString() {
			return "Point [num=" + num + ", add=" + add + "]";
		}
	}
}
