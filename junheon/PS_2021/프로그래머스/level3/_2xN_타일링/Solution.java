package PS_2021.프로그래머스.level3._2xN_타일링;

/*
https://programmers.co.kr/learn/courses/30/lessons/12900
 * 알고리즘: DP
 * D(n) = 가로2, 세로1 타일을 사용해 가로 n, 세로2 바닥을 채우는 방법의 수
 * D[i] = D[i - 1] + D[i - 2] 3 <= i < n
 * 시간복잡도: O(n), n=60,000
 */

class Solution {
    public int solution(int n) {
        int[] d = new int[n + 1];
        d[1] = 1; d[2] = 2;
        for(int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000007;
        }
        return d[n];
    }
}