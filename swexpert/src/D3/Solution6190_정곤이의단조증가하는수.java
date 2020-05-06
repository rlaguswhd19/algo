package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6190_정곤이의단조증가하는수 {
	static int[] arr;
	static int n, ans;
	static char[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int result = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					result = arr[i] * arr[j];
					boolean isOk = true;

					if (result <= ans) {
						continue;
					}

					list = ("" + result).toCharArray();
					int before = list[0] - '0';
					for (int j2 = 1; j2 < list.length; j2++) {
						int num = list[j2] - '0';

						if (before > num) {
							isOk = false;
							break;
						}

						before = num;
					}

					if (isOk) {
						System.out.println(result);
						ans = result;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

}
