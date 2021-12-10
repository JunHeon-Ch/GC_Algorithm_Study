package 프로그래머스.level3.다단계_칫솔_판매;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/77486
 * 알고리즘: 해시 + 구현?
 * 시간복잡도: O(n*m), n=seller의 길이(100,000), m=enroll의 길이(10,000)
 -> BUT, ammount가 최대 100(10,000원)이고 10%가 부모노드한테 가기 때문에 (10000, 1000, 100, 10, 1) 최대 5번까지 가능함
 -> 최종 시간복잡도는 O(n), n=seller의 길이(100,000)
 */

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 부모 노드 저장
        Map<String, String> ancestor = new HashMap<>();
        // 이름된 인덱스
        Map<String, Integer> index = new HashMap<>();
        for(int i = 0; i < enroll.length; i++) {
            ancestor.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }

        int[] answer = new int[enroll.length];
        for(int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int profit = amount[i] * 100;
            // 부모노드가 없을 때까지 올라감
            while(!name.equals("-") && profit > 0) {
                answer[index.get(name)] += profit - (int) (profit * 0.1);
                name = ancestor.get(name);
                profit *= 0.1;
            }
        }
        return answer;
    }
}