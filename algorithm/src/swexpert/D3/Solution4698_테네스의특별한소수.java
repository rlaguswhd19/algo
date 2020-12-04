package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4698_테네스의특별한소수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[1000001];
		arr[1] = 2;
		
		for (int i = 2; i < 1000001; i++) {
			if(arr[i] == 0) {
				arr[i] = 1;
			}
			
			for (int j = i+i; j < 1000001; j+=i) {
				arr[j] = 2;
			}
		}
		
		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for (int i = A; i <= B; i++) {
				String s = ""+i;
				
				for (int j = 0; j < s.length(); j++) {
					int num = s.charAt(j)-'0';
					if(num == D) {
						
						// 숫자가 소수이면 +
						if(arr[i] == 1) {
							ans++;
						}
						
						break;
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
