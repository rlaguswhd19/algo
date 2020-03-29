package EstSoft;

import java.util.Arrays;

public class Solution3 {
	static int[] A = {2,5,3,4,5};
	static int past, status, cnt, ans;
	public static void main(String[] args) {
		ans = 0;
		past = 0;
		status = 0;
		cnt = 0;
		
		for (int i = 0; i < A.length; i++) {
			if(i == 0) {
				past = A[i];
				continue;
			}
			
			if (past < A[i]) {
				// 전에것보다 컷는데 또크다?
				if (status == 1) {
					break;
					// status == -1
				} else {
					status = 1;
				}
				// 전에것보다 작아
			} else if (past > A[i]) {
				// 전에도 작았어
				if (status == -1) {
					break;
					// status == 1
				} else {
					status = -1;
				}
			} else { // 같으면?
				break;
			}
			
			past = A[i];
			cnt++;
		}
		
		if(cnt == A.length-1) {
			System.out.println(0);
		}else {
			for (int i = 0; i < A.length; i++) {
				int temp = A[i];
				A[i] = 0;
				
				past = 0; // 전 나무
				status = 0; // 전 상태
				cnt = 0;
				
				System.out.println(Arrays.toString(A));
				for (int j = 0; j < A.length; j++) {
					if (A[j] == 0) {
						continue;
					}
					// 첫 숫자를 넣는다.
					if (cnt == 0) {
						past = A[j];
						// 처음이 아니다.
					} else {
						if (past < A[j]) {
							// 전에것보다 컷는데 또크다?
							if (status == 1) {
								break;
								// status == -1
							} else {
								status = 1;
							}
							// 전에것보다 작아
						} else if (past > A[j]) {
							// 전에도 작았어
							if (status == -1) {
								break;
								// status == 1
							} else {
								status = -1;
							}
						} else { // 같으면?
							break;
						}
					}
					past = A[j];
					cnt++;
				}
				if (cnt == A.length - 1) {
					ans++;
				}
				
				A[i] = temp;
			}
			if (ans == 0) {
				System.out.println(-1);
			} else {
				System.out.println(ans);
			}
		}
	}
}
