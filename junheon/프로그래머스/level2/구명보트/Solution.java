package 프로그래머스.level2.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int max = n - 1;
        int min = 0;
        int ans = 0;
        while(min <= max) {
            if(people[min] + people[max] <= limit)
                min++;
            max--;
            ans++;
        }
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> characters = map.keySet();
        Queue<Integer> pq = new PriorityQueue<>();

        return ans;
    }
}