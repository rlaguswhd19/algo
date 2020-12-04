package baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2455 {
	static int ans, sum, minus, plus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		ans = 0;
		sum = 0;
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			minus = Integer.parseInt(st.nextToken());
			plus = Integer.parseInt(st.nextToken());
			
			sum -= minus;
			sum += plus;
			
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}
}
