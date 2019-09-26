package 완전탐색;

import java.util.ArrayList;
import java.util.Arrays;

public class level2_카펫 {
	static int brown = 24;
	static int red = 24;
	static int[] answer;
	static int num;
	public static void main(String[] args) {
		num = brown + red;
		answer = new int[2];
		set();
		System.out.println(Arrays.toString(answer));
	}
	static void set() {
		for (int i = 1; i < num/2; i++) {
			if(num % i == 0) {
				int n1 = num/i;
				int n2 = i;
				if(brown == 2*n1+2*(n2-2)) {
					answer[0] = Math.max(n1, n2);
					answer[1] = Math.min(n1,n2);
					return;
				}
			}
		}
	}
}
