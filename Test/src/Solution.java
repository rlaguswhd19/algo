
public class Solution {
	static int n = 10;
	static int[] P = {5,4,3,2,1,6,7,8,9,10};
	static int sum = 0;
	public static void main(String[] args) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < P.length; i++) {
			if(P[i] < min) {
				min = P[i];
			}
			sum+=min;
		}
		System.out.println(sum);
	}
}
