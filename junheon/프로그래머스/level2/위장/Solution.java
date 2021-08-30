package 프로그래머스.level2.위장;

import java.util.*;

import java.util.*;

class Solution {

    private int ans = 0;

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            String category = cloth[1];
            if(map.containsKey(category)) map.put(category, map.get(category) + 1);
            else map.put(category, 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        solve(values, 0, 0, 1);
        return ans;
    }

    private void solve(List<Integer> values, int index, int selected, int res) {
        if(index >= values.size()) {
            if(selected != 0) ans += res;
            return;
        }
        solve(values, index + 1, selected + 1, res * values.get(index));
        solve(values, index + 1, selected, res);
    }
}