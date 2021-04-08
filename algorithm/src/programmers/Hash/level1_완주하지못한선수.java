package programmers.Hash;

import java.util.HashMap;

public class level1_완주하지못한선수 {
	static String[] participant = {"leo", "kiki", "eden"};
	static String[] completion = {"eden", "kiki"};
	public static void main(String[] args) {
		String answer = "";
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        for(int i = 0 ; i< participant.length; i++){
            if(map1.get(participant[i]) == null){
                map1.put(participant[i], 1);
            }else{
                map1.put(participant[i], map1.get(participant[i])+1);
            }
        }
        for(int i = 0; i<completion.length; i++){
            map1.put(completion[i], map1.get(completion[i])-1);
        }
        
        for(int i = 0; i<participant.length; i++){
            if(map1.get(participant[i]) == 1){
                answer = participant[i];
                break;
            }
        }
        System.out.println(answer);
	}
}
