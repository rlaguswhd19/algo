package Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class solution_3 {
	static int[] visit;
	static int cnt, distance;
	static ArrayList<int[]> ans;
	static String[] arr;

	public static void main(String[] args) {
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		HashMap<String, Integer> map = new HashMap<>(); // 인덱스 뽑기용

		int idx = 0;
		for (int i = 0; i < gems.length; i++) {
			if (!map.containsKey(gems[i])) {
				arr[idx] = gems[i]; // 나중에 가장 작은 보석 뽑기용
				map.put(gems[i], idx++);
			}
		}

//		보석갯수
		cnt = map.size(); // 보석 갯수
		visit = new int[cnt]; // 보석들의 현재 인덱스
		
		// 보석 카운트할것
		int count = 0;

		// -1로 채우기 아직 안삿다...
		Arrays.fill(visit, -1);

		String MinGem = "";

		for (int i = 0; i < gems.length; i++) {
			String gem = gems[i]; // 보석
			idx = map.get(gem); // 보석의 인덱스

			// 다찾은 상태고 이번 보석이 가장 작은 보석이면
			if (count == 4) {
				System.out.println(MinGem);
			}

			if (visit[idx] == -1) { // 아직 안삿으면
				count++;
			} else {
				MinGem = gem;
			}

			visit[idx] = i; // 보석의 인덱스는 계속 변함
		}
	}

	static class Point {
		int min, max;

		public Point(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Point [min=" + min + ", max=" + max + "]";
		}
	}
}
