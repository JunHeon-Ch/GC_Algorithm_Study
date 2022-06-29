package PS_2021.프로그래머스.level3.단속카메라;

import java.util.Arrays;
import java.util.Comparator;

class Best_Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int end = Integer.MIN_VALUE;
        for (int[] r : routes) {
            if (end < r[0]) {
                ++ans;
                end = r[1];
            }
        }
        return ans;
    }
}