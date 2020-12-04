package baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1021 {
	static int n, m;
	static ArrayList<Integer> q;
	static int[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = new ArrayList<>();
		list = new int[m];
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0, dir(0));
	}

	static void dfs(int index, int cnt, boolean left) {

		int num = 0;

		// 숫자가 일치하여 뽑을경우
		num = q.get(0);
		if (num == list[index]) {
			q.remove(0);
			if(index+1 == m) {
				System.out.println(cnt);
				return;
			}
			
			dfs(index + 1, cnt, dir(index+1));
		} else {
			// 왼쪽으로 갈경우
			if(left) {
				q.add(num);
				q.remove(0);
				dfs(index, cnt + 1, dir(index));
				q.add(0, num);
				q.remove(q.size() - 1);
			}else {
				// 오른쪽으로 갈경우
				num = q.get(q.size() - 1);
				q.add(0, num);
				q.remove(q.size() - 1);
				dfs(index, cnt + 1, dir(index));
				q.add(num);
				q.remove(0);
			}
		}
	}
	
	static boolean dir(int index) {
		int temp = 0;
		for (int i = 0; i < q.size(); i++) {
			if(q.get(i) == list[index]) {
				temp = i;
				break;
			}
		}
		if(temp > q.size()-temp) {
			return false; // 오른쪽
		}else {
			return true; // 왼쪽
		}
	}
}
