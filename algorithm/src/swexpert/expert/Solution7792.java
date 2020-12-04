package swexpert.expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution7792 {
	static char[] array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				array = s.toCharArray();
				System.out.println(Arrays.toString(array));
				Check();
			}
		}
	}
	static void Check() {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			
		}
	}
	static class NAME{
		String name;
		int count;
		
		public NAME(String name, int count) {
			super();
			this.name = name;
			this.count = count;
		}
		
		@Override
		public String toString() {
			return "NAME [name=" + name + ", count=" + count + "]";
		}
	}
}
