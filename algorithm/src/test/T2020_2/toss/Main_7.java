package test.T2020_2.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7 {
	static int[] arr1, arr2;
	static int idx, ad;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String s = st.nextToken().replaceAll(";", "");
		int num = Integer.parseInt(s);
		arr1 = new int[8];
		arr2 = new int[8];
		int cnt = 0;
		ad = 2;
		while (st.hasMoreTokens()) {
			arr1[cnt++] = Integer.parseInt(st.nextToken());
		}

		dfs(num);

		System.out.print("0; ");
		for (int i = 0; i < 8; i++) {
			System.out.print(i == 7 ? arr2[i] : arr2[i] + " ");
		}
	}

	static void dfs(int now) {
		int num = arr1[now];

		arr2[idx++] = num;

		if (num == 0) {
			arr2[idx++] = ad;
			ad += 2;
			dfs(arr1[now + 1]);
		} else {
			arr2[idx++] = arr1[now + 1];
		}
	}
}
