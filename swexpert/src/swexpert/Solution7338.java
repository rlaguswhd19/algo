package swexpert;

import java.util.Scanner;

public class Solution7338 {
	static long nowY, nowM;
	static long sum, result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			sum = 0;
			result = 0;
			long y = sc.nextLong();
			int m = sc.nextInt();
			sum = y*12 + m;
			
			result = (sum-24204);
//			System.out.println(result);
			
			nowY = 2016+(result/13);
			nowM = 12+(result%13);
			if(nowM >13) {
				nowY++;
				nowM-=13;
			}
			
			System.out.println("#"+tc+" "+nowY+" "+nowM);
			
			
		}
	}
}
