package PS_2021.라인_공채_2021;

import java.util.*;

class Solution2 {
    public String solution(String[] research, int n, int k) {
        int len = research.length;
        int[][] count = new int[len][26];
        for(int i = 0; i < len; i++) {
            char[] arr = research[i].toCharArray();
            for(char c : arr) {
                count[i][c - 'a']++;
            }
        }

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = n;
        while(right <= len) {
            int[] sum = new int[26];
            for(int j = 0; j < 26; j++) {
                for(int i = left; i < right; i++) {
                    if(count[i][j] < k) {
                        sum[j] = 0;
                        break;
                    }
                    sum[j] += count[i][j];
                }
            }

            for(int i = 0; i < 26; i++) {
                if(sum[i] >= 2 * n * k) {
                    char c = (char) (i + 'a');
                    if(map.containsKey(c)) map.put(c, map.get(c) + 1);
                    else map.put(c, 1);
                }
            }
            left++;
            right++;
        }

        Set<Character> set = map.keySet();
        String ans = "None";
        int max = 0;
        for(char c : set) {
            if(max < map.get(c)) {
                max = map.get(c);
                ans = c + "";
            }
        }
        return ans;
    }
}