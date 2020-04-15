package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9317_석찬이의받아쓰기 {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			String s1 = br.readLine();
			String s2 = br.readLine();
			int ans = 0;
			
			for (int i = 0; i < n; i++) {
				if(s1.charAt(i) == s2.charAt(i)) {
					ans++;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
