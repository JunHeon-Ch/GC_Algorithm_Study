package PS_2021.데브매칭_실리콘밸리_2021.Problem3;

class Solution {

    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public long solution(long[] wave1, long[] wave2) {
        int l1 = wave1.length;
        int l2 = wave2.length;
        int len = l1 * l2 / gcd(l1, l2);
        long[] w1 = new long[len];
        long[] w2 = new long[len];
        int idx = 0;
        for(int k = 0; k < len / l1; k++) {
            for(int j = 0; j < l1; j++) {
                w1[idx++] = wave1[j];
            }
        }
        idx = 0;
        for(int k = 0; k < len / l2; k++) {
            for(int j = 0; j < l2; j++) {
                w2[idx++] = wave2[j];
            }
        }

        long ans = Long.MAX_VALUE;
        int cnt = 1;
        for(int n = 0; n < len; n++) {
            for(int m = 0; m < len; m++) {
                long res = 0;
                for(int i = 0; i < len; i++) {
                    res += Math.pow(w1[i] + w2[i], 2);
                }
                ans = Math.min(ans, res);
                long prev = w2[0];
                for(int i = 0; i < len - 1; i++) {
                    long tmp = w2[i + 1];
                    w2[i + 1] = prev;
                    prev = tmp;
                }
                w2[0] = prev;
            }
            long prev = w1[0];
            for(int i = 0; i < len - 1; i++) {
                long tmp = w1[i + 1];
                w1[i + 1] = prev;
                prev = tmp;
            }
            w1[0] = prev;
        }
        return ans;
    }
}