package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main7568 {
	static int n;
	static ArrayList<Person> list;
	static Person max = new Person(0, 0);
	static int[] ans;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		StringTokenizer st;
		ans = new int[n];
		visit= new boolean[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.add(new Person(w, h));
			if (max.h < h && max.w < w) {
				max = new Person(w, h);
			}
		}

		grade();
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	static void grade() {

		int cnt = 1;
		int temp;
		Person next = new Person(0, 0);
		loop: while (true) {
			temp = 0;
			for (int i = 0; i < list.size(); i++) {
				Person p = list.get(i);
				
				if(visit[i]) {
					continue;
				}
				
				if (max.h > p.h && max.w > p.w) {
					if(next.w < p.w && next.h < p.h) {
						next = new Person(p.w, p.h);
					}
					continue;
				} else {
					visit[i] = true;
					ans[i] = cnt;
					temp++;
				}
			}
			cnt += temp;
			
			if(cnt == n) {
				for (int i = 0; i < list.size(); i++) {
					if(visit[i]) {
						continue;
					}else {
						ans[i] = cnt;
					}
				}
				
				break loop;
			}
			max = new Person(next.w, next.h);
		}
	}

	static class Person {
		int w, h;

		public Person(int w, int h) {
			super();
			this.w = w;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Person [w=" + w + ", h=" + h + "]";
		}
	}
}
