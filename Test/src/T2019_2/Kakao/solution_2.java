package T2019_2.Kakao;

import java.util.ArrayList;
import java.util.Arrays;

public class solution_2 {
	static char[] arr = { '+', '-', '*' };
	static char[] list = new char[3];
	static boolean[] visit = new boolean[3];
	static int[] parent;
	static int size;
	
	public static void main(String[] args) {
		long answer = 0;
		String expression = "100-200*300-500+20";
		
		String[] temp = expression.split("[-,*,+]");
		size = temp.length;
		
		per(0, expression);
		
	}
	
	static void cal(char operator, String expression) {
		
	}
	
	static void per(int idx, String expression) {
		if (idx == 3) {
			System.out.println(Arrays.toString(list));
			
			parent = new int[size];
			for (int i = 0; i < list.length; i++) {
				cal(list[i], expression);
			}
			
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (!visit[i]) {
				list[idx] = arr[i];
				visit[i] = true;
				per(idx + 1, expression);
				visit[i] = false;
			}
		}
	}
}
