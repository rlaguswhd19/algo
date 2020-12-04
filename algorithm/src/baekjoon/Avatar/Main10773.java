package baekjoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				st.pop();
			}else {
				st.push(num);
			}
		}
		
		int sum = 0;
		while(!st.isEmpty()) {
			sum += st.pop();
		}
		
		System.out.println(sum);
	}
}
