package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7985_Binarytree재구성 {
	static int[] arr;
	static int k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			k = Integer.parseInt(br.readLine());

			arr = new int[1 << k];

			StringTokenizer st = new StringTokenizer(br.readLine());

			int size = st.countTokens();
			for (int i = 1; i < size + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Queue<ES> q = new LinkedList<>();

			q.add(new ES(1, 1 << k));
			int cnt = 0;
			System.out.print("#"+tc+" ");
			while (cnt < k) {
				size = q.size();
				for (int i = 0; i < size; i++) {
					ES es = q.poll();
					int num = (es.start + es.end) / 2;

					System.out.print(arr[num]+" ");

					q.add(new ES(es.start, num - 1));
					q.add(new ES(num + 1, es.end));

				}
				System.out.println();
				cnt++;
			}

		}
	}

	static class ES {
		int start, end;

		public ES(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "ES [start=" + start + ", end=" + end + "]";
		}
	}
}
