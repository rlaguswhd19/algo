package T2020_2.kakao;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution3 {
	static String[] list, arr;
	static HashMap<String, ArrayList<Integer>> map;
	static int person;

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		solution(info, query);
	}

	static int[] solution(String[] info, String[] query) {
		int[] score = new int[info.length];
		list = new String[4];
		int[] ans = new int[info.length];
		
		map = new HashMap<String, ArrayList<Integer>>();

		for (int i = 0; i < info.length; i++) {
			arr = info[i].split(" ");
//			System.out.println(Arrays.toString(arr));
			score[i] = Integer.parseInt(arr[4]);
			person = i;
			com(0, 0);
		}

		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replace("and ", "");
			String[] list = query[i].split(" ");
//			System.out.println(Arrays.toString(list));
			int checkScore = Integer.parseInt(list[4]);

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < list.length - 1; j++) {
				if (list[j].equals("-")) {
					continue;
				}

				sb.append(list[j] + " ");
			}

//			System.out.println(sb.toString()); // 조건
			int cnt = 0; // 사람수
			
			if (sb.toString().equals("")) { //조건이 없을시 모든사람 검사
				for (int j = 0; j < score.length; j++) {
					if(score[j] >= checkScore) {
						cnt++;
					}
				}
			} else { // 조건이 있으면 그사람들의 경우를 뽑아서
				ArrayList<Integer> arr = map.get(sb.toString());

				for (int j = 0; j < arr.size(); j++) {
					int pi = arr.get(j); // 사람 인덱스

					if (score[pi] >= checkScore) { // 점수 비교
						cnt++;
					}
				}
			}
			
			ans[i] = cnt;
		}

		return ans;
	}

	static void com(int cnt, int idx) {
		if (cnt == 4) {
			return;
		} else if (idx == arr.length - 1) {
			return;
		} else {
			list[cnt] = arr[idx];

//			System.out.println(Arrays.toString(list));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= cnt; i++) {
				sb.append(list[i] + " ");
			}

			String s = sb.toString();
			ArrayList<Integer> temp;
			if (map.containsKey(s)) {
				temp = map.get(s);
				temp.add(person);
				map.put(s, temp);
			} else {
				temp = new ArrayList<>();
				temp.add(person);
				map.put(s, temp);
			}

			com(cnt + 1, idx + 1);
			com(cnt, idx + 1);
		}
	}
}
