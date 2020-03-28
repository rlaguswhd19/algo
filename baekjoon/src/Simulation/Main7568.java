package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main7568 {
	static int n;
	static ArrayList<Person> list;
	static int[] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		StringTokenizer st;
		ans = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ans[i] = 1;
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.add(new Person(w, h));
		}

		for (int i = 0; i < n; i++) {
			Person p1 = list.get(i);
			for (int j = 0; j < n; j++) {
				Person p2 = list.get(j);

				if (p1.h > p2.h && p1.w > p2.w) {
					ans[j]++;
				}
			}
		}

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
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
