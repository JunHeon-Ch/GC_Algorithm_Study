package PS_2021.카카오_공채_2021;

import java.util.Arrays;

class Solution4 {

    int max = -1;
    int[] ans;

    public int[] solution(int n, int[] you) {
        int[] me = Arrays.copyOf(you, you.length);
        ans = new int[you.length];
        solve(you, me, n, 0, 0);
        if (max == -1) return new int[]{-1};
        return ans;
    }

    private void solve(int[] you, int[] me, int n, int cnt, int index) {
        if (cnt == n) {
            int youScore = 0, meScore = 0;
            for (int i = 0; i < me.length; i++) {
                if (you[i] == 0 && me[i] == 0) continue;
                if (me[i] < 0) {
                    meScore += 10 - i;
                } else if (me[i] >= 0) {
                    youScore += 10 - i;
                }
            }
            if (youScore < meScore) {
                if(max < meScore - youScore) {
                    max = meScore - youScore;
                    for (int i = 0; i < me.length; i++) {
                        ans[i] = you[i] - me[i];
                    }
                } else if(max == meScore - youScore) {
                    boolean flag = false;
                    for(int i = me.length - 1; i >= 0; i--) {
                        if(you[i] - me[i] > ans[i]) {
                            flag = true;
                            break;
                        } else if(you[i] - me[i] < ans[i]) break;
                    }
                    if(flag) {
                        for (int i = 0; i < me.length; i++) {
                            ans[i] = you[i] - me[i];
                        }
                    }
                }
            }
            return;
        }
        if(index >= me.length) return;
        if(me[index] >= 0) {
            me[index]--;
            if(me[index] == -1) {
                solve(you, me, n, cnt + 1, index + 1);
            } else {
                solve(you, me, n, cnt + 1, index);
            }
            me[index]++;
            solve(you, me, n, cnt, index + 1);
        }
    }
}