package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8741_두문자어 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			System.out.print("#"+tc+" ");
			while(st.hasMoreTokens()) {
				String next = st.nextToken();
				
				System.out.print((char)(next.charAt(0)-32));
			}
			System.out.println();
		}
	}
}
