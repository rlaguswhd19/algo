package T2020_2.gabia;

public class Solution1 {
	public static void main(String[] args) {
		int mod1 = 3;
		int mod2 = 4;
		int max_range = 20;
		System.out.println(solution(mod1, mod2, max_range));
	}

	static int solution(int mod1, int mod2, int max_range) {
		//mod1 로 나눠지는 애들 구하기
		int ans = max_range / mod1;
		// 최소 공배수를 구해야됌
		int max = 0;
		int min = 0;
		
		// 크기 정렬
		if (mod1 > mod2) {
			max = mod1;
			min = mod2;
		} else {
			max = mod2;
			min = mod1;
		}
		
		// 공배수
		int big = max * min;
		int temp = 0;
		
		// 최대공약수 구하기
		while (true) {
			temp = max % min;
			
			if(temp == 0) {
				break;
			}
			
			max = min;
			min = temp;
		}
		
		// 최소공배수로 나눠주기
		ans -= max_range / (big / min);

		return ans;
	}
}
