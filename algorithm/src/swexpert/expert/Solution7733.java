package swexpert.expert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution7733 {
	static int[][] array;
	static int result, index, realresult, count;
	static int[] a = {1, -1, 0, 0};
	static int[] b = {0, 0, 1, -1};
	static int[][] visit;
	static Queue<Cheeze> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			realresult = 0;
			q = new LinkedList<>();
			array = new int[n][n];
			int max = 0; 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					array[i][j] = sc.nextInt();
					if (max < array[i][j]) {
						max = array[i][j];
					}
				}
			}
			index = 0; 
			while(true) {
				result = 0; 
				visit = new int[n][n]; 
				if(index >= max) {
					break;
				}
				eat(); 
				count();
				if(result>realresult) {
					realresult = result;
				}
//				System.out.println(result);
//				print(n, visit);
				index++;
			}
			System.out.println("#"+tc+" "+realresult);
		}
	}
	static void eat() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[i][j] == index) {
					array[i][j] = 0;
				}
			}
		}
	}
	
	static void count() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[i][j] != 0 && visit[i][j] != 1) {
					check(i, j);
				}
			}
		}
	}
	
	static void check(int i, int j) { 
		int size = 0;
		q.add(new Cheeze(i, j));
		visit[i][j] = 1;
		while(!q.isEmpty()) {
			size = q.size();
			for (int k = 0; k < size; k++) {
				Cheeze ch = q.poll(); 
				for (int l = 0; l < 4; l++) { 
					if(ch.i+a[l]>=0 && ch.j+b[l]>=0 && ch.i+a[l]<array.length && ch.j+b[l]<array.length) { 
						if(array[ch.i+a[l]][ch.j+b[l]] != 0 && visit[ch.i+a[l]][ch.j+b[l]] != 1) {
							q.add(new Cheeze(ch.i+a[l], ch.j+b[l]));
							visit[ch.i+a[l]][ch.j+b[l]] = 1;
						}
					}
				}
			}
		}
		result++; 
	}
	static void print(int n, int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]);
			}System.out.println();
		}
	}
	
	static class Cheeze{
		int i, j;
		
		public Cheeze(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
		public Cheeze() {}
		
		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}

		@Override
		public String toString() {
			return "Cheeze [i=" + i + ", j=" + j + "]";
		}
	}
}
