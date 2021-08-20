package 프로그래머스.level2.멀쩡한_사각형;

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
