package T2020_2.kakao;

public class Solution1 {

	public static void main(String[] args) {
//		String new_id = "...!@BaT#*..y.abcdefghijklm";
//		String new_id = "...!@BaT#*..y.abcdefgh.ij....klm......";
		String new_id = "z-+.^.";
		solution(new_id);
	}

	static String solution(String new_id) {
		// 1단계
		StringBuilder sb = new StringBuilder(new_id.toLowerCase());
		System.out.println("1단계: " + sb.toString());

		// 숫자 48 ~ 57, 소문자 97 ~ 122, '-' '_' '.'
		StringBuilder ans = new StringBuilder();

		// 2단계
		for (int i = 0; i < sb.length(); i++) {
			char temp = sb.charAt(i);
			if (isOk(temp)) {
				ans.append(temp);
			}
		}

		System.out.println("2단계: " + ans);

		// 3단계
		int cnt = 0;

		for (int i = 0; i < ans.length(); i++) {
			char temp = ans.charAt(i);

			if (temp == '.') {
				cnt++;
			} else {
				if (cnt == 0) { // 0개의 경우
					continue;
				}

				if (cnt == 1) { // 1개의 경우
					cnt = 0;
					continue;
				}

				ans = ans.replace(i - cnt, i, ".");
				i -= cnt - 1;
				cnt = 0;
			}
		}

		if (cnt != 0) {
			ans = ans.replace(ans.length() - cnt, ans.length(), ".");
		}

		System.out.println("3단계: " + ans);

		// 4단계
		if (ans.length() == 1) { // 길이가 1이면 하나만 지우고
			char start = ans.charAt(0);

			if (start == '.') {
				ans.deleteCharAt(0);
			}
		} else if (ans.length() > 1) { // 길이가 2이상이면 두개 지운다.
			char start = ans.charAt(0);
			char end = ans.charAt(ans.length() - 1);

			if (start == '.') {
				ans.deleteCharAt(0);
			}

			if (end == '.') {
				ans.deleteCharAt(ans.length() - 1);
			}
		}

		System.out.println("4단계: " + ans);
		// 5단계
		if (ans.length() == 0) {
			ans.append('a');
		}

		System.out.println("5단계: " + ans);

		if (ans.length() >= 16) {
			String temp = ans.substring(0, 15);
			ans = new StringBuilder(temp);
			
			if(ans.charAt(14) == '.') {
				ans.deleteCharAt(14);
			}
		}

		System.out.println("6단계: " + ans);
		
		// 7단계
		if(ans.length() <= 2) {
			while(ans.length() < 3) {
				ans.append(ans.charAt(ans.length()-1));
			}
		}
		
		System.out.println("7단계: " + ans);
		
		return ans.toString();
	}

	static boolean isOk(char temp) {
		if (temp >= 48 && temp <= 57) {
			return true;
		} else if (temp >= 97 && temp <= 122) {
			return true;
		} else if (temp == '-' || temp == '_' || temp == '.') {
			return true;
		} else {
			return false;
		}
	}
}
