package programmers.level2;

public class 큰수만들기 {
	public static void main(String[] args) {
		String number = "1924";
		int k = 3;
		System.out.println(solution(number, k));
	}

	static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();

		int start = 0;
		int max, idx, end;

		while (true) {
			max = -1;
			idx = 0;
			end = start + k + 1;

			if (k == 0 || start == number.length()) {
				break;
			}

			if (end > number.length()) {
				end = number.length();
			} else {
				end = start + k + 1;
			}

			// start+k가 number를 넘어갈 경우.. 그다음 작업을 해줘야함
			for (int i = start; i < end; i++) {
				int num = number.charAt(i) - '0';
				if (max < num) {
					max = num;
					idx = i;
				}
			}
			k -= idx - start;
			sb.append(max);
			start = idx + 1;
		}
		
		System.out.println(sb.toString());
		System.out.println(k);
		if (k == 0) {
			sb.append(number.substring(start));
		} else {
			sb.delete(sb.length() - k, sb.length());
		}
		
		return sb.toString();
	}
}
