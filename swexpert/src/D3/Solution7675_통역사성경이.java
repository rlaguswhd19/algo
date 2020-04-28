package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7675_통역사성경이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
//			65 ~ 96 대문자 97~ 소문자
			int ans = 0;
			int[] list = new int[n];
			System.out.print("#" + tc + " ");
			int idx = 0;
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				char[] arr = s.toCharArray();
				boolean isOk = true;
				for (int i = 0; i < arr.length; i++) {
					char c = arr[i];

					// 첫글자 대문자인지 확인
					if (i == 0) {
						if ((int) c >= 97 || (int)c < 65) { // 첫글자가 소문자이면 끝내기
							isOk = false;
							break;
						}
					} else {
						// 구문점이면 추가하고 break해
						if(i == arr.length-1) {
							if (c == '!' || c == '?' || c == '.') {
								break;
							}
						}

						// 대문자가 중간에 나오면
						if ((int) c < 97) {
							isOk = false;
							break;
						}
					}
				}

				if (isOk) {
					ans++;
				}

				char end = arr[arr.length - 1];
				if (end == '!' || end == '?' || end == '.') {
					list[idx++] = ans;
					ans = 0;
				}
			}
			for (int i = 0; i < list.length; i++) {
				System.out.print(list[i]+" ");
			}
			System.out.println();
		}
	}
}
