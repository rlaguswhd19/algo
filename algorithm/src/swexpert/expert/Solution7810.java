package swexpert.expert;

import java.util.Scanner;

public class Solution7810 {
	static int[] array;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			array = new int[1000000+1];
			int sum = 0; 
			result = 0;
			for (int i = 0; i < n; i++) {
				int num = sc.nextInt();
				array[num+1]++;
			}
			for (int i = 0; i < array.length; i++) {
				sum += array[i];
//				System.out.println(n-sum+" "+i);
				if((n-sum)<i) {
					result = i-1;
					break;
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
