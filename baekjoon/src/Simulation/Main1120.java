package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1120 {
	static String a, b;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = st.nextToken();
		b = st.nextToken();
		ans = Integer.MAX_VALUE;
		
		char[] al = a.toCharArray();
		char[] bl = b.toCharArray();
		for (int i = 0; i <= bl.length-al.length; i++) {
			int sum = 0;
			for (int j = 0; j < al.length; j++) {
				char A = al[j];
				char B = bl[i+j];
				
				if(A != B) {
					sum++;
				}
			}
			ans = Math.min(ans, sum);
		}
		
		System.out.println(ans);
	}
}
