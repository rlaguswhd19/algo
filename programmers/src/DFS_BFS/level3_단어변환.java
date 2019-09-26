package DFS_BFS;

import java.util.ArrayList;

public class level3_단어변환 {
	static String begin = "hit";
	static String target = "cog";
	static String[] words = {"hot", "dot", "dog", "lot", "log","cog"};
	static int ans;
	static int same;
	static ArrayList<String> arr;
	public static void main(String[] args) {
		ans = Integer.MAX_VALUE;
		arr = new ArrayList<>();
		for (int i = 0; i < begin.length(); i++) {
			if(begin.charAt(i) == target.charAt(i)) {
				same++;
			}
		}
		System.out.println(same);
		for (int i = 0; i < words.length; i++) {
			arr.add(words[i]);
		}
		dfs(0, begin, target, arr);
		System.out.println(ans);
	}
	static void dfs(int cnt, String begin, String target, ArrayList<String> arr) {
		System.out.println(arr);
		System.out.println(begin);
		
		if(begin.equals(target)) {
			ans = Math.min(ans, cnt);
			return;
		}
		ArrayList<String> temp = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			int count = 0;
			for (int j = 0; j < begin.length(); j++) { //1개가 다른지 아닌지 파악하기
				if(begin.charAt(j) != arr.get(i).charAt(j)) {
					count++;
				}
			}
			if(count == 1) {
				temp.add(arr.get(i));
			}
		}
		System.out.println(temp);
		System.out.println();
		for (int i = 0; i < temp.size(); i++) {
			if(check(temp.get(i), target)) {
				arr.remove(temp.get(i));
				dfs(cnt+1, temp.get(i), target, arr);
			}
		}
	}
	static boolean check(String temp, String target) {
		int count = 0;
		for (int i = 0; i < temp.length(); i++) {
			if(temp.charAt(i) == target.charAt(i)) {
				count++;
			}
		}
		if(count >= same) {
			same = count;
			return true;
		}else {
			return false;
		}
	}
}
