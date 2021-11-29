package 다시풀기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 보석쇼핑 {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = new int[2];

        int start = 0;
        int end = 0;

        HashSet<String> set = new HashSet<>();

        for (String str : gems) {
            set.add(str);
        }

        int len = set.size();

        HashMap<String, Integer> map = new HashMap<>();
        int maxLen = gems.length;

        for (int i = 0; i < gems.length; i++) {
            if (map.containsKey(gems[i])) {
                map.put(gems[i], map.get(gems[i]) + 1);
            } else {
                map.put(gems[i], 1);
            }

            while (end - start + 1 >= len && isValid(map, len)) {
                if (maxLen > end - start) {
                    maxLen = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                if (map.get(gems[start]) == 1) {
                    map.remove(gems[start]);
                } else {
                    map.put(gems[start], map.get(gems[start]) - 1);
                }

                start++;
            }
            end++;
        }
        answer[0]++;
        answer[1]++;

        System.out.println(Arrays.toString(answer));
    }

    static boolean isValid(HashMap<String, Integer> map, int len) {
        if (len != map.size()) return false;
        return true;
    }

}