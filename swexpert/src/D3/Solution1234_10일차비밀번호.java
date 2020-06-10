package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1234_10일차비밀번호 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			sb = new StringBuilder(st.nextToken());
			
			for (int i = 0; i < sb.length() - 1; i++) {
				while (true) {
					if (!isRange(i , i + 1)) { // 범위 나가면 그만
						break;
					}

					if (sb.charAt(i) == sb.charAt(i + 1)) { // 지우기
						sb.delete(i, i + 1);
						sb.delete(i, i + 1);
					} else {
						break;
					}

					i--;
				}
			}
			
			System.out.println("#"+tc+" "+sb.toString());
		}
	}

	static boolean isRange(int now, int next) {
		if (now >= 0 && next < sb.length()) {
			return true;
		} else {
			return false;
		}
	}
}
