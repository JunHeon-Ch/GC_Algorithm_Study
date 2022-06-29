package PS_2021.프로그래머스.level2.조이스틱;

class Solution {
    public int solution(String name) {
        int max = name.length();
        boolean[] correct = new boolean[max];
        char[] n = name.toCharArray();
        int cur = 0;
        for (int i = 0; i < max; i++) {
            if (n[i] == 'A') {
                correct[i] = true;
                cur++;
            }
        }

        int ans = 0, now = 0;
        while (cur < max) {
            if (correct[now]) {
                int l = 0, r = 0;
                int rIdx = now;
                while (correct[rIdx]) {
                    rIdx++;
                    r++;
                    if (rIdx == max) rIdx = 0;
                }
                int lIdx = now;
                while (correct[lIdx]) {
                    lIdx--;
                    l++;
                    if (lIdx < 0) lIdx = max - 1;
                }
                if (l < r) {
                    ans += l;
                    now = lIdx;
                } else {
                    ans += r;
                    now = rIdx;
                }
            } else {
                int up = n[now] - 'A';
                int down = 'Z' - n[now] + 1;
                ans += Math.min(up, down);
                correct[now] = true;
                cur++;
            }
        }

        return ans;
    }
}