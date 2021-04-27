package leetcode;

public class Solution48 {
	static int[][] temp;
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
	}

	static void rotate(int[][] matrix) {

		int len = matrix.length;
		temp = new int[len][len];
		int past = 0, now = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
//				past = matrix[j][len - 1 - i];
//				matrix[j][len - 1 - i] = now;
//				now = past;
				temp[j][len-1-i] = matrix[i][j];
			}
		}
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(temp[i][j]+" ");
			}System.out.println();
		}
	}
}
