package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution4371_항구에들어오는배 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Long> arr = new ArrayList<>();
			int ans = 0;

			for (int i = 0; i < n; i++) {
				long num = Integer.parseInt(br.readLine()) - 1;

				if (i == 0) {
					continue;
				}

				if (arr.size() == 0) {
					arr.add(num);
					ans++;
				}

				boolean isOk = true;

				for (int j = 0; j < arr.size(); j++) {
					if (num % arr.get(j) == 0) {
						isOk = false;
						break;
					}
				}

				if (isOk) {
					ans++;
					arr.add(num);
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
