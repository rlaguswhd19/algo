package Level3;

public class 브라이언의고민 {
	public static void main(String[] args) {
		String sentence = "HaEaLaLaObWORLDb";
		solution(sentence);
	}

	static String solution(String sentence) {
		StringBuilder sb = new StringBuilder(sentence);
		StringBuilder ans = new StringBuilder();

		int idx = 0;
		int temp = 0;
		while (idx < sb.length()) {

			// 조건 1인지 검사하기
//			if (sb.charAt(idx) >= 97) { // 규칙 2
//				if (idx + 2 > sb.length() - 1) { // aAa인 경우 한글자여도 +2는 존재해야함 만일 존재하지 않는 경우 잘못돼었다.
//					return "invalid";
//				}
//
//				if (sb.charAt(idx + 2) >= 97) { // 규칙 1 & 규칙 2
//
//				} else { // 규칙 2
//
//				}
//			} else { // 처음 소문자가 아니면 
//				// 한글자만 있는 경우 "A"이면 존재하지 않음 밀착만 했다? aAaCbDb인 경우는?
//				if (sb.charAt(idx + 1) >= 97) { // 규칙 1
//
//				} else { // 밀착
//
//				}
//			}
			
			// 먼저 규칙을 찾아야 한다. 첫 소문자를 찾도록 하자. 인덱스
			for (int i = idx; i < sb.length(); i++) {
				char c = sb.charAt(i);
				if (c >= 97) { // 처음 찾음
					temp = i;
					break;
				}
			}
			
			if(temp == idx) { // 규칙 1
				if(temp == idx+2) { // 규칙 1 && 규칙 2
					
				}
			}else if(temp == idx + 1) { // 규칙 2
			
			}
		}
		return "";
	}
}
