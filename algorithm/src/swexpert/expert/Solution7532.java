package swexpert.expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7532 {
	static int s,e,m;
	static int max;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			
			max = 0;
			result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				s = Integer.parseInt(st.nextToken()); //365
				e = Integer.parseInt(st.nextToken()); //24
				m = Integer.parseInt(st.nextToken()); //29
			}
			CalSEM();
			System.out.println("#"+tc+" "+result);
		}
	}
	static void CalSEM() {
		result = s;
		int count = 0;
		while(true) {
			if(count == 1000) {
				break;
			}
			if(CalE(result) && CalM(result)) {
				break;
			}
			
			count++;
//			System.out.println(result);
			result += 365;
		}
	}
	static boolean CalE(int R) {
		int E = R%24;
		if(E == 0) {
			E = 24;
		}
		if(E == e) {
			return true;
		}else {
			return false;
		}
	}
	static boolean CalM(int R) {
		int M = R%29;
		if(M == 0) {
			M = 29;
		}
		if(M == m) {
			return true;
		}else {
			return false;
		}
	}
	
}
