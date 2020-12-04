package baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main1094 {
	static int x, sum;
	static ArrayList<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		x = Integer.parseInt(br.readLine());
		sum = 64;
		arr.add(64);

		dfs(0);
	}

	static void dfs(int cnt) {
		if (sum == x) {
			System.out.println(arr.size());
			return;
		}

		// 가장 짧은것
		int num = arr.get(arr.size() - 1);

		num = num / 2;

		if (sum - num >= x) { // 크거나 같으면 남은거 버린다.
			arr.set(arr.size() - 1, num);
			sum -= num;
		} else { // 남은거를 안버리고 가지고 간다.
			arr.set(arr.size() - 1, num);
			arr.add(num);
		}
		
		dfs(cnt+1);
	}
}
