package nhngodo;

public class Solution4 {
	public static void main(String[] args) {
		String cardNumber = "26227174957722514961366";
		System.out.println(solution(cardNumber));
	}

	static String solution(String cardNumber) {
		int[] arr = new int[cardNumber.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = cardNumber.charAt(i) - '0';
		}
		if (arr.length % 2 == 0) {
			for (int i = 0; i < arr.length; i += 2) {
				arr[i] *= 2;
			}
		} else {
			for (int i = 1; i < arr.length; i += 2) {
				arr[i] *= 2;
			}
		}

		int sum = 0;
		char[] temp;
		for (int i = 0; i < arr.length; i++) {
			temp = Integer.toString(arr[i]).toCharArray();
			for (int j = 0; j < temp.length; j++) {
				sum += temp[j] - '0';
			}

		}
		
		return sum % 10 == 0 ? "VALID" : "INVALID";
	}
}
