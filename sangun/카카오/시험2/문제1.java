package 시험2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class 문제1 {
    public static void main(String[] args) {

    }

    public static long paperCuttings(int textLength, List<Integer> starting, List<Integer> ending) {
        Map<String, Integer> set = new HashMap<>();
        for (int i = 0; i < starting.size(); i++) {
            String str = starting.get(i) + " " + ending.get(i);
            if (set.containsKey(str)) continue;
            set.put(str, i);
        }
        Pair[] s = new Pair[set.size()];
        int idx = 0;
        for (String key : set.keySet()) {
            s[idx++] = new Pair(starting.get(set.get(key)), ending.get(set.get(key)));
        }

        go(set.size(), 0, 0, new Pair[2], s);

        return ans;
    }

    static long ans = 0;
    static HashSet<String> set = new HashSet<>();

    static void go(int n, int index, int selected, Pair[] p, Pair[] pairs) {
        if (selected == 2) {
            if (p[0].start > p[1].start) {
                if (valid(p[1], p[0])) {
                    ans++;
                }
            } else if (p[0].start < p[1].start) {
                if (valid(p[0], p[1])) {
                    ans++;
                }
            }
            return;
        }
        if (index >= n) {
            return;
        }
        p[selected] = new Pair(pairs[index].start, pairs[index].end);
        go(n, index + 1, selected + 1, p, pairs);
        go(n, index + 1, selected, p, pairs);
    }

    // 시작이 빠른거 a
    static boolean valid(Pair a, Pair b) {
        return a.end < b.start;
    }

    static class Pair {
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
