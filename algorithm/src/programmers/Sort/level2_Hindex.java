package programmers.Sort;

import java.util.Arrays;

public class level2_Hindex {
	static int[] citations = {5,5,5,5};
	static int size;
	static int ans;
	public static void main(String[] args) {
		Arrays.sort(citations);
		size = citations.length;
		System.out.println(Arrays.toString(citations));
		for (int i = 0; i < citations.length; i++) {
			int num = citations[i]; //h번 인용
			if(num >= size - i && i <= num) {
				System.out.println(num+" "+(size-i));
				ans = size-i;
				break;
			}
		}
		System.out.println(ans);
	}
}
