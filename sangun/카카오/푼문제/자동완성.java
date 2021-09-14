package 푼문제;

import java.util.*;

public class 자동완성 {
    public static void main(String[] args) {
        String[] words = {"word","war","warrior","world"};
        int answer = 0;
        HashSet<String> word = new HashSet<>(Arrays.asList(words));
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> c = new HashMap<>();
        int len = 1;

        while (!word.isEmpty()) {
            for (String w : word) {
                String key;
                if (len >= w.length()) {
                    key = w;
                } else {
                    key = w.substring(0, len);
                }
                c.put(key, w);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
            Queue<String> q = new LinkedList<>();
            for (String k : map.keySet()) {
                if (map.get(k) == 1) {
                    q.add(k);
                    answer += k.length();
                    word.remove(c.get(k));
                    c.remove(k);
                }

                if (c.containsKey(k) && c.get(k).equals(k)) {
                    q.add(k);
                    answer += k.length();
                    word.remove(c.get(k));
                    c.remove(k);
                }
            }
            while (!q.isEmpty()) {
                map.remove(q.remove());
            }
            len++;
        }
        System.out.println(answer);

    }
}
