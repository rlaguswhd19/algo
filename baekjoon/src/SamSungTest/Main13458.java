package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13458 {
	static int n, b, c;
	static int[] room;
	static int[] number;
	static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ans = 0;
		n = Integer.parseInt(br.readLine());
		room = new int[n];
		number = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		check();
		
		System.out.println(ans);
	}

	static void check() {
		for (int i = 0; i < n; i++) {
			int num = room[i];
			
			if (number[num] == 0) {
				// 총 감독관 
				room[i] -= b;
				
				if (room[i] <= 0) {
					number[num]++; // 감독관 추가
				} else {
					number[num]++; // 감독관 추가
					
					int mok = room[i] / c;
					int nmg = room[i] % c;

					number[num] += mok;
					
					if (nmg > 0) {
						number[num]++;
					}
				}
				
				ans += number[num];
			} else {
				ans += number[num];
			}
		}
	}
}
