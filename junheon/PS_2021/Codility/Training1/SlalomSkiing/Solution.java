package PS_2021.Codility.Training1.SlalomSkiing;

// 최대한 많은 게이트를 지난다
// 방향전환 최대 2번

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        int[][] d = new int[N][3];
        for(int i = 0; i < N; i++) {
            d[i][0] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(A[i] > A[j]) {
                    // 방향 전환 0번
                    d[i][0] = Math.max(d[i][0], d[j][0] + 1);
                    // 방향전환 2번
                    if(d[j][1] > 0) {
                        d[i][2] = Math.max(d[i][2], d[j][1] + 1);
                        d[i][2] = Math.max(d[i][2], d[j][2] + 1);
                    }
                } else if(A[i] < A[j]) {
                    // 방향 전환 1번
                    d[i][1] = Math.max(d[i][1], d[j][0] + 1);
                    d[i][1] = Math.max(d[i][1], d[j][1] + 1);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                ans = Math.max(ans, d[i][j]);
            }
        }
        return ans;
    }
}
