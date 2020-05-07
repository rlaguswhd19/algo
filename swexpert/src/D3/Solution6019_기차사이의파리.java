package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6019_기차사이의파리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			double d = Double.parseDouble(st.nextToken());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			double f = Double.parseDouble(st.nextToken());
			double ans = 0;

			double time = d / (a+b);
			
			ans = f * time;
			
			System.out.print("#" + tc + " ");
			System.out.printf("%.10f", ans);
		}
	}
}
