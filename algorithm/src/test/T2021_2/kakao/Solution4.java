package test.T2021_2.kakao;

import java.util.Arrays;

public class Solution4 {
	static int[] ryan = new int[11];
	static int[] ans = new int[11];
	static int rs, as, max = 0;

	public static void main(String[] args) {
		int n = 9;
		int[] info = {0,0,1,2,0,1,1,1,1,1,1};
		solution(n, info);
	}

	static int[] solution(int n, int[] info) {
		com(0, n, info);

		if (max == 0) {
			ans = new int[1];
			ans[0] = -1;
		}
		
		System.out.println(Arrays.toString(ans));
		return ans;
	}

	static void com(int idx, int n, int[] info) {
		if (idx == 11 || n == 0) {
			rs = 0;
			as = 0;

			for (int i = 0; i < info.length - 1; i++) {
				if (info[i] < ryan[i]) {
					rs += 10 - i;
				} else {
					if(info[i] == 0 && ryan[i] == 0) {
						continue;
					}
					
					as += 10 - i;
				} 
			}
			
			
			if (max <= rs - as) {
				if(n != 0) {
					ryan[10] += n;
				}
				
				
				if(max < rs - as) {
					ans = ryan.clone();
				}else if(max == rs - as) {
					int temp_idx = 10;
					while(temp_idx > 0) {
						if(ryan[temp_idx] > ans[temp_idx]) {
							ans = ryan.clone();
							break;
						}else if(ryan[temp_idx] < ans[temp_idx]){
							break;
						}
						
						temp_idx--;
					}
				}
				max = rs - as;
			}
			return;
		}

		com(idx + 1, n, info);
		
		// 선택할 경우
		if (n - (info[idx] + 1) >= 0) {
			ryan[idx] = info[idx] + 1;
			n -= info[idx] + 1;
			com(idx + 1, n, info);
		}


		// 다시 되돌리기
		ryan[idx] = 0;
	}
}
