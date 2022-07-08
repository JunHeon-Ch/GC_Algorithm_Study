package PS_2022.Programmers.level2.가장_큰_수;

import java.util.*;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * 알고리즘: sort
 * 시간복잡도: O(m*nlogn), n=100,000(numbers 길이), m=4(numbers 원소의 길이)
 */

class Solution {
    public String solution(int[] numbers) {
        String[] num = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            num[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(num, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        if(num[0].equals("0")) return "0";
        String answer = "";
        for(int i = 0; i < num.length; i++) {
            answer += num[i];
        }
        return answer;
    }
}