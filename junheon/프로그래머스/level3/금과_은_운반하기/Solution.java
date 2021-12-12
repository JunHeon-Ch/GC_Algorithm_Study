package 프로그래머스.level3.금과_은_운반하기;

/*
https://programmers.co.kr/learn/courses/30/lessons/86053
해설: https://prgms.tistory.com/101
풀이: https://hyunjiishailey.tistory.com/431
 * 알고리즘: 이분탐색
 * 시간복잡도: O(n*logm) n=100,000(도시 개수),
 * m=10e14*4(최대 시간) -> a, b의 최대치: 각각 1e9 -> 2*1e9, 최대 이동 시간: 1e5 -> 왕복: 2*1e5
 */

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int n = g.length;
        long answer = (long) (1e9 * 2 * 1e5 * 2);
        long start = 0;
        long end = answer;
        while(start <= end) {
            long mid = (start + end) / 2;
            long sumG = 0, sumS = 0, sumGS = 0;

            for(int i = 0; i < n; i++) {
                long curG = g[i];
                long curS = s[i];
                long curW = w[i];
                long curT = t[i];

                long moveCnt = mid / (curT * 2);
                // 편도로 한 번 더 갈 수 있으면 1번 추가
                if(mid % (curT * 2) >= curT) moveCnt++;

                sumG += Math.min(curG, moveCnt * curW);
                sumS += Math.min(curS, moveCnt * curW);
                sumGS += Math.min(curG + curS, moveCnt * curW);
            }
            if(a <= sumG && b <= sumS && a + b <= sumGS) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            } else start = mid + 1;
        }
        return answer;
    }
}