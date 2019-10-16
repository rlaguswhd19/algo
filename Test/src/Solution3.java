import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
	static char[][] arr;
	static int[] a = {1,-1,1,-1};
	static int[] b = {1,-1,-1,1};
	static Queue<point> q;
	static int max = 0;
	static String[] board = {"ABCBA","DABAG","ENBBH","FAJAI","AKLMO"};
	public static void main(String[] args) {
		arr = new char[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			arr[i] = board[i].toCharArray();
		}
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = 1; j < board[0].length()-1; j++) {
				check(i, j);
			}
		}
		System.out.println(max);
	}
	static void check(int x, int y) {
		char temp = arr[x][y];
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if(arr[x+a[i]][y+b[i]] != temp) {
				return;
			}
		}
		//여기는 마름모 가능한것들만 통과함
		bfs(x, y);
	}
	static void bfs(int x, int y) {
		char temp = arr[x][y];
		int cnt = 0;
		q = new LinkedList<>();
		for (int i = 0; i < 4; i++) {
			q.add(new point(x+a[i], y+b[i]));
		}
		while(true) {
			System.out.println(q);
			int size = q.size();
			for (int i = 0; i < size; i++) {
				point p = q.poll();
				if(p.x+a[i] >=0 && p.y+b[i]>=0 && p.x+a[i]<board.length && p.y+b[i] < board.length) {
					if(arr[p.x+a[i]][p.y+b[i]] != temp) { //범위 안인데 다르면 나가기
						System.out.println("다르면"+cnt);
						max = Math.max(cnt, max);
						return;
					}else {
						q.add(new point(p.x+a[i], p.y+b[i]));
					}
				}else { //범위 나가면 나가기
					System.out.println("범위"+cnt);
					max = Math.max(cnt, max);
					return;
				}
			}
			cnt++;
		}
	}
	static class point{
		int x, y;

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
