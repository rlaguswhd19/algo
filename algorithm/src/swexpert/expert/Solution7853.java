package swexpert.expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution7853 {
	static char[] array;
	static long result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String n = br.readLine();
			array = n.toCharArray();
			result = 1;
			
			start();
			System.out.println("#"+tc+" "+result);
		}
	}
	static void start() {
		for (int i = 0; i < array.length; i++) {
			check(i);
		}
	}
	static void check(int i) {
		Set<Character> set = new HashSet<>();
		for (int j = -1; j <= 1; j++) {
			if(i+j >= 0 && i+j < array.length) {
				set.add(array[i+j]);
			}
		}
		result = result*set.size();
		result = result % 1000000007;
	}
}
