package test.T2020_2.ntech_2019;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		String phone_number = "01012345678";
//		String phone_number = "010-1212-333";
//		String phone_number = "+82-10-3434-2323";
//		String phone_number = "+82-010-3434-2323";
		System.out.println(solution(phone_number));
	}

	static int solution(String phone_number) {
//		48~57
		char[] arr = phone_number.toCharArray();
		
		// 처음 조건 체크
		if (arr[0] == '+' && arr[1] == '8' && arr[2] == '2' && arr[3] == '-' && arr[4] == '1' && arr[5] == '0'
				&& arr[6] == '-') {
			// 길이 체크
			if (arr.length != 16) {
				return -1;
			}
			
			// 숫자와 11번쨰 -인지 체크
			for (int i = 7; i < arr.length; i++) {
				if (i == 11) {
					if (arr[i] != '-') {
						return -1;
					}
				}

				if (arr[i] < 48 && arr[i] > 57) { // 숫자가 아니면
					return -1;
				}
			}

			return 3;
		} else if (arr[0] == '0' && arr[1] == '1' && arr[2] == '0') {
			if (arr.length == 11) {
				for (int i = 3; i < arr.length; i++) {
					if (arr[i] < 48 && arr[i] > 57) { // 숫자가 아니면
						return -1;
					}
				}

				return 2;
			} else if (arr.length == 13) {
				for (int i = 3; i < arr.length; i++) {
					if(i == 3 || i == 8) {
						if(arr[i] != '-') {
							return -1;
						}
					}
					
					if (arr[i] < 48 && arr[i] > 57) { // 숫자가 아니면
						return -1;
					}
				}
				
				return 1;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}
