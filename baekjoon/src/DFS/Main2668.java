package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2668 {
	static int[] arr;
	static boolean[] visit;
	static boolean isOk;
	static int first;
	static ArrayList<Integer> list;
	static ArrayList<Integer> ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n+1];
		ans = new ArrayList<>();
		visit = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= n; i++) {
			first = i;
			list = new ArrayList<>();
			isOk = false;
			if(!visit[i]) {
				dfs(i);
			}
			if(isOk) {
				for (int j = 0; j < list.size(); j++) {
					visit[list.get(j)] = true;
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	
	static void dfs(int i) {
		list.add(i);
		visit[i] = true;
		
		// 사이클이 완성되면
		if(arr[i] == first) {
			isOk = true;
			for (int j = 0; j < list.size(); j++) {	
				ans.add(list.get(j));
			}
			return;
		}
		
		if(!visit[arr[i]]) {
			dfs(arr[i]);
		}
		visit[i] = false;
	}
}
