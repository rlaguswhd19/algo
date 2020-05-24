package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3260_두수의덧셈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String s1 = st.nextToken();
			String s2 = st.nextToken();

			String min;
			String max;
			if (s1.length() < s2.length()) {
				min = s1;
				max = s2;
			} else {
				min = s2;
				max = s1;
			}

			char[] maxarr = max.toCharArray();
			char[] minarr = min.toCharArray();

			int idx1 = max.length() - 1;
			int idx2 = min.length() - 1;

			boolean temp = false;

			while (idx1 >= 0) {

				int num1 = maxarr[idx1] - '0';
				int num2 = 0;
				if(idx2 >= 0) {
					num2 = minarr[idx2] - '0';
				}

				int sum = num1 + num2;

				if (temp) {
					sum++;
				}

				if (sum > 9) {
					maxarr[idx1] = (char) (sum % 10 + '0');
					temp = true;
				} else {
					maxarr[idx1] = (char) (sum + '0');
					temp = false;
				}

				idx1--;
				idx2--;
			}

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < maxarr.length; i++) {
				sb.append(maxarr[i]);
			}

			if (temp) {
				sb.insert(0, 1);
			}

			System.out.println("#" + tc + " " + sb.toString());
		}
	}
}
