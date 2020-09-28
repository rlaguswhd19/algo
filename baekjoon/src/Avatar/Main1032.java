package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1032 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] temp = br.readLine().toCharArray();

		for (int i = 0; i < n - 1; i++) {
			char[] arr = br.readLine().toCharArray();

			for (int j = 0; j < arr.length; j++) {
				if (temp[j] == '?') {
					continue;
				} else {
					if (temp[j] != arr[j]) {
						temp[j] = '?';
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < temp.length; i++) {
			sb.append(temp[i]);
		}
		
		System.out.println(sb.toString());
	}
}
