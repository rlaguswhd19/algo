package baekjoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

//		최대 팀?
		int max = Math.min(n / 2, m);
		
		//		거기에 남는 사람들?
		int women = n - max * 2;
		int men = m - max;
		k = k - (women + men);
		
		if (k <= 0) {
			System.out.println(max);
		} else {
			int ans = max - k/3;
			System.out.println(k % 3 == 0 ? ans : ans - 1);
		}
	}
}
