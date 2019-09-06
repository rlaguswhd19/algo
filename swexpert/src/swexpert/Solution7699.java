package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7699 {
	static int r, c;
	static char[][] map;
	static String input;
	static int[] a = {0,0,1,-1};
	static int[] b = {1,-1,0,0};
	static int result;
	static int count;
	static boolean[] Looked;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
			}
			map = new char[r][c];
			result = 0;
			count = 1;
			Looked = new boolean[26];
			for (int i = 0; i < r; i++) {
				input = br.readLine();
				for (int j = 0; j < c; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			Suzi S = new Suzi(0,0);
			Looked[map[0][0]-'A'] = true;
			move(S, count);
			System.out.println("#"+tc+" "+result);
		}
	}
	static void move(Suzi suzi, int count){
		// 4방향 검사
		result = Math.max(result, count);
		for (int i = 0; i < 4; i++) {
			if(suzi.i+a[i]>=0 && suzi.j+b[i] >=0 && suzi.i+a[i] < r && suzi.j+b[i] < c ) {
				if(!Looked[map[suzi.i+a[i]][suzi.j+b[i]]-'A']) { //Looked[65] A 명물을 안봤다면
					Looked[map[suzi.i+a[i]][suzi.j+b[i]]-'A'] = true; //봤다고 해주고
					move(new Suzi(suzi.i+a[i],suzi.j+b[i]), count+1);
					Looked[map[suzi.i+a[i]][suzi.j+b[i]]-'A'] = false;
				}
			}
			
		}
	}
	
	static class Suzi{
		int i, j;

		public Suzi(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Suzi [i=" + i + ", j=" + j + "]";
		}
	}
}
