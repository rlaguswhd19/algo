package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10824 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		sb1.append(st.nextToken() + st.nextToken());
		sb2.append(st.nextToken() + st.nextToken());

		System.out.println(Long.parseLong(sb1.toString()) + Long.parseLong(sb2.toString()));
	}
}
