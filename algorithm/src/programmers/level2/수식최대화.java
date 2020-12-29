package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;

public class 수식최대화 {
	static boolean[] visit = new boolean[3];
	static char[] list = new char[3];
	static char[] arr = { '-', '+', '*' };
	static long ans;

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));
	}

	static long solution(String expression) {
		ans = 0;
		char temp;
		LinkedList<String> numbers = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			temp = expression.charAt(i);

			if (temp <= 45) {
				numbers.add(sb.toString());
				sb = new StringBuilder();
				numbers.add(Character.toString(temp));
			} else {
				sb.append(temp);
			}
		}
		numbers.add(sb.toString());

		per(0, numbers);
		return ans;
	}

	static void per(int idx, LinkedList<String> numbers) {
		if (idx == list.length) {
			ArrayList<String> copy = new ArrayList<>();
			for (int j = 0; j < numbers.size(); j++) {
				copy.add(numbers.get(j));
			}

			long num1, num2, res;
			for (int i = 0; i < list.length; i++) {
				char temp = list[i];
				for (int j = 0; j < copy.size(); j++) {

					if (temp == copy.get(j).charAt(0)) {
						num1 = Long.parseLong(copy.get(j - 1));
						num2 = Long.parseLong(copy.get(j + 1));

						if (temp == '-') {
							res = num1 - num2;
						} else if (temp == '+') {
							res = num1 + num2;
						} else {
							res = num1 * num2;
						}

						copy.remove(j - 1);
						copy.remove(j - 1);
						copy.remove(j - 1);
						copy.add(j - 1, Long.toString(res));
						j--;
					}
				}
			}
			
			ans = Math.max(ans, Math.abs(Long.parseLong(copy.get(0))));
		}

		for (int i = 0; i < arr.length; i++) {
			if (visit[i]) {
				continue;
			}

			visit[i] = true;
			list[idx] = arr[i];
			per(idx + 1, numbers);
			visit[i] = false;
		}
	}
}
