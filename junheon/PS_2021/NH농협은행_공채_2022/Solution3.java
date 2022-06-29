package PS_2021.NH농협은행_공채_2022;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public int solution(String[] grids, int t) {
        int len = grids.length;
        char[][] g = new char[len][len];
        for(int i = 0; i < len; i++) {
            g[i] = grids[i].toCharArray();
        }

        Set<Character> set = new HashSet<>();
        int ans = 0;
        for(int k = 2; k < len; k++) {
            if(len % k != 0) continue;
            boolean flag = true;
            for(int n = 0; n < len; n += k) {
                for(int m = 0; m < len; m += k) {
                    set.clear();
                    for(int i = n; i < n + k; i++) {
                        for(int j = m; j < m + k; j++) {
                            set.add(g[i][j]);
                        }
                    }
                    if(set.size() > t) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
            if(flag) ans = k;
        }
        return ans;
    }
}
