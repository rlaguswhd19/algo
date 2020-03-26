package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1966 {
	static Queue<Page> q;
	static int n, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int tc = 0; tc < t; tc++) {
			q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			ArrayList<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				int important = Integer.parseInt(st.nextToken());
				list.add(important);
				q.add(new Page(i,important));
			}
			
			Collections.sort(list, Comparator.reverseOrder());
			
			int index = 0;
			int ans = 0;
			
			while(!q.isEmpty()) {
				Page p = q.poll();
				
				int important = list.get(index);
				
				
				if(p.important == important) {
					ans++;
					
					if(p.num == m) {
						System.out.println(ans);
						break;
					}
					
					index++;
				}else {
					q.add(p);
				}
				
			}
		}
	}

	static class Page {
		int num, important;

		public Page(int num, int important) {
			super();
			this.num = num;
			this.important = important;
		}

		@Override
		public String toString() {
			return "Page [num=" + num + ", important=" + important + "]";
		}
	}
}
