package programmers.DFS_BFS;

import java.util.ArrayList;

public class level2_타겟넘버{
	static int[] number = {1,2,3,4,5};
	static int target = 3;
	static ArrayList<Integer> arr;
	static int cnt;
	public static void main(String[] args) {
		cnt = 0;
		dfs(0, 0);
		System.out.println(cnt);
	}
	static void dfs(int index, int num) {
		if(index == 5) {
			System.out.println(num);
			if(num == target) {
				cnt++;
			}
			return;
		}
		dfs(index+1, num+number[index]);
		dfs(index+1, num-number[index]);
	}
}
