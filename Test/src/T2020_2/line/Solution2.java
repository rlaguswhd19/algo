package line;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	public static void main(String[] args) {
		int[] ball = { 11, 2, 9, 13, 24 };
		int[] order = { 9, 2, 13, 24, 11 };

		solution(ball, order);
	}

	static int[] solution(int[] ball, int[] order) {
		Deque<Integer> dq = new LinkedList<Integer>();
		int[] list = new int[1000001];
		int[] ans = new int[ball.length];

		for (int i = 0; i < ball.length; i++) {
			dq.add(ball[i]);
		}

		int oidx = 0;
		int aidx = 0;
		int F = -1; // 0앞, 1뒤, -1추가
		
		while (!dq.isEmpty()) {
			int first = dq.getFirst();
			int last = dq.getLast();
			
			if(F == 0) {
				while(true) {
					first = dq.getFirst();
					
					if (list[first] == 1) {
						list[first]--;
						ans[aidx++] = first;
						dq.removeFirst();
					}else {
						break;
					}
					
				}
			}else if(F == 1) {
				while(true) {
					last = dq.getLast();

					if (list[last] == 1) {
						list[last]--;
						ans[aidx++] = last;
						dq.removeLast();
					}else {
						break;
					}
				}
			}
			
			if(oidx < order.length) {
				int next = order[oidx++];
				
				if (next == first) {
					dq.removeFirst();
					ans[aidx++] = first;
					F = 0;
				} else if (next == last) {
					dq.removeLast();
					ans[aidx++] = last;
					F = 1;
				} else {
					list[next]++;
					F = -1;
				}
			}
		}
		
		return ans;
	}
}
