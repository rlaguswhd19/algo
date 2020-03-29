package EstSoft;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution4 {
	static String s = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
	static String c = "Example";
	static String[] name;
	static String ans;
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		name = s.split(";");
		c = c.toLowerCase();
		ans = "";
//		System.out.println(Arrays.toString(name));

		StringTokenizer st;
		int cnt = 0;
		for (int i = 0; i < name.length; i++) {
			st = new StringTokenizer(name[i]);
			cnt = st.countTokens();
			String last, first;
			
			if (cnt == 3) {
				last = st.nextToken();
				st.nextToken();
				first = st.nextToken();
			} else {
				last = st.nextToken();
				first = st.nextToken();
			}

			ans += makeEmail(first, last, name[i]);
		}
		
		System.out.println(ans.substring(0, ans.length()-1));
	}

	static String makeEmail(String first, String last, String name) {
		first = first.replace("-", "");
		last = last.replace("-", "");

		String email = first + "_" + last;
		if (!map.containsKey(email)) {
			map.put(email, 1);
		} else {
			map.put(email, map.get(email) + 1);
		}
		
		if(map.get(email) == 1) {
			return name+" <"+email.toLowerCase()+"@"+c+".com>;";
		}else {
			return name+" <"+email.toLowerCase()+map.get(email)+"@"+c+"com>;";
		}
	}
}
