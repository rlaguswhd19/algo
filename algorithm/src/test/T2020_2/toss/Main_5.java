package test.T2020_2.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int size = st1.countTokens();
		int bank = 0;
		int ans = 0;

		for (int i = 0; i < size; i++) {
			int num1 = Integer.parseInt(st1.nextToken());
			int num2 = Integer.parseInt(st2.nextToken());
			
			ans = num1 - num2;
			
			if (ans < 0) {
				bank += ans;
				ans = 0;
			} else if (ans > 0) { // 돈을 줘야됌
				if (ans + bank < 0) { // 돈보다 더낼게 많으면 차감
					bank += ans;
					ans = 0;
				} else { // 돈이 더많으면 돈보내주기
					ans += bank;
					bank = 0;
				}
			}

			System.out.print(i == size - 1 ? ans : ans + " ");
//			System.out.println(bank);
		}
	}
}
