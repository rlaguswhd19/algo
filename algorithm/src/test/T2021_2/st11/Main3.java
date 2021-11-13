package test.T2021_2.st11;

public class Main3 {
	public static void main(String[] args) {
		int N = 2147483647;
		System.out.println(solution(N));
	}
	
	static int solution(int N) {
		int ans = -1, num;
		int filter = 100000000;
		int[] arr = new int[10];
		StringBuilder sb = new StringBuilder();
		
		if((""+N).length() > 9) {
			return -1;
		}
		
		char[] nums = (""+N).toCharArray();
		for (char c : nums) {
			num = c -'0';
			arr[num]++;
		}
		
		for(int i = arr.length-1; i >= 0 ; i--) {
			num = arr[i];
			
			while(num > 0) {
				sb.append(i);
				num--;
			}
		}
		
		ans = Integer.parseInt(sb.toString());
		
		if(ans > filter) {
			return -1;
		}
		
		return ans;
	}
}
