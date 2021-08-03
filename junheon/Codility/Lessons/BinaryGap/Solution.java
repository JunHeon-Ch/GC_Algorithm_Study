package Codility.Lessons.BinaryGap;

class Solution {
    public int solution(int N) {
        int ans = 0, res = 0, prev = 2;
        boolean flag = false;
        while(N > 0) {
            int now = N & 1;
            if (now == 1) {
                if(prev == 0 && flag) ans = Math.max(ans, res);
            } else {
                if(prev == 1) {
                    res = 1;
                    flag = true;
                }
                else if (prev == 0 && flag) res++;
            }
            prev = now;
            N >>= 1;
        }
        return ans;
    }
}
