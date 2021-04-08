package programmers.Hash;

public class level2_전화번호목록 {
	static String[] phone_book = {"119", "97674223", "1195524421"};
	public static void main(String[] args) {
		System.out.println(solution(phone_book));
	}
	static boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            for (int j=0; j < phone_book.length; j++) {
                if (i!=j && phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
