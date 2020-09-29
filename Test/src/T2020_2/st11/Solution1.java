package T2020_2.st11;

public class Solution1 {
	public static void main(String[] args) {
		String s = "baaaa";
		System.out.println(solution(s));
	}

	static int solution(String S) {
		if (S.contains("aaa")) {
			return -1;
		}

		char[] arr = S.toCharArray();

		int cnt = 0;
		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'a') {
				cnt++;
				continue;
			} else {
				ans += 2 - cnt;
				cnt = 0;
			}
		}

		ans += 2 - cnt;
		
		return ans;
	}
}
