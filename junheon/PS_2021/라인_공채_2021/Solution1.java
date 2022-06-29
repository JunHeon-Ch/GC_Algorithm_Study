package PS_2021.라인_공채_2021;

import java.util.*;

class Solution1 {

    List<Integer> list = new ArrayList<>();
    boolean[][] visit;
    int ans = 0;

    public int solution(int[] student, int k) {
        int n = student.length;
        int len = 0;
        for(int i = 0; i < n; i++) {
            if(student[i] == 1) {
                list.add(i);
                len++;
            }
        }

        visit = new boolean[n][n];
        for(int i : list) {
            make(i, i, n, student, k, 1);
        }

        return ans;
    }

    private void make(int left, int right, int n, int[] student, int k, int cnt) {
        if(cnt == k) ans++;
        if(left - 1 >= 0 && !visit[left - 1][right]) {
            visit[left - 1][right] = true;
            if(student[left - 1] == 1) {
                if(cnt == k) return;
                make(left - 1, right, n, student, k, cnt + 1);
            } else {
                make(left - 1, right, n, student, k, cnt);
            }
        }
        if(right + 1 < n && !visit[left][right + 1]) {
            visit[left][right + 1] = true;
            if(student[right + 1] == 1) {
                if(cnt == k) return;
                make(left, right + 1, n, student, k, cnt + 1);
            } else {
                make(left, right + 1, n, student, k, cnt);
            }
        }
    }
}