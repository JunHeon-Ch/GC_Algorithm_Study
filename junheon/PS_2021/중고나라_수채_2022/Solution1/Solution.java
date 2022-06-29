package PS_2021.중고나라_수채_2022.Solution1;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(long n) {
        String num = Long.toString(n);
        Set<Character> set = new HashSet<>();
        for(char c : num.toCharArray()) {
            if(c == '0') continue;
            set.add(c);
        }

        int answer = 0;
        for(char c : set) {
            int i = c - '0';
            if(n % i == 0) answer++;
        }
        return answer;
    }
}
