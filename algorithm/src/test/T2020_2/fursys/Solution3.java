package test.T2020_2.fursys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String plain = br.readLine();
//		String plain = "abcde";
		System.out.println(solution(plain));
	}

	static int solution(String plain) {
		char[] arr = plain.toCharArray();
		int r = 0;
		int l = plain.length() - 1;
		int cnt = 0;
		boolean isOk = true;

		for (int i = 0; i < plain.length(); i++) {
			isOk = true;
			cnt = 0;
			r = i;
			l = plain.length() - 1;

			while (r < l) {
				if (arr[r] == arr[l]) {
					r++;
					l--;
					cnt += 2;
				} else {
					isOk = false;
					break;
				}
			}

			if (r == l && arr[r] == arr[l]) {
				cnt++;
			}

			if (!isOk) {
				continue;
			} else {
				break;
			}
		}
		
		return plain.length() + plain.length() - cnt;
	}
}
