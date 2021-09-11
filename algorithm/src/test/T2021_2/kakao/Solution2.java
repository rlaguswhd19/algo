package test.T2021_2.kakao;

public class Solution2 {
	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		solution(n, k);
	}

	static int solution(int n, int k) {
		int ans = 0;

		StringBuilder sb = new StringBuilder();
		
		while (n > 0) {
			sb.append(n % k);
			n /= k;
		}
		
		String change = sb.toString();
		sb = new StringBuilder();
		for (int i = change.length() - 1; i >= 0; i--) {
			char c = change.charAt(i);
			if (c == '0') {
				if (sb.length() == 0) {
					continue;
				}

				long num = Long.parseLong(sb.toString());

				if (num < 2) {
					sb = new StringBuilder();
					continue;
				}
				
				if(isPrime(num)) {
					ans++;
				}

				sb = new StringBuilder();
			} else {
				sb.append(c);
			}
		}
		
		if (sb.length() != 0) {
			long num = Long.parseLong(sb.toString());
			
			if(num >= 2) {
				if(isPrime(num)) {
					ans++;
				}
			}
		}
		
		return ans;
	}

	static boolean isPrime(long num) {
		if(num < 2) {
			return false;
		}
		
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
