package study;

import java.util.Scanner;

public class dijkstra {
	static int[] distance;
	static boolean[] visit;
	static int n, start, end;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		distance = new int[n+1];
		visit = new boolean[n+1];
		
		for (int i = 1; i < n+1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		start = sc.nextInt();
		end = sc.nextInt();
		
		
	}
}
