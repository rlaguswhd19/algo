package T2019_2.Line;

public class Solution3 {
	static String road = "111011110011111011111100011111";
	static int n = 6;
	static int ans;
	public static void main(String[] args) {
		System.out.println(solution());
	}
	static int solution() {
		ans = 0;
		
		for (int i = 0; i < road.length(); i++) {
			int num = road.charAt(i);
			if(i == 0) {
				dfs(i);
			}else {
				if(road.charAt(i-1) == '1' && num == '1') {
					continue;
				}else {
					dfs(i);
				}
			}
		}
		return ans;
	}
	static void dfs(int index) {
		int cnt = n;
		int sum = 0;
		
		for (int i = index; i < road.length(); i++) {
			int num = road.charAt(i);
			if(num == '0') {
				cnt--;
			}
			
			if(cnt == -1) {
				ans = Math.max(ans, sum);
				return;
			}
			sum++;
			
			if(i == road.length()-1) {
				ans = Math.max(ans, sum);
			}
		}
	}
}
