package Line;

public class Solution1 {
	static String inputString = ">_<";
	static char[] list = { '(', ')', '{', '}', '[', ']', '<', '>' };
	static boolean[] check = new boolean[4];

	public static void main(String[] args) {
		System.out.println(solution());
	}

	static int solution() {
		int ans = 0;

		char[] temp = inputString.toCharArray();
		for (int i = 0; i < temp.length; i++) {
			char s = temp[i];

			for (int j = 0; j < list.length; j++) {
				if (s == list[j]) {
//					i가 짝수가 먼저 나와야 함
					if (j % 2 == 0) { // 짝수의경우
						check[j / 2] = true;
					} else { // 홀수의 경우
						if (check[j / 2]) { // 짝수가 와있어?
							ans++;
							check[j / 2] = false;
							break;
						} else { // 짝수가 안나왔어?
							return -1;
						}
					}
				}
			}
		}
		
		// 다 돌았는데 안닫혔어??
		for (int i = 0; i < check.length; i++) {
			if(check[i]) {
				return -1;
			}
		}
		
		return ans;
	}
}
