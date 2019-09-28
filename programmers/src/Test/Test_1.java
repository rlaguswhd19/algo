package Test;

import java.util.Arrays;

public class Test_1 {
	static int[] goods = {3,8,6};
	static int[] boxes = {5,6,4};
	public static void main(String[] args) {
		Arrays.sort(boxes);
		Arrays.sort(goods);
		System.out.println(Arrays.toString(boxes));
		System.out.println(Arrays.toString(goods));
		int index = 0;
		for (int i = 0; i < boxes.length; i++) {
			if(index == goods.length) {
				break;
			}
			if(goods[index] <= boxes[i]) {
				index++;
			}
		}
		System.out.println(index);
	}
}
