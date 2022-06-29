package PS_2021.프로그래머스.level2.가장_큰_수;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(Integer.toString(numbers[i]));
        }
        Collections.sort(list, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (list.get(0).equals("0")) return "0";
        String answer = "";
        for (String s : list) {
            answer += s;
        }
        return answer;
    }
}