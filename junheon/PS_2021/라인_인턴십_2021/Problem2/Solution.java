package PS_2021.라인_인턴십_2021.Problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 알고리즘: 그리디
 * x, y가 가장 작은 점부터 시작해서 가장 거리가 짧은 점을 찾는다.
 * 시간복잡도: O(n^2), n=100(x, y 배열의 길이)
 */

class Solution {
    public int solution(int[] x, int[] y) {
        int n = x.length;
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Point(x[i], y[i]));
        }
        // x, y가 가장 작은 점으로 sorting
        Collections.sort(list, (o1, o2) -> {
            if(o1.y == o2.y) return o1.x - o2.x;
            return o1.y - o2.y;
        });
        boolean[] v = new boolean[n];
        int idx = 0;
        int ans = 0;
        while(idx != -1) {
            v[idx] = true;
            Point now = list.get(idx);
            double min = Double.MAX_VALUE;
            int minIdx = -1;
            for(int j = 0; j < list.size(); j++) {
                if(v[j]) continue;
                Point p  = list.get(j);
                double res = Math.sqrt(Math.pow(now.x - p.x, 2) + Math.pow(now.y - p.y, 2));
                if(min > res) {
                    min = res;
                    minIdx = j;
                }
            }
            if(minIdx != -1) {
                ans = Math.max(ans, (int) Math.ceil(min));
            }
            idx = minIdx;
        }
        return ans;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}