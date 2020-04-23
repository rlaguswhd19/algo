package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution8673_코딩토너먼트1 {
	static Queue<Integer> q;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(br.readLine());
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			q = new LinkedList<>();

			for (int i = 0; i < 1 << k; i++) {
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
			}

			while (!q.isEmpty()) {
				int size = q.size();
				if (size == 1) {
					break;
				}

				int n1 = q.poll();
				int n2 = q.poll();

				if (n1 < n2) {
					q.add(n2);
					ans += n2 - n1;
				} else {
					q.add(n1);
					ans += n1 - n2;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
