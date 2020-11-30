package Level3;

public class 가장긴팰린드롬 {
	static char[] list;

	public static void main(String[] args) {
		String s = "a";
		System.out.println(solution(s));
	}

	static int solution(String s) {
		int ans = 0;
		list = s.toCharArray();

		for (int i = 0; i < list.length; i++) {
			ans = Math.max(ans, check(i));
		}

		return ans;
	}

	static int check(int idx) {
		int cnt1 = 0, cnt2 = 1;

		int s, e;

		s = idx;
		e = idx + 1;

		while (true) {
			if (!isOk(s, e)) {
				break;
			}

			if (list[s--] != list[e++]) {
				break;
			}
			cnt1 += 2;
		}

		s = idx - 1;
		e = idx + 1;

		while (true) {
			if (!isOk(s, e)) {
				break;
			}

			if (list[s--] != list[e++]) {
				break;
			}
			cnt2 += 2;
		}

		return cnt1 < cnt2 ? cnt2 : cnt1;
	}

	static boolean isOk(int s, int e) {
		if (s >= 0 && e < list.length) {
			return true;
		} else {
			return false;
		}
	}
}
