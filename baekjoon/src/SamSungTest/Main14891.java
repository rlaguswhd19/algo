package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14891 {
	static LinkedList<Integer>[] map;
	static Queue<Rotation> q;
	static int[] visit;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new LinkedList[4];

		for (int i = 0; i < 4; i++) {
			map[i] = new LinkedList<>();
		}

		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i].add(s.charAt(j) - '0');
			}
		}

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			q = new LinkedList<>();
			visit = new int[4];
			// 처음껀 무조건 돌릴꺼니까
			visit[num - 1] = dir;

			q.add(new Rotation(num - 1, dir));

			bfs();
			check();
		}

		for (int i = 0; i < 4; i++) {
			int num = map[i].get(0);
			if (num == 1) {
				if (i == 0) {
					ans++;
				} else {
					ans += 1 << i;
				}
			}
		}

		System.out.println(ans);
	}

	static void check() {
		for (int i = 0; i < 4; i++) {
			if (visit[i] == -1) { // 반시게 방향이면

				int temp = map[i].get(0);
				map[i].add(temp);
				map[i].remove(0);

			} else if (visit[i] == 1) { // 시계 방향이면

				int temp = map[i].get(map[i].size() - 1);
				map[i].addFirst(temp);
				map[i].remove(map[i].size() - 1);

			}
		}
	}

	static void bfs() {

		while (!q.isEmpty()) {
			Rotation r = q.poll();

			// 왼쪽 2번, 오른쪽 6번
			int num = r.num;
			int dir = r.dir;

			// num-1 num+1
			int next = num + 1;
			int before = num - 1;

			int right = map[num].get(2);
			int left = map[num].get(6);

			int ndir;

			if (dir == 1) {
				ndir = -1;
			} else {
				ndir = 1;
			}

			if (next < 4) { // 톱니가 있고
				if (visit[next] == 0) { // 아직 안돌렸으면
					if (right != map[next].get(6)) {

						visit[next] = ndir;
						q.add(new Rotation(next, ndir));
					} else { // 못돌리면 2로
						visit[next] = 2;
					}
				}
			}

			if (before >= 0) {
				if (visit[before] == 0) {
					if (left != map[before].get(2)) {

						visit[before] = ndir;
						q.add(new Rotation(before, ndir));
					} else {
						visit[before] = 2;
					}
				}
			}
		}
	}

	static class Rotation {
		int num, dir;

		public Rotation(int num, int dir) {
			super();
			this.num = num;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Rotation [num=" + num + ", dir=" + dir + "]";
		}
	}
}
