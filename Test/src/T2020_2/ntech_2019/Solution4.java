package T2020_2.ntech_2019;

public class Solution4 {
	public static void main(String[] args) {
//		String sentence = "His comments came after Pyongyang announced it had a plan to fire four missiles near the US territory of Guam.";
		String sentence = "Jackdaws love my big sphinx of quartz";
//		String sentence = "ABC";
		solution(sentence);
	}

	static void solution(String sentence) {
		String[] arr = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z" };
		StringBuilder sb = new StringBuilder();
		sentence = sentence.toLowerCase();
		
		for (int i = 0; i < arr.length; i++) {
			if (!sentence.contains(arr[i])) {
				sb.append(arr[i]);
			}
		}
		System.out.println(sb.length() == 0 ? "perfect" : sb.toString());
	}
}
