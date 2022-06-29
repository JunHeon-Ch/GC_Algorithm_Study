package PS_2021._11번가_공채_2021.Problem3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : A) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        int ans = 0;
        for(int key : map.keySet()) {
            int val = map.get(key);
            ans += Math.min(val, Math.abs(key - val));
        }
        return ans;
    }
}
