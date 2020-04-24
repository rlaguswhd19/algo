package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution8556_북북서 {
	static int ans;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();
			int cnt = 0;
			ans = 0;
			arr = new ArrayList<>();
			for (int i = s.length() - 1; i >= 0; i--) {
				char c = s.charAt(i);
				if (c == 'n' || c == 'w') {
					if (cnt == 0) {
						if (c == 'n') {
							ans = 0;
						} else {
							ans = 90;
						}
					}

					if (c == 'n') {
						arr.add(1);
					} else {
						arr.add(0);
					}
					cnt++;
				}
			}

			cnt--;
			ans *= (1 << cnt);
			for (int i = 1; i <= cnt; i++) {
				int num = 90 * 1 << (cnt - i);
				if (arr.get(i) == 1) {
					ans -= num;
				} else {
					ans += num;
				}
			}

			while (cnt > 0) {
				if (ans % 2 == 0) {
					ans /= 2;
					cnt--;
				}else {
					break;
				}
			}

			if (cnt == 0) {
				System.out.println("#" + tc + " " + ans);
			} else {
				System.out.println("#" + tc + " " + ans + "/" + (1 << cnt));
			}
		}
	}
}
