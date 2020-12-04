package swexpert.expert;

import java.util.Scanner;

public class Solution7510 {
	static int[] array;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			result = 0;
			array = new int[n];
			
			for (int i = 0; i < n; i++) {
				array[i] = i+1;
			}
			int index = 0;
			
			while(true) {
				int sum = 0;
				if(index == n) {
					break;
				}
				for (int i = index; i < n; i++) {
					sum+=array[i];
					if(sum > n) {
						break;
					}else if(sum == n) {
						result++;
					}
				}
				index++;
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
