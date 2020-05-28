package D3;

public class Solution3131_100만이하의모든소수 {
	public static void main(String[] args) {
		boolean[] arr = new boolean[1000001];
		
		for (int i = 2; i < arr.length; i++) {
			if (arr[i]) {
				continue;
			} else {
				System.out.print(i + " ");
				int cnt = i;
				for (int j = i; j < arr.length; j += i) {
					arr[j] = true;
				}
			}
		}
	}
}
