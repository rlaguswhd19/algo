package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7272_안경이없어 {
	static char[] arr = { 'A', 'D', 'O', 'P', 'Q', 'R' };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			if (s1.length() != s2.length()) {
				System.out.println("#" + tc + " " + "DIFF");
			} else {
				boolean isOk = true;

				for (int i = 0; i < s1.length(); i++) {
					int num1 = -1;
					int num2 = -1;
					char c1 = s1.charAt(i);
					char c2 = s2.charAt(i);

					for (int j = 0; j < arr.length; j++) {
						if (c1 == arr[j]) {
							num1 = 1;
						}

						if (c2 == arr[j]) {
							num2 = 1;
						}
					}

					if (num1 == 1 && num2 == 1) {
						continue;
					} else if (num1 == -1 && num2 == -1) {
						if ((c1 == 'B' && c2 == 'B') || (c1 != 'B' && c2 != 'B')) {
							continue;
						} else {
							isOk = false;
						}
					} else { //둘이 다르면
						isOk = false;
						break;
					}
				}

				System.out.println("#" + tc + " " + (isOk ? "SAME" : "DIFF"));
			}
		}
	}
}
