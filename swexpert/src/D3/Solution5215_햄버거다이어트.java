package D3;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution5215_햄버거다이어트 {
	static material[] arr;
	static int N, L, ans;
	static material[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ans = 0;
			arr = new material[N];
			list = new material[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int T = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());

				arr[i] = new material(T, K);
			}

			for (int i = 1; i < N; i++) {
				list = new material[i];
				com(0, 0, i);
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void com(int idx, int target, int end) {
		if (idx == end) {
			
			int Tsum = 0;
			int Lsum = 0;
			
			for (int i = 0; i < list.length; i++) {
				Tsum += list[i].t;
				Lsum += list[i].k;
			}
			
			if(Lsum <= L) {
				ans = Math.max(ans, Tsum);
			}
			
			return;
		} else if (target == N) {
			return;
		} else {
			material m = arr[target];
			list[idx] = m;
			com(idx + 1, target + 1, end);
			com(idx, target + 1, end);
		}
	}

	static class material {
		int t, k;

		public material(int t, int k) {
			super();
			this.t = t;
			this.k = k;
		}

		@Override
		public String toString() {
			return "material [t=" + t + ", k=" + k + "]";
		}
	}
}
