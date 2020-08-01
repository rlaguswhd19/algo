package T2019_2.Kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class solution_5 {
	static int[] list;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> q;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		int n = 9;
		int[][] path = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
		int[][] order = { { 4, 1 }, { 8, 7 }, { 6, 5 } };
		list = new int[n];
		visit = new boolean[n];
		map = new int[n][n];
		Arrays.fill(list, -1);
		q = new LinkedList<>();

		for (int i = 0; i < n - 1; i++) {
			int start = path[i][0];
			int end = path[i][1];

			map[start][end] = 1;
			map[end][start] = 1;
		}

		for (int i = 0; i < order.length; i++) {
			int start = order[i][0]; // 가기전 방문해야하는곳
			int end = order[i][1]; // 간후에 방문할수 있는곳
			list[start] = end;
			list[end] = -2; // 잠궈놓기
		}

		q.add(0);
		visit[0] = true;
		set.add(0);
		bfs();

		System.out.println(set);
	}

	static void bfs() {

		while (!q.isEmpty()) {
			System.out.println(q);
			int num = q.poll();

			// 뭔가 열릴수 있는 곳이면
			if (list[num] != -1 && list[num] != -2) {

				if (set.contains(list[num])) {
					q.add(list[num]);
					visit[list[num]] = true;
				}
			}

			for (int i = 0; i < map.length; i++) {

				if (visit[i]) {
					continue;
				}

				if (map[num][i] == 0) {
					continue;
				}

				// 갈 수 있는곳은 set에 넣어놔
				set.add(i);

				// 잠궈놓은곳이 아니면
				if (list[i] != -2) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
