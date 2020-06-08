package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution1244_2일차최대상금 {
	static char[] arr;
	static int ans;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = st.nextToken().toCharArray();
			int cnt = Integer.parseInt(st.nextToken());
			ans = 0;
			set.clear();

			dfs(cnt);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int cnt) {
		int num = changeNum();

		if (set.contains(num * 10 + cnt)) {
			return;
		} else {
			set.add(num * 10 + cnt);
		}

		if (cnt == 0) {
			ans = Math.max(num, ans);
			return;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				swap(i, j);
				dfs(cnt - 1);
				swap(j, i);
			}
		}
	}
	
	
	static void swap(int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int changeNum() {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] - '0';
			sum *= 10;
		}

		return sum / 10;
	}
}
