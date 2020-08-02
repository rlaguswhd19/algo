package T2020_2.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		boolean ans = true;
		char temp = s.charAt(0);
		
		if(s.charAt(s.length()-1) == '1') {
			ans = false;
		}else {
			for (int i = 1; i < s.length(); i++) {
				char now = s.charAt(i);
				
				
				if(temp == '1' && now == '1') {
					ans = false;
					break;
				}
				
				temp = now;
			}
		}
		
		
		System.out.println(ans);
	}
}
