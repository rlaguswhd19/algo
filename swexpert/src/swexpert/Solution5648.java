package swexpert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution5648 {
	static ArrayList<Point> arr;
	static int[][] map;
	static int count = 4000;
	static ArrayList<Point> out;
	static int result;
	static HashSet<Point> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			arr = new ArrayList<>();
			result = 0;
			map = new int[4001][4001];
			set = new HashSet<>();

			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.nextInt();
				int e = sc.nextInt();
				
				//저장한다.
				arr.add(new Point(2*x + 2000, 2*y + 2000, dir, e));
				
				//점들을 찍어
				map[2*x + 2000][2*y + 2000] = 1; 
				
			}
			start();
			System.out.println("#" + tc + " " + result);
		}
	}


	static void start() {
		for (int i = 0; i < count; i++) {
			set = new HashSet<>();
			out = new ArrayList<>();
			for (int j = 1; j < arr.size(); j++) {
				move(arr.get(j));
			}
			remove();
			out();
		}
	}
	static void out() {
		for (int i = 0; i < out.size(); i++) {
			arr.remove(out.get(i));
		}
	}
	static void move(Point p) { // 1씩 방향으로 이동
		switch (p.dir) {
		case 0: // 상
			
			map[p.x][p.y]--;
			if(p.y+1 >= map.length) {
				out.add(p);
				break;
			}
			p.y++;
			
			map[p.x][p.y]++;
			if(map[p.x][p.y] > 1) {
				set.add(new Point(p.x,p.y ,0,0));
			}
			break;
		case 1: // 하
			map[p.x][p.y]--;
			if(p.y+1 >= map.length) {
				out.add(p);
				break;
			}
			p.y--;
			
			map[p.x][p.y]++;
			if(map[p.x][p.y] > 1) {
				set.add(new Point(p.x,p.y ,0,0));
			}
			break;
		case 2: // 좌
			map[p.x][p.y]--;
			if(p.y+1 >= map.length) {
				out.add(p);
				break;
			}
			p.x--;
			
			map[p.x][p.y]++;
			if(map[p.x][p.y] > 1) {
				set.add(new Point(p.x,p.y ,0,0));
			}
			break;
		case 3: // 우
			map[p.x][p.y]--;
			if(p.y+1 >= map.length) {
				out.add(p);
				break;
			}
			p.x++;
			
			map[p.x][p.y]++;
			if(map[p.x][p.y] > 1) {
				set.add(new Point(p.x,p.y ,0,0));
			}
			break;
		}
	}
	
	static void remove() {
		Iterator<Point> it = set.iterator();
		while(it.hasNext()) {
			Point p = it.next();
			for (int i = 0; i < arr.size(); i++) {
				if(p.x == arr.get(i).x && p.y == arr.get(i).y) {
					result += arr.get(i).e;
					arr.remove(i);
					break;
				}
			}
			map[arr.get(index).x][arr.get(index).y] = 0;
			arr.remove(index); //비워버리자
			set = new HashSet<>();
		}
	}
	static class Point {

		int x;
		int y;
		int dir;
		int e;

		public Point(int x, int y, int dir, int e) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.e = e;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + ", e=" + e + "]";
		}
	}
}
