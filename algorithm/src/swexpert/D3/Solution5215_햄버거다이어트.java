package swexpert.D3;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution5215_햄버거다이어트 {
	static material[] arr;
	static int N, L, ans;
	static int[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ans = 0;
			arr = new material[N];
			list = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int T = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());

				arr[i] = new material(T, K);
			}

			com(0, 0, 0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void com(int idx, int target, int Tsum, int Lsum) {
		if (0 < idx && idx <= N) {
			if (Lsum > L) {
				return;
			}
			
			ans = Math.max(ans, Tsum);
		}
		
		if (idx == N) {
			return;
		} else if (target == N) {
			return;
		} else {
			material m = arr[target];
			com(idx, target + 1, Tsum, Lsum);
			com(idx + 1, target + 1, Tsum + m.t, Lsum + m.k);
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
