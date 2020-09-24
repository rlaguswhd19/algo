package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10250 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			StringBuilder sb = new StringBuilder();

			int ans = 0;

			if (n % h == 0) {
				ans = h;
			} else {
				ans = n % h;
			}
			ans *= 100;

			if (n % h == 0) {
				ans += n / h;
			} else {
				ans += n / h + 1;
			}

			System.out.println(ans);
		}
	}
}