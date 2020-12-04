package test.T2020_2.nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
	static boolean[] fast;
	static int[] move, count;
	static int game, n;
	static char[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());

		fast = new boolean[91];
		count = new int[65 + n];

		char per = 'B';
		map = new char[n - 1];
		
		for (int i = 0; i < n - 1; i++) {
			map[i] = per;
			per += 1;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			String f = st.nextToken();
			fast[f.charAt(0)] = true;
		}

		game = Integer.parseInt(br.readLine());
		move = new int[game];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < game; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}

		solution();
	}

	static void solution() {
		char tag = 'A'; // A
		int now = 0;
		int idx = 0;
		count[(int) tag]++;

		while (now < game) {
			int m = move[now];
			m %= n - 1;
			idx += m;

			if (idx < 0) {
				idx = n - 1 + idx;
			}

			if (idx > n - 2) {
				idx -= n - 1;
			}
			
			if (!fast[(int) map[idx]]) {
				char temp = map[idx];
				map[idx] = tag;
				tag = temp;
				count[(int) tag]++;
			} else {
				count[(int) tag]++;
			}

			now++;
		}

		for (int i = 0; i < map.length; i++) {
			char person = map[i];
			System.out.println(person + " " + count[person]);
		}
		System.out.println(tag + " " + count[tag]);
	}
}
