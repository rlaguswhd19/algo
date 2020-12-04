package test.T2019_2.estsoft;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		int[] a = new int[200000];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random()*1000000000+1);
		}
		
		System.out.println(Arrays.toString(a));
	}
}
