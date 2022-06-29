package PS_2021.프로그래머스.level2.영어_끝말잇기;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        int cnt = 0;
        String prev = "";
        for(String now : words) {
            if(list.contains(now)) break;
            if(!prev.equals("") && prev.charAt(prev.length() - 1) != now.charAt(0)) break;
            cnt++;
            list.add(now);
            prev = now;
        }
        int[] ans = new int[2];
        if(cnt == words.length) {
            ans[0] = 0;
            ans[1] = 0;
        } else {
            cnt++;
            ans[0] = cnt % n == 0 ? n : cnt % n;
            ans[1] = (int)Math.ceil((double) cnt / n);
        }
        return ans;
    }
}
