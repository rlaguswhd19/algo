package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14889 {
	static int n;
	static int[][] map;
	static boolean[] visit;
	static int[] start, link;
	static int ans = Integer.MAX_VALUE;
	static int[] result;
	static int lsum, ssum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		start = new int[n / 2];
		link = new int[n / 2];

		StringTokenizer st;

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		com(1, 0);

		System.out.println(ans);
	}

	static void com(int target, int cnt) {
		if (cnt == n / 2) {
			sum();
			return;
		} else if (target == n + 1) {
			return;
		} else {
			start[cnt] = target;
			com(target + 1, cnt + 1);
			com(target + 1, cnt);
		}
	}

	static void scom(int target, int cnt, int[] arr) {
		if (cnt == 2) {
			ssum += map[result[0]][result[1]] + map[result[1]][result[0]];
			return;
		} else if (target == start.length) {
			return;
		} else {
			result[cnt] = arr[target];
			scom(target + 1, cnt + 1, arr);
			scom(target + 1, cnt, arr);
		}
	}
	
	static void lcom(int target, int cnt, int[] arr) {
		if (cnt == 2) {
			lsum += map[result[0]][result[1]] + map[result[1]][result[0]];
			return;
		} else if (target == start.length) {
			return;
		} else {
			result[cnt] = arr[target];
			lcom(target + 1, cnt + 1, arr);
			lcom(target + 1, cnt, arr);
		}
	}

	static void sum() {
		visit = new boolean[n + 1];
		ssum = 0;
		lsum = 0;
		result = new int[2];
		for (int i = 0; i < start.length; i++) {
			visit[start[i]] = true;
		}

		int cnt = 0;

		for (int i = 1; i < visit.length; i++) {
			if (!visit[i]) {
				link[cnt++] = i;
			}
		}
		
		scom(0,0,start);
		lcom(0,0,link);
		
		ans = Math.min(ans, Math.abs(ssum - lsum));
	}
}
