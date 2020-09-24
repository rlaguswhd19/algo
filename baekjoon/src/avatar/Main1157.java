package avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[91];
		String s = br.readLine();
		s = s.toUpperCase();

		int max = 0;
		char ans = 0;
		boolean isOk = true;
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i);
			arr[num]++;

			if (max < arr[num]) {
				max = arr[num];
				ans = (char) num;
				isOk = true;
			} else if (max == arr[num]) {
				isOk = false;
			}
		}
	
		System.out.println(isOk ? ans : "?");
	}
}
