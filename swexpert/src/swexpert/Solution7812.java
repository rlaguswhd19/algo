package swexpert;

import java.util.Scanner;

public class Solution7812 {
	static int[] array;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); // ��ũ��
			int m = sc.nextInt(); // ��
			int sum = 0;
			array = new int[n];
			result = 0;
			for (int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}
			for (int j = 0; j < array.length; j++) {
				sum = 0;
				for (int i = j; i < array.length; i++) {
					sum += array[i];
					if (sum > m) {
						break;
					} else if (sum == m) {
						result++;
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
