package Line;

import java.util.Arrays;

public class Solution2 {
	static String answer_sheet = "4132315142";
	static String[] sheets = { "3241523133", "4121314445", "3243523133", "4433325251", "2412313253" };
	static int[] map;
	static int[] ans = new int[answer_sheet.length()];
	static boolean start;
	public static void main(String[] args) {
		solution();
		System.out.println(Arrays.toString(ans));
	}
	
	static int solution() {
		int sum = 0;
		
		for (int i = 0; i < answer_sheet.length(); i++) {
			char temp = answer_sheet.charAt(i);
			map = new int[6];
			
			// 한자리씩 검사
			for (int j = 0; j < sheets.length; j++) {
				char a = sheets[j].charAt(i);
				
				if(temp == a) {
					continue;
				}
				
				int num = a-'0';
				
				map[num]++;
			}
			
			for (int j = 1; j < map.length; j++) {
				if(map[j] <= 1) {
					continue;
				}
				
				ans[i] += map[j];
			}
		}
		
		return -1;
	}
}
