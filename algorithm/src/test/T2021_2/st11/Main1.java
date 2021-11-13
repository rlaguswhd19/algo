package test.T2021_2.st11;

public class Main1 {
	public static void main(String[] args) {
		
		String[] phone_numbers = {};
		String[] phone_owners = {};
		String number = "";
		System.out.println(solution(phone_numbers, phone_owners, number));
	}
	
	static String solution(String[] phone_numbers, String[] phone_owners, String number) {
		String ans = number;
		
		String phone, owner;
		
		for (int i = 0; i < phone_numbers.length; i++) {
			phone = phone_numbers[i];
			owner = phone_owners[i];
			
			if(phone.equals(number)) {
				ans = owner;
				return ans;
			}
		}
        
        return ans;
    }
}
