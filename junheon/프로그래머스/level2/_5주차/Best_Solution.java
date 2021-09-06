package 프로그래머스.level2._5주차;

import java.util.*;

class Best_Solution {

    List<String> list = new ArrayList<>();

    public int solution(String word) {
        solve("", 0);
        return list.indexOf(word);
    }

    private void solve(String res, int len) {
        if(len > 5) return;
        list.add(res);
        for(int i = 0; i < 5; i++) {
            solve(res + "AEIOU".charAt(i), len + 1);
        }
    }
}