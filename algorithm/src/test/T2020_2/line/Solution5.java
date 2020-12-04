package test.T2020_2.line;

public class Solution5 {
	public static void main(String[] args) {
		int[] cards = {1, 4, 10, 6, 9, 1, 8, 13};
		System.out.println(solution(cards));
	}

	static int solution(int[] cards) {
		// 1의 갯수
		int u_one = 0;
		int d_one = 0;

		// 합
		int u_sum = 0;
		int d_sum = 0;

		int idx = 4; // cards index

		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				if (cards[i] == 1) {
					u_one++;
				}

				if (cards[i] > 10) {
					u_sum += 10;
				} else {
					u_sum += cards[i];
				}
			} else {
				if (cards[i] == 1) {
					d_one++;
				}

				if (cards[i] > 10) {
					d_sum += 10;
				} else {
					d_sum += cards[i];
				}
			}
		}

		// 보이는 카드
		int visible_card = cards[3];

		if (u_sum == 21) { // 블랙잭인 경우
			if (d_sum == 21) { // 얘도 블랙잭인 경우
				return 0;
			}

			// 블랙잭 승리
			return 3;
		} else if (u_sum > 21) { // 21을 넘어서 패배
			return -2;
		} else { // 21 이하인 경우
			
			boolean receive = false;

//			1. 딜러의 보이는 카드가 1이거나 7 이상인 경우, 플레이어는 카드 합이 17 이상이 될 때까지 받는다.
//			2. 딜러의 보이는 카드가 4, 5, 6인 경우, 플레이어는 카드를 받지 않는다.
//			3. 딜러의 보이는 카드가 2, 3인 경우, 플레이어는 카드 합이 12 이상이 될 때까지 받는다.

			if (visible_card == 1 || visible_card >= 7) { // 17 이상이 될 때 까지 받는다.

				while (u_sum < 17) {
					receive = true;
					
					int card = cards[idx++]; // 다음 카드

					if (card == 1) { // 카드가 1이면
						u_one++;
					}
					
					if(card > 10) {
						u_sum+=10;
					}else {
						u_sum += card;
					}

					// 최적의 값
					int sum = u_sum;

					if (u_one > 0) {
						sum = check(u_one, u_sum);
					}

					if (sum >= 17) {
						u_sum = sum;
						break;
					}
				}

			} else if (visible_card == 4 || visible_card == 5 || visible_card == 6) { // 카드 받지 않는 경우
				if(d_sum > 21) {
					return 2;
				}
				
				while (d_sum < 17) {
					int card = cards[idx++];

					if (card == 1) {
						d_one++;
					}

					if(card > 10) {
						d_sum+=10;
					}else {
						d_sum += card;
					}
					
					int sum = d_sum;
					
					if(d_one > 0) {
						sum = check(u_one, u_sum);
					}
					
					if(sum >= 17) {
						d_sum = sum;
						break;
					}
				}
				
			} else if (visible_card == 2 || visible_card == 3) {

				while (u_sum < 12) {
					receive = true;
					int card = cards[idx++]; // 다음 카드

					if (card == 1) { // 카드가 1이면
						u_one++;
					}

					if(card > 10) {
						u_sum+=10;
					}else {
						u_sum += card;
					}

					// 최적의 값
					int sum = u_sum;

					if (u_one > 0) {
						sum = check(u_one, u_sum);
					}

					if (sum >= 12) {
						u_sum = sum;
						break;
					}
				}

			}

			if(receive) { // 카드를 받았으면 딜러는 카드를 받는다.
				if(d_sum > 21) {
					return 2;
				}
				
				while (d_sum < 17) {
					int card = cards[idx++];

					if (card == 1) {
						d_one++;
					}

					if(card > 10) {
						d_sum+=10;
					}else {
						d_sum += card;
					}
					
					int sum = d_sum;
					
					if(d_one > 0) {
						sum = check(u_one, u_sum);
					}
					
					if(sum >= 17) {
						d_sum = sum;
						break;
					}
				}
			}
			
			
			System.out.println(u_sum);
			System.out.println(d_sum);
			if(d_sum > 21) {
				return 2;
			}else if(u_sum > 21) {
				return -2;
			}
			
			if (u_sum == 21) { // 블랙잭인 경우
				if (d_sum == 21) { // 얘도 블랙잭인 경우
					return 0;
				}

				// 블랙잭 승리
				return 3;
			}else {
				if(u_sum > d_sum) {
					return 2;
				}else if(u_sum < d_sum){
					return -2;
				}else {
					return 0;
				}
			}
		}
	}

	static int check(int one, int sum) { // 최적의 결과값을 보여주는 함수
		int temp_one = one;
		int temp_sum = sum;

		while (temp_one > 0) {
			if (temp_sum + 10 <= 21) {
				temp_one--;
				temp_sum += 10;
			} else {
				break;
			}
		}

		return temp_sum;
	}
}
