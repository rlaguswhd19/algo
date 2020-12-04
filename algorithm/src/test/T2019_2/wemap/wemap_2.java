package test.T2019_2.wemap;
import java.util.HashMap;
import java.util.Scanner;

public class wemap_2 {
	static String s;
	static HashMap<String, Integer> map;
	static int index = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		s = "";
		map = new HashMap<>();
		dfs(s);
		System.out.println(map.get(n));
	}

	static void dfs(String s) {
		if(s.length() > 3) {
			return;
		}
		for (int i = 1; i < 10; i++) {
			s += i;
			map.put(s, index++);
			dfs(s);
			s = s.substring(0, s.length()-1);
		}
	}
}
