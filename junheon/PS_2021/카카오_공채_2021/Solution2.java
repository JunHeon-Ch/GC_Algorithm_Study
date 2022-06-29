package PS_2021.카카오_공채_2021;

import java.util.*;

class Solution2 {
    public static int solution(int n, int k) {
        List<Character> list = new ArrayList<>();
        while (n > 0) {
            list.add((char) ((n % k) + '0'));
            n /= k;
        }
        Collections.reverse(list);
        String base = "";
        for (char c : list) {
            base += c;
        }

        List<Long> prime = new ArrayList<>();
        int firstIdx = 0;
        int lastIdx = 0;
        while (firstIdx < base.length() && lastIdx != -1) {
            lastIdx = base.indexOf("0", firstIdx);
            if(firstIdx == lastIdx) {
                firstIdx++;
                continue;
            }
            if (lastIdx != -1) {
                prime.add(Long.parseLong(base.substring(firstIdx, lastIdx)));
            } else {
                prime.add(Long.parseLong(base.substring(firstIdx)));
            }
            firstIdx = lastIdx + 1;
        }

        int answer = 0;
        for (long p : prime) {
            if (p == 1) continue;
            long i;
            boolean flag = false;
            for (i = 2; i * i <= p; i++) {
                if (p % i == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }
        return answer;
    }
}