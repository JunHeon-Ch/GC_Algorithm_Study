package PS_2021.LG유플러스_수채_2022;

/*
 * 돼지 삼형제가 음식을 나누어 먹는다. 1번 돼지는 x까지, 2번 돼지는 y까지, 3번 돼지는 n까지 먹는다. (1 <= x < y < n)
 * 이때 삼형제가 같은 양을 먹을 수 있는 경우의 수를 구하라.
 * 음식의 양은 음수일 수 있다. (-100,000 < 음식의 양 < 100,000)

 * 알고리즘: 누적합
 * 시간복잡도: O(n), n=foods 배열 길이(500,000)
 */

class Solution3 {

    public int solution(int[] foods) {
        int n = foods.length;
        if(n < 3) return 0; // 3마리의 돼지가 모두 최소 하나씩 먹어야하기 때문에 배열 길이가 3보다 작을 경우 불가능 (1 <= x < y < n)

        long[] cum = new long[n]; // 누적합을 위한 배열
        for(int i = 0; i < n; i++) { // 누적합
            if(i == 0) cum[i] = foods[i];
            else cum[i] = cum[i - 1] + foods[i];
        }
        if(cum[n - 1] % 3 != 0) return 0; // 3마리의 돼지가 같은 양을 먹어야 하기 때문에 총 합이 3으로 나누어지지 않을 경우 불가능

        long pig1 = cum[n - 1] / 3; // 첫번째 돼지가 먹는 양
        long pig2 = pig1 * 2; // 첫번째 + 두번째 돼지가 먹는 양
        int ans = 0, cnt = 0;
        for(int i = 0; i < n; i++) {
            if(cum[i] == pig1) cnt++; // 첫번째 돼지가 먹을 수 있는 위치
            else if(cum[i] == pig2) ans += cnt; // 첫번째, 두번째, 세번째 돼지가 모두 공평하게 먹을 수 있는 위치
        }
        return ans;
    }
}
