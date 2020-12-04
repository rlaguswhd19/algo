package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main14888 {
	static int[] number;
	static int[] operator;
	static int n;
	static char[] arr = { '+', '-', '*', '/' };
	static long min, max;
	static ArrayList<Character> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		number = new int[n];
		operator = new int[4];
		list = new ArrayList<>();
		min = Long.MAX_VALUE;
		max = Long.MAX_VALUE * -1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		per();
		System.out.println(max);
		System.out.println(min);
	}

	static void calculation() {
		int index = 0;
		long cal = number[index];

		for (int i = 0; i < n - 1; i++) {
			index++;
			if (list.get(i) == '+') {
				cal += number[index];
			} else if (list.get(i) == '-') {
				cal -= number[index];
			} else if (list.get(i) == '*') {
				cal *= number[index];
			} else {
				if (cal < 0) {
					cal = Math.abs(cal);
					cal /= number[index];
					cal *= -1;
				} else {
					cal /= number[index];
				}
			}
		}

		min = Math.min(cal, min);
		max = Math.max(cal, max);
	}

	static void per() {
		if (list.size() == n - 1) {
			calculation();
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] == 0) {
				continue;
			} else {
				operator[i]--;
				list.add(arr[i]);
				per();
				list.remove(list.size() - 1);
				operator[i]++;
			}
		}
	}
}
