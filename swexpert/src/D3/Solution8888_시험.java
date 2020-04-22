package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution8888_시험 {
	static ArrayList<Integer>[] user; // 문제를 맞힌 갯수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			user = new ArrayList[N + 1];
			int[] ques = new int[T + 1];

			for (int i = 1; i < N + 1; i++) {
				user[i] = new ArrayList<>();
			}

			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 1; j < T + 1; j++) {
					int num = Integer.parseInt(st.nextToken());

					if (num == 1) { // i가 맞은 갯수
						user[i].add(j);
					} else {
						ques[j]++;
					}
				}
			}

//			for (int i = 1; i < N+1; i++) {
//				System.out.println(user[i]);
//			}
//			System.out.println(Arrays.toString(ques));

			int sum = 0;
			
			for (int i = 0; i < user[P].size(); i++) {
				sum += ques[user[P].get(i)];
			}
			
			int Pscore = sum;
			int size = user[P].size();
			int ans = 0;

			for (int i = 1; i < N + 1; i++) {
				if (i == P) {
					continue;
				}

				sum = 0;

				for (int j = 0; j < user[i].size(); j++) {
					int testnum = user[i].get(j);
					sum += ques[testnum];
				}

				if (Pscore < sum) {
					ans++;
				} else if (Pscore == sum) { // 자신과 점수가 같은 애들
					if (size < user[i].size()) { // 자신보다 많이 푼 애들
						ans++;
					} else if (size == user[i].size()) {
						if (P > i) {
							ans++;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + Pscore + " " + (ans + 1));

		}
	}
}
