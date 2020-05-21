package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3314_보충학습과평균 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int ans = 0;
			
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num < 40) {
					ans += 40;
				}else {
					ans += num;
				}
			}
			
			System.out.println("#"+tc+" "+ans/5);
		}
	}
}
