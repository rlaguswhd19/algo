package programmers.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        solution(enroll, referral, seller, amount);
    }

    static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> map = new HashMap<>();
        String s, e;
        for (int i = 0; i < enroll.length; i++) {
            s = enroll[i];
            e = referral[i];
            map.put(s, e);
        }

        Map<String, Integer> answer = new HashMap<>();
        int mok, calMoney, money, sum;
        for (int i = 0; i < seller.length; i++) {
            String per = seller[i];
            money = amount[i] * 100;

            while (true) { // 추천인이 없는 경우
                // 돈계산
                mok = money / 10;


                if (per.equals("-")) {
                    break;
                }

                calMoney = money - mok;

                if (!answer.containsKey(per)) { // 처음이면
                    answer.put(per, calMoney);
                } else { // 처음이 아니면
                    sum = answer.get(per);
                    answer.put(per, sum + calMoney);
                }

                per = map.get(per);
                if(mok == 0) {
                    break;
                }
                money = mok;
            }
        }

        int[] ans = new int[enroll.length];
        int idx = 0;
        for (String per : enroll) {
            if (answer.containsKey(per)) {
                ans[idx++] = answer.get(per);
            } else {
                ans[idx++] = 0;
            }
        }

        return ans;
    }
}
