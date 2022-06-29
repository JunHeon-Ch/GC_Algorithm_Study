package PS_2021._11번가_공채_2021.Problem2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String S) {
        List<Integer> length = new ArrayList<>();
        char prev = 0;
        int cnt = 1;
        int max = 1;
        for(char c : S.toCharArray()) {
            if(prev == 0) {
                prev = c;
            }
            else {
                if(prev == c) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    length.add(cnt);
                    prev = c;
                    cnt = 1;
                }
            }
        }
        max = Math.max(max, cnt);
        length.add(cnt);

        int ans = 0;
        for(int len : length) {
            ans += max - len;
        }
        return ans;
    }
}
