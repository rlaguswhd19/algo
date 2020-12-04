package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6900_주혁이의복권당첨 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			Lotto[] arr = new Lotto[n];
			int ans = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				String num = st.nextToken();
				int money = Integer.parseInt(st.nextToken());

				arr[i] = new Lotto(num, money);
			}

			for (int i = 0; i < m; i++) {
				String num = br.readLine();

				for (int j = 0; j < n; j++) {

					boolean isOk = true;
					Lotto lotto = arr[j];
					String real = lotto.num;

					for (int k = 0; k < 8; k++) {
						if (real.charAt(k) == '*') {
							continue;
						} else {
							if (real.charAt(k) != num.charAt(k)) {
								isOk = false;
								break;
							}
						}
					}

					if (isOk) {
						ans += lotto.money;
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static class Lotto {
		String num;
		int money;

		@Override
		public String toString() {
			return "Lotto [num=" + num + ", money=" + money + "]";
		}

		public Lotto(String num, int money) {
			super();
			this.num = num;
			this.money = money;
		}
	}
}
