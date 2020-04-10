package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main5397 {
	static int n;
	static char[] arr;
	static Stack<Character> s1, s2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			arr = s.toCharArray();
			s1 = new Stack<>();
			s2 = new Stack<>();

			for (int j = 0; j < arr.length; j++) {
				char c = arr[j];
				if (c == '<') {
					if (!s1.isEmpty()) {
						s2.add(s1.pop());
					}
				} else if (c == '>') {
					if (!s2.isEmpty()) {
						s1.add(s2.pop());
					}
				} else if (c == '-') {
					if (!s1.isEmpty()) {
						s1.pop();
					}
				} else {
					s1.add(c);
				}
			}
			
			while(!s1.isEmpty()) {
				s2.add(s1.pop());
			}
			
			StringBuilder sb = new StringBuilder();
			while(!s2.isEmpty()) {
				sb.append(s2.pop());
			}
			
			System.out.println(sb);
		}

	}
}
