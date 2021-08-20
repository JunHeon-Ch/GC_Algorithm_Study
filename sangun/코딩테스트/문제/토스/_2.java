package 토스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _2 {
    public static void main(String[] args) {

        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int len = set.size();

        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int shortest = Integer.MAX_VALUE;

        while (end < gems.length) {
            if (!map.containsKey(gems[end])) {
                map.put(gems[end], 1);
            } else {
                map.put(gems[end], map.get(gems[end]) + 1);
            }

            end++;

            if (map.size() == len) {
                while (start < end) {
                    if (map.get(gems[start]) > 1) {
                        map.put(gems[start], map.get(gems[start]) - 1);
                        start++;
                    } else if (shortest > end - start) {
                        shortest = end - start;
                        answer[0] = start + 1;
                        answer[1] = end;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(answer));

    }
}
