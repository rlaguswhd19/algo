package programmers.level3;

import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {
	static Set<String> set;
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		System.out.println(solution(user_id, banned_id));
	}
	
	static int solution(String[] user_id, String[] banned_id) {
		set = new HashSet<>();
        rec(0, user_id, banned_id, new boolean[user_id.length]);
        return set.size();
	}
	
	static void rec(int depth, String[] user_id, String[] banned_id, boolean[] visit){
        if(depth == banned_id.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<visit.length; i++){
                sb.append(visit[i] ? 1 : 0);
            }
            set.add(sb.toString());
            return;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(visit[i] || banned_id[depth].length() != user_id[i].length()) continue;
            boolean check = true;   // 매칭되면 true
            for(int j=0; j<user_id[i].length(); j++){
                if(banned_id[depth].charAt(j) == '*') continue;
                if(banned_id[depth].charAt(j) != user_id[i].charAt(j)) {
                    check = false;
                    break;
                }
            }
            if(check){
                visit[i] = true;
                rec(depth+1, user_id, banned_id, visit);
                visit[i] = false;
            }
        }
    }
}
