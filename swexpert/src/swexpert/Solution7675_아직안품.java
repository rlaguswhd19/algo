package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution7675_아직안품 {
	static String[] array;
	static String[] Sarray;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		Sarray = new String[3];
		Sarray[0] = "!";
		Sarray[1] = "?";
		Sarray[2] = ".";
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			
			array = new String[n];
			for (int i = 0; i < s.length(); i++) {
				String a = ""+s.charAt(i);
				for (int j = 0; j < 3; j++) { //3개 문자 돌리면서 맞으면 끊어서 그까지 인덱스를 배열에 저장하기
					if(a.equals(array[j])) {
						
					}
				}
			}
		}
	}
}
