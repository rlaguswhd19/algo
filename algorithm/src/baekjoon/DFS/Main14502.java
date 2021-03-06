package baekjoon.DFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main14502 {
	static int[][] array;
	static Queue<point> q, q2;
	static int count;
	static int[] a = {1, 0, -1, 0};
	static int[] b = {0, 1, 0, -1};
	static int n, m;
	static ArrayList<point> per;
	static boolean[][] visit;
	static int[][] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		array = new int[n][m];
		q = new LinkedList<>();
		visit = new boolean[n][m];
		result = new int[n][m];
		per = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int a = sc.nextInt();
				if(a == 2) {
					q.add(new point(i ,j));
				}
				array[i][j] = a;
			}
		}
		int[][] arr = copy();
//		virus(arr);
		per();
		System.out.println(count);
	}
	
	static int[][] virus(int[][] array, Queue<point> q) {
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				point v = q.poll();
				for (int j = 0; j < 4; j++) {
					if(v.x +a[j] >= 0 && v.y +b[j]>= 0 && v.x + a[j]< n && v.y + b[j]< m ) {
						if(array[v.x+a[j]][v.y+b[j]] == 0) {
							array[v.x+a[j]][v.y+b[j]] = 2;
							q.add(new point(v.x+a[j],v.y+b[j]));
						}
					}
				}
			}
		}
		return array;
	}
	
	static int[][] copy() {
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = array[i][j];
			}
		}
		return copy;
	}
	
	static void per() {
		if(per.size() == 3) {
			int c = 0;
			int[][] arr = copy();
			
			for (int i = 0; i < per.size(); i++) {
				point p = per.get(i);
				arr[p.x][p.y] = 1;
			}
			q2 = new LinkedList<>();
			Iterator<point> it = q.iterator();
			while(it.hasNext())  {
			   q2.add(it.next());
			}
			int[][] copyarr = virus(arr, q2);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(copyarr[i][j] == 0) {
						c++;
					}
				}
			}
//			System.out.println("+"+c);
			
//			count = Math.max(count, c);
			if(count<c) {
				count = c;
				result = copyarr;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(array[i][j] == 0 && !visit[i][j]) {
					per.add(new point(i, j));
					visit[i][j] = true;
					per();
					visit[i][j] = false;
					per.remove(per.size()-1);
				}
			}
		}
	}
	
	static class point {
		int x;
		int y;
		
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + "]";
		}
	}
}
