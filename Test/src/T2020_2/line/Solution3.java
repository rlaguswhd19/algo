package line;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
	public static void main(String[] args) {
		int n = 1;
		System.out.println(Arrays.toString(solution(n)));
	}

	static int[] solution(int n) {
		int[] ans = new int[2];
		if(Integer.toString(n).length() == 1) {
			ans[1] = n;
			return ans; 
		}
		
		Queue<String> q = new LinkedList<>();
		boolean[] visit = new boolean[n];
		q.add(Integer.toString(n));
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			System.out.println(q);

			for (int i = 0; i < size; i++) {
				String s = q.poll();

				for (int j = 1; j < s.length(); j++) {
					String s1 = s.substring(0, j);
					String s2 = s.substring(j, s.length());
					
					// 앞에 0인거 체크
					if(s2.charAt(0) == '0') {
						continue;
					}
					
					int n1 = Integer.parseInt(s.substring(0, j));
					int n2 = Integer.parseInt(s2);
					
					// 숫자가 0인거 체크
					if (n1 == 0 || n2 == 0) {
						continue;
					}

					int sum = n1 + n2;

					String result = Integer.toString(sum);

					if (result.length() == 1) {
						ans[0] = cnt + 1;
						ans[1] = sum;
						return ans;
					}

					if (!visit[sum]) {
						visit[sum] = true;
						q.add(result);
					}
				}
			}

			cnt++;
		}

		return null;
	}
}
