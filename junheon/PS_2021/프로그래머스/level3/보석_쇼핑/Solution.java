package PS_2021.프로그래머스.level3.보석_쇼핑;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/67258
 * 알고리즘: 투포인터
 * 시간복잡도: O(n), n=100,000(gems 배열 크기)
 */

class Solution {
    public int[] solution(String[] gems) {
        // 총 보석 종류의 수
        Set<String> set = new HashSet<>();
        for (String g : gems) {
            set.add(g);
        }
        int count = set.size();

        int n = gems.length;
        // s -> 시작 / e -> 끝
        int s = 0, e = -1;
        int[] answer = new int[2];
        int minLen = Integer.MAX_VALUE;
        // key -> 보석 종류 / value -> 보석의 수
        Map<String, Integer> map = new HashMap<>();
        while (true) {
            if (e != n - 1 && map.size() < count) {
                // e가 마지막 요소가 아니고 해당 구간(s~e)에 모든 보석이 포함되어 있지 않은 경우
                e++;
                // 보석 종류 추가
                if (map.containsKey(gems[e])) map.put(gems[e], map.get(gems[e]) + 1);
                else map.put(gems[e], 1);
            } else if (s != n - 1 && map.size() == count) {
                // s가 마지막 요소가 아니고 이미 해당 구간(s~e)에 모든 보석이 포함되어 있는 경우
                map.put(gems[s], map.get(gems[s]) - 1);
                if (map.get(gems[s]) == 0) map.remove(gems[s]);
                s++;
            }

            if (map.size() == count) { // 해당 구간에 모든 보석이 포함되어 있는 경우
                if (minLen > e - s) {
                    minLen = e - s;
                    answer[0] = s + 1;
                    answer[1] = e + 1;
                }
            } else if (map.size() < count && (s == n - 1 || e == n - 1)) break;
        }
        return answer;
    }
}