package swexpert.expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7830 {
	static int[][] array;
	static int count;
	static int[] a = {-1, 1};
	static Queue<Point> q;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			array = new int[n][m];
			q = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				String s = bf.readLine();
				for (int j = 0; j < s.length(); j++) {
					array[i][j] = s.charAt(j)-'0';
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(array[i][j] == 1) {
						int sum = 0;
						for (int l = 0; l < a.length; l++) {
							if(i+1 >= 0 && i+1 < array.length && j+a[l] >= 0 && j+a[l] < array.length) { 
								if(array[i+1][j+a[l]] == 1) {
									sum++;
								}
							}else {
								break;
							}
						}
						if(sum == 2) { //양쪽에 다 1이면 마름모 가능성이 있다.
//							System.out.println("마름모 가능성이 있는 i : "+i+" , j : "+j);
							checkBfs(i,j);
						}
					}
				}
			}
		}
	}
	static boolean checkBfs(int i, int j) {
		count = 1; //처음 카운트 1로 시작
		for (int l = 0; l < a.length; l++) {
			if(i+1 >= 0 && i+1 < array.length && j+a[l] >= 0 && j+a[l] < array.length) { 
				if(array[i+1][j+a[l]] == 1) { 
					q.add(new Point(i+1, j+a[l])); 
				}
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
			System.out.println(q);
			if(size != 2) {
				break;
			}
			count++; 
			for (int l = 0; l < size; l++) {
				Point p = q.poll();
				if(l == 0) {
					Left(p);
				}else {
					Right(p);
				}
			}
		}
		return false;
	}
	static void Right(Point p) {
	    if(p.y+1 >= array.length || p.x+1 >= array.length || array[p.x+1][p.y-1] == 0) {
	    	return;
	    }else if(array[p.x+1][p.y+1] == 1) {
			q.add(new Point(p.x+1, p.y+1));
		}
		System.out.println(p);
	}
	static void Left(Point p) {
		if(p.y-1 < 0 || p.x+1 > array.length || array[p.x-1][p.y-1] == 0) { 
			return;
		}else if(array[p.x+1][p.y-1] == 1) {
			q.add(new Point(p.x+1, p.y-1));
		}
		System.out.println(p);
	}
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
