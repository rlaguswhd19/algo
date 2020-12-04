package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution8931_제로 {
	static Stack<Integer> stack;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(br.readLine());
			stack = new Stack<Integer>();
			ans = 0;
			
			for (int i = 0; i < k; i++) {
				int num = Integer.parseInt(br.readLine());
				
				if(num == 0) {
					stack.pop();
				}else {
					stack.add(num);
				}
			}
			
			while(!stack.isEmpty()) {
				ans += stack.pop();
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
