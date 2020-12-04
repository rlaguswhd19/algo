package programmers.월간코드챌린지;

public class Solution2 {
	public static void main(String[] args) {
		String s = "110010101001";
		solution(s);
	}
	
	static int[] solution(String s) {
		int[] ans = new int[2];
		
		int cnt = 0;
		
		while(true) {
			int past = s.length();
			s = s.replaceAll("0", "");
			int next = s.length();
			
			ans[1] += past-next;
			
			s = Integer.toBinaryString(next);
			cnt++;
			
			if(s.equals("1")) {
				break;
			}
			
		}
		
		ans[0] = cnt;
		
		
		return ans;
	}
	
}
