package T2020_2.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<String> list = new LinkedList<>();

		while (st.hasMoreTokens()) {
			String s = st.nextToken();

			if (list.contains(s)) {
				list.remove(s);
				list.addFirst(s);
			} else {
				list.addFirst(s);
			}

			for (int i = 0; i < 5; i++) {
				if (list.size() - 1 == i) {
					System.out.print(list.get(i));
					break;
				}else {
					System.out.print(list.get(i) + " ");
				}
				
			}
			if(st.hasMoreTokens()) {
				System.out.println();
			}
		}
	}
}
