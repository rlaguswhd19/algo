package test.T2020_2.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] visit = new boolean[46];
		int temp = 0;
		boolean ans = true;
		
		if(st.countTokens() == 6) {
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num > 45) {
					ans = false;
					break;
				}
				
				// 나왔던 숫자인지 검사하기
				if(visit[num]) {
					ans = false;
					break;
				}
				
				// 전꺼보다 작은지 검사하기
				if(temp > num) {
					ans = false;
					break;
				}
				
				visit[num] = true;
				temp = num;
			}
		}else {
			ans = false;
		}
		
		System.out.println(ans);
	}
}
