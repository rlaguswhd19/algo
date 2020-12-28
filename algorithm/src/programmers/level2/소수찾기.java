package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
	static Set<Integer> set;
	static boolean[] visit;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(solution(numbers));
	}

	static int solution(String numbers) {
		set = new HashSet<Integer>();
		visit = new boolean[numbers.length()];
		arr = new int[numbers.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = numbers.charAt(i) - '0';
		}

		sb = new StringBuilder();

		per();
		
		for(int num : set) {
			System.out.println(num);
		}
		
		return set.size();
	}

	static void per() {
		int num;
		if(sb.length() == arr.length) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visit[i]) {
				continue;
			}

			visit[i] = true;
			sb.append(arr[i]);

			num = Integer.parseInt(sb.toString());
			check(num);
			per();
			sb.deleteCharAt(sb.length() - 1);
			visit[i] = false;
		}
	}

	static void check(int num) {
		if(num < 2) {
			return;
		}
		
		int temp = (int) Math.pow(num, 0.5);
		for (int i = 2; i <= temp; i++) {
			if (num % i == 0) {
				return;
			}
		}

		set.add(num);
	}
}
