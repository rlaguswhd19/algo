package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2960 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		
		int cnt = 0;
		loop: for (int i = 2; i < n + 1; i++) {
			for (int j = i; j < n + 1; j += i) {
				if(arr[j] == 0) {
					arr[j] = 1;
					cnt++;
					
					if (cnt == k) {
						System.out.println(j);
						break loop;
					}
				}
				
			}
		}
	}
}
