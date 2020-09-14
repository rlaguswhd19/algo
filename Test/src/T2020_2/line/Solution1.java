package T2020_2.line;

public class Solution1 {
	public static void main(String[] args) {
		int[][] boxes = {{1, 2}, {2, 3}, {3, 1}};
		solution(boxes);
	}
	
	static int solution(int[][] boxes) {
		int[] two = new int[boxes.length + 1];
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < 2; j++) {
				int num = boxes[i][j];
				
				if(num < two.length) {
					two[num]++;
				}
			}
		}
		
		int cnt = 0;
		for (int i = 1; i < two.length; i++) {
			if(two[i] == 1) {
				cnt++;
			}else if(two[i] == 0) {
				cnt+=2;
			}
		}
		return cnt;
	}
}
