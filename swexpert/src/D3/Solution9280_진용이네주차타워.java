package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution9280_진용이네주차타워 {
	static int n, m;
	static int[] cost, weight;
	static int[] car; // 차량번호
	static boolean[] visit;
	static int ans;
	static Queue<Integer> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			ans = 0;
			cost = new int[n + 1];
			visit = new boolean[n + 1];
			car = new int[m + 1];
			weight = new int[m + 1];
			q = new LinkedList<>();

			for (int i = 1; i <= n; i++) {
				cost[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 1; i <= m; i++) {
				weight[i] = Integer.parseInt(br.readLine());
			}

			int cnt = 1;
			for (int i = 0; i < 2 * m; i++) {
				int num = Integer.parseInt(br.readLine());
				if (num > 0) { // 대기열인 q에 넣기
					if (cnt == visit.length) {
						q.add(num);
					} else { // 자리에 넣기
						for (int j = 1; j < visit.length; j++) {
							if (!visit[j]) {
								car[num] = j;
								visit[j] = true;
								cnt++;
								break;
							}
						}
					}
				} else {
					num = Math.abs(num);
					ans += cost[car[num]] * weight[num];
					visit[car[num]] = false;
					cnt--;
					if (!q.isEmpty()) { // 대기열이 있다면
						num = q.poll();
						for (int j = 1; j < visit.length; j++) {
							if (!visit[j]) {
								car[num] = j;
								visit[j] = true;
								cnt++;
								break;
							}
						}
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
