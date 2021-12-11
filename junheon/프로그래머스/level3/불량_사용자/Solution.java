package 프로그래머스.level3.불량_사용자;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/64064
 * 알고리즘: 완전탐색
 * 시간복잡도: O(n^n), n=8(user_id 배열의 크기)
 */

class Solution {

    // user_id 조합
    int[] seq;
    // 방문 여부
    boolean[] visit;
    // ban 리스트를 중복없이 저장하기 위한 Set
    Set<List<String>> set;

    public int solution(String[] user_id, String[] banned_id) {
        seq = new int[banned_id.length];
        visit = new boolean[user_id.length];
        set = new HashSet<>();
        solve(0, user_id, banned_id);
        return set.size();
    }

    public void solve(int index, String[] user_id, String[] banned_id) {
        if(index == banned_id.length) {
            if(possible(user_id, banned_id)) {
                List<String> list = new ArrayList<>();
                for(int i = 0; i < banned_id.length; i++) {
                    list.add(user_id[seq[i]]);
                }
                Collections.sort(list);
                set.add(list);
            }
            return;
        }
        // banned_id 배열의 크기만큼 user_id의 조합을 만든다.
        for(int i = 0; i < user_id.length; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            seq[index] = i;
            solve(index + 1, user_id, banned_id);
            visit[i] = false;
        }
    }

    // user_id의 조합이 ban 규칙을 모두 지키는지 확인
    public boolean possible(String[] user_id, String[] banned_id) {
        for(int i = 0; i < banned_id.length; i++) {
            String user = user_id[seq[i]];
            String ban = banned_id[i];
            if(user.length() != ban.length()) return false;
            int j;
            for(j = 0; j < user.length(); j++) {
                if(ban.charAt(j) == '*') continue;
                if(ban.charAt(j) != user.charAt(j)) return false;
            }
        }
        return true;
    }
}