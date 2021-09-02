package 프로그래머스.level2.위장;

import java.util.*;

class Best_Solution {

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            String category = cloth[1];
            if(map.containsKey(category)) map.put(category, map.get(category) + 1);
            else map.put(category, 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        int ans = 1;
        for(int val : values) {
            ans *= (val + 1);
        }
        return ans - 1;
    }

}