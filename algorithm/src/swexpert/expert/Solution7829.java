package swexpert.expert;

import java.util.Arrays;
import java.util.Scanner;

public class Solution7829 {
	static int[] array;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			array = new int[n];
			result = 0;
			for (int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}
			Arrays.sort(array);
			if(n%2 == 0) { //
				result = array[0]*array[array.length-1];
			}else if(n==1){ // 
				result = array[0]*array[0];
			}else { //
				result = array[0]*array[array.length-1];
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
