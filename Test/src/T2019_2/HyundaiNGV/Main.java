package T2019_2.HyundaiNGV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static String ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ans = "0";
		
		String s = br.readLine();
		
		for (int i = 0; i <= n-k; i++) {
			long num = Long.parseLong(s.substring(i, i+k));
			ans = ""+Math.max(num, Long.parseLong(ans));
		}
		
		int[] list = new int[k];
		
		for (int i = 0; i < ans.length(); i++) {
			list[i] = ans.charAt(i)-'0';
		}
		
		
		boolean zero = false;
		for (int i = 0; i < list.length; i++) {
			if(list[i] != 0) {
				zero = true;
			}
			
			if(zero) {
				System.out.print(list[i]);
			}
		}
		
	}
}
