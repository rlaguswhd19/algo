package T2020_2.st11;

public class Solution2 {
	public static void main(String[] args) {
		String[] S = { "bdafg", "ceagi" };
		solution(S);
	}

	static int[] solution(String[] S) {
		int[] temp = {};
		
		for (int i = 0; i < S.length; i++) {
			String s1 = S[i];
			for (int j = i + 1; j < S.length; j++) {
				String s2 = S[j];
				
				for (int k = 0; k < s1.length(); k++) {
					char s1_t = s1.charAt(k);
					char s2_t = s2.charAt(k);
					
					if(s1_t == s2_t) {
						temp = new int[3];
						temp[0] = i;
						temp[1] = j;
						temp[2] = k;
					}
				}
			}
		}
		
		return temp;
	}
}
