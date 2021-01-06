package programmers.level3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 외벽점검 {
	static boolean[] visit;
	static int[] arr;
	static boolean isOk;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int n = 12;
		int[] weak = { 1, 5, 6, 10 };
		int[] dist = { 1, 2, 3, 4 };
		System.out.println(solution(n, weak, dist));
	}

	static int solution(int n, int[] weak, int[] dist) {
		List<Integer> list = Arrays.stream(weak).boxed().collect(Collectors.toList());

		for (int i = 0; i < list.size(); i++) {
			arr = new int[dist.length];
			isOk = false;
			visit = new boolean[dist.length];

			for (int j = 1; j <= dist.length; j++) {
				if (min <= j) {
					break;
				}

				per(0, j, dist, list);
			}

			list.add(list.remove(0) + n);
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}

	static void per(int idx, int p, int[] dist, List<Integer> list) {
		if (isOk) {
			return;
		}

		if (idx == p) {

			int w, d, index = 0;
			w = list.get(0);
			d = arr[index] + w;
			boolean check = true;
			
			for (int i = 1; i < list.size(); i++) {
				w = list.get(i);
				
				if (w > d) {
					if (++index == p) {
						check = false;
						break;
					}

					d = arr[index] + w;
				}
			}

			if (check) {
				min = p;
				isOk = true;
			}

			return;
		}

		for (int i = dist.length - 1; i >= dist.length - 1 - p; i--) {
			if (visit[i]) {
				continue;
			}

			visit[i] = true;
			arr[idx] = dist[i];
			per(idx + 1, p, dist, list);
			visit[i] = false;
		}
	}
}
