package 프로그래머스.level2.전화번호_목록;

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = phone_book.length - 1; i > 0; i--) {
            String prefix = phone_book[i - 1];
            String cur = phone_book[i];
            if(cur.length() < prefix.length()) continue;
            if(cur.startsWith(prefix)) return false;
        }
        return true;
    }
}
