package programmers.완전탐색;

import java.util.*;

public class level2_소수찾기 {
	static String numbers = "011";
	static int[] nums;
	static ArrayList<Integer> arr;
	static boolean[] visit;
	static HashSet<Integer> set;
	public static void main(String[] args) {
		nums = new int[numbers.length()];
		arr = new ArrayList<>();
		set = new HashSet<>();
		visit = new boolean[numbers.length()];
		Set();
		per();
		System.out.println(set.size());
	}
	
	static void Set() {
		for (int i = 0; i < numbers.length(); i++) {
			nums[i] = numbers.charAt(i)-'0';
		}
	}
	static void per() {
		if(arr.size()>0) {
			String num = "";
			for (int i = 0; i < arr.size(); i++) {
				num += arr.get(i)+"";
			}
			if(Integer.parseInt(num) > 1 && !set.contains(Integer.parseInt(num))) {
				check(Integer.parseInt(num));
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr.add(nums[i]);
				per();
				arr.remove(arr.size()-1);
				visit[i] = false;
			}
		}
	}
	static void check(int num) {
		int temp = (int)Math.pow(num, 0.5);
		int count = 0;
		for (int i = 2; i <= temp; i++) {
			if(num%i == 0) {
				count++;
			}
		}
		if(count == 0) {
			set.add(num);
		}
	}
}
