package Level3;

public class 입국심사 {
	public static void main(String[] args) {
		int n = 3;
		int[] times = { 7, 10 };
		System.out.println(solution(n, times));
	}

	static long solution(int n, int[] times) {
		long max = 0;
		for (int i = 0; i < times.length; i++) {
			max = Math.max(max, times[i]);
		}

		long ans = Long.MAX_VALUE;
		long left = 1;
		long right = max * n;
		long mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			if (check(times, mid, n)) {
				if (mid < ans) {
					ans = mid;
				}

				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return ans;
	}

	static boolean check(int[] times, long mid, int n) {
		long sum = 0;
		for (int i = 0; i < times.length; i++) {
			sum += mid / times[i];
            
		}
		
		if(sum >= n){
			return true;
		}
        
        return false;
	}
}
