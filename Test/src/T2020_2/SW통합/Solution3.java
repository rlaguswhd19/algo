package T2020_2.SW통합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		isPrime(n);
	}

	static int isPrime(long n) {
		
		long half = n/2;
		
		for (int i = 2; i <= half; i++) {
			if(n%i == 0) {
				return i;
			}
		}

		return 1;
	}
}
