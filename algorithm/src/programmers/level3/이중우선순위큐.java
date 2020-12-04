package programmers.level3;

import java.util.Collections;
import java.util.LinkedList;

public class 이중우선순위큐 {
	public static void main(String[] args) {
		String[] operations = { "I 7", "I 5", "I -5", "D -1" };
		solution(operations);
	}

	static int[] solution(String[] operations) {
		LinkedList<Integer> dq = new LinkedList<>();
		for (int i = 0; i < operations.length; i++) {
			String s = operations[i];
			if (s.charAt(0) == 'I') {
				dq.add(Integer.parseInt(s.substring(2, s.length())));
			} else if (s.charAt(0) == 'D') {
				Collections.sort(dq);
				if (s.charAt(2) == '1') {
					dq.pollLast();
				} else {
					dq.pollFirst();
				}
			}
		}

		Collections.sort(dq);
		int[] ans = new int[2];
		if (!dq.isEmpty()) {
			ans[0] = dq.peekLast();
			ans[1] = dq.peekFirst();
		}
		return ans;
	}
}
