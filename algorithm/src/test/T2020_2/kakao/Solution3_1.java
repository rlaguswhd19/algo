package test.T2020_2.kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution3_1 {
	static String[] list, arr;
	static HashSet<Integer>[] setArr;

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
		setArr = new HashSet[9]; // 0: cpp, 1: java, 2: python, 3: back, 4: front, 5: junior, 6: senior, 7: ch,
									// 8: pi
		for (int i = 0; i < setArr.length; i++) {
			setArr[i] = new HashSet<Integer>();
		}

		for (int i = 0; i < info.length; i++) {
			arr = info[i].split(" ");
			score[i] = Integer.parseInt(arr[4]);
//			System.out.println(Arrays.toString(arr));

			// 언어
			if (arr[0].equals("cpp")) {
				setArr[0].add(i);
			} else if (arr[0].equals("java")) {
				setArr[1].add(i);
			} else {
				setArr[2].add(i);
			}

			// 직군
			if (arr[1].equals("backend")) {
				setArr[3].add(i);
			} else {
				setArr[4].add(i);
			}

			// 경력
			if (arr[2].equals("junior")) {
				setArr[5].add(i);
			} else {
				setArr[6].add(i);
			}

			// 음식
			if (arr[3].equals("chicken")) {
				setArr[7].add(i);
			} else {
				setArr[8].add(i);
			}
		}

//		System.out.println();

		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replace("and ", "");
			arr = query[i].split(" ");
//			System.out.println(Arrays.toString(arr));
			int checkScore = Integer.parseInt(arr[4]);
			
			HashSet<Integer>[] ansSet = new HashSet[4];

			if (arr[0].equals("cpp")) {
				ansSet[0] = setArr[0];
			} else if (arr[0].equals("java")) {
				ansSet[0] = setArr[1];
			} else if (arr[0].equals("python")) {
				ansSet[0] = setArr[2];
			}

			// 직군
			if (arr[1].equals("backend")) {
				ansSet[1] = setArr[3];
			} else if (arr[1].equals("frontend")) {
				ansSet[1] = setArr[4];
			}

			// 경력
			if (arr[2].equals("junior")) {
				ansSet[2] = setArr[5];
			} else if (arr[2].equals("senior")) {
				ansSet[2] = setArr[6];
			}

			// 음식
			if (arr[3].equals("chicken")) {
				ansSet[3] = setArr[7];
			} else if (arr[3].equals("pizza")) {
				ansSet[3] = setArr[8];
			}
			
			int idx = -1;
			for (int j = 0; j < ansSet.length; j++) {
				HashSet<Integer> temp = ansSet[j];
				if(temp == null) {
					continue;
				}
				
				idx = j;
				break;
			}
			int cnt = 0;
			if(idx == -1) { // 모든 사람
				for (int j = 0; j < score.length; j++) {
					if(score[j] >= checkScore) {
						cnt++;
					}
				}
			}else {
				HashSet<Integer> start = ansSet[idx];
				
				for (int j = idx + 1; j < ansSet.length; j++) {
					if(ansSet[j] == null) {
						continue;
					}
					
					start.retainAll(ansSet[j]);
				}
				
				System.out.println(start);
				Iterator<Integer> it = start.iterator();
				while(it.hasNext()) {
					int num = it.next();
					if(score[num] >= checkScore) {
						cnt++;
					}
				}
				
			}
			
			ans[i] = cnt;
		}
		
		return ans;
	}
}
