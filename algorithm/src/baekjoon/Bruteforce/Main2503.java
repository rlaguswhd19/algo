package baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2503 {
	static int[] list;
	static int[] arr;
	static boolean[] visit;
	static int listidx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		list = new int[9 * 8 * 7];
		arr = new int[3];
		visit = new boolean[10];

		listidx = 0;
		per(0);
		StringTokenizer st;
		int num[] = new int[3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String snum = st.nextToken();
			for (int j = 0; j < snum.length(); j++) {
				num[j] = snum.charAt(j) - '0';
			}

			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			check(num, s, b);
		}
		
		int ans = 0;
		for (int i = 0; i < list.length; i++) {
			if(list[i] == 0) {
				continue;
			}
			ans++;
		}
		
		System.out.println(ans);
	}

	static void check(int[] num, int s, int b) {
		int[] listarr = new int[3];
		
		
		for (int i = 0; i < list.length; i++) {
			int scnt = 0;
			int bcnt = 0;
			
			if (list[i] == 0) {
				continue;
			}

			String temp = Integer.toString(list[i]);

			for (int j = 0; j < 3; j++) {
				listarr[j] = temp.charAt(j) - '0';
			}
			
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					if(j == j2) {
						if(num[j] == listarr[j2]) {
							scnt++;
							break;
						}
					}else {
						if(num[j] == listarr[j2]) {
							bcnt++;
							break;
						}
					}
				}
			}
			if(scnt == s && bcnt == b) {
				continue;
			}else {
				list[i] = 0;
			}
		}
	}

	static void per(int idx) {
		if (idx == 3) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 3; i++) {
				sb.append(arr[i]);
			}
			list[listidx++] = Integer.parseInt(sb.toString());
			return;
		}

		for (int i = 1; i < 10; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[idx] = i;
				per(idx + 1);
				visit[i] = false;
			}
		}

	}
}
