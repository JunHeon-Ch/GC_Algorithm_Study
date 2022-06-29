package PS_2022.Programmers.level2.멀쩡한_사각형;

/*
https://programmers.co.kr/learn/courses/30/lessons/62048
 * 알고리즘: 수학
 * 시간복잡도: O(logn), n=100,000,000(w,h 중 최대값)
    GCD 시간복잡도 -> logn
 */
class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h - (w + h - gcd(w, h));
        return answer;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
