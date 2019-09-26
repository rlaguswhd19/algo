package 완전탐색;

import java.util.ArrayList;

public class level2_숫자야구{
	static int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
	static ArrayList<Integer> arr;
	static boolean isOk;
	static ArrayList<String> result;
	static boolean[] visit;
	public static void main(String[] args) {
		arr = new ArrayList<>();
		result = new ArrayList<>();
		visit = new boolean[10];
		search();
		System.out.println(result);
	}

	static void search() {
		if (arr.size() == 3) {
			String s = "";
			for (int i = 0; i < arr.size(); i++) {
				s+=arr.get(i)+"";
			}
			check(s);
			return;
		}
		for (int i = 1; i < 10; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr.add(i);
				search();
				visit[i] = false;
				arr.remove(arr.size() - 1);
			}
		}
	}
	static void check(String s1) {
		int cnt = 0;
		for (int i = 0; i < baseball.length; i++) {
			isOk = false;
			String s2 = baseball[i][0]+"";
			check2(s1, s2, baseball[i][1], baseball[i][2]);
			if(!isOk) {
				return;
			}
			cnt++;
		}
		if(cnt == baseball.length) {
			result.add(s1);
		}
	}
	static void check2(String s1, String s2, int s, int b) {
		int str = 0;
		int ball = 0;
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					if(i == j) {
						str++;
					}
					else {
						ball++;
					}
				}
			}
		}
		if(str == s) {
			count++;
		}
		if(ball == b) {
			count++;
		}
		if(count == 2) {
			isOk = true;
		}
	}
}
