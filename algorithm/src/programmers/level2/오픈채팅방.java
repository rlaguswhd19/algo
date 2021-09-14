package programmers.level2;

import java.util.*;

public class 오픈채팅방 {
    static HashMap<String, String> map;
    static Queue<Action> q;
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }
    static String[] solution(String[] record) {
        map = new HashMap<>();
        q = new LinkedList<>();
        String id, nick;
        char c;
        for(String r : record) {
            String[] arr = r.split(" ");
            c = arr[0].charAt(0);
            id = arr[1];

            switch (c) {
                case 'E' :
                    nick = arr[2];
                    map.put(id, nick);
                    q.add(new Action(id, true));
                    break;
                case 'C' :
                    nick = arr[2];
                    map.put(id, nick);
                    break;
                case 'L' :
                    q.add(new Action(id, false));
                    break;
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            Action action = q.poll();
            ans.add(map.get(action.id) + "님이 " +(action.enter ? "들어왔습니다." : "나갔습니다."));
        }

        return ans.toArray(new String[ans.size()]);
    }

    static class Action {
        String id;
        Boolean enter;

        public Action(String id, Boolean enter) {
            this.id = id;
            this.enter = enter;
        }
    }
}
