package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1057 {
	static int n, K, I, ans;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		I = Integer.parseInt(st.nextToken());
		ans = -1;
		arr = new ArrayList<>();
		for (int i = 1; i < n + 1; i++) {
			arr.add(i);
		}
		System.out.println(ans);
		dfs(1);
	}

	static void dfs(int cnt) {

		ArrayList<Integer> remove = new ArrayList<>();

		for (int i = 2; i < arr.size(); i += 2) { // 짝수들을 지운다.
			if (i == K || i == I) {
				remove.add(i + 1);
				continue;
			} else {
				remove.add(i);
			}
		}
	}
}
