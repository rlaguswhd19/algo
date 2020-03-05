package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14501 {
	static int n;
	static Queue<Day> q;
	static int[][] map;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][2];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}

		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(new Day(0, 0, 0));

		int count = 0;
		while (count < n + 1) {
			System.out.println(count);
			System.out.println(q);
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Day d = q.poll();
				int sum = d.sum;
				int add = d.add;
				int cnt = d.cnt;
				
				if(cnt == 0) {
					sum+=add;
					
					q.add(new Day(sum, cnt, add));
					
					cnt = map[count][0];
					add = map[count][1];
					
					q.add(new Day(sum, cnt, add));
				}else {
					cnt--;
					
					q.add(new Day(sum, cnt, add));
				}
			}
			//하루씩 증가
			count++;
		}
	}

	static class Day {
		int sum, cnt, add;

		public Day(int sum, int cnt, int add) {
			super();
			this.sum = sum;
			this.cnt = cnt;
			this.add = add;
		}

		@Override
		public String toString() {
			return "Day [sum=" + sum + ", cnt=" + cnt + ", add=" + add + "]";
		}
	}
}