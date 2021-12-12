package 프로그래머스.lv3.보석쇼핑;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> gemList = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        for(String gem: gems)
            gemList.add(gem);

        if(gemList.size() == 1){
            int[] answer = {1,1};
            return answer;
        }

        int[] answer = new int[2];
        boolean[] visit = new boolean[gemList.size()];

        int idx = 0;
        int left = 0, right = gems.length;
        for(int i=0; i<gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            queue.add(gems[i]);

            while(map.get(queue.peek()) > 1){
                map.put(queue.peek(), map.get(queue.poll()) - 1);
                idx++;
            }

            if (map.size() == gemList.size() && right > queue.size()) {
                right = queue.size();
                left = idx;
            }
        }

        return new int[] {left+1, left + right};
    }
}