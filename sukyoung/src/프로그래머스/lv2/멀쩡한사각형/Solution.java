package 프로그래머스.lv2.멀쩡한사각형;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;

        long gcd = gcd((long)w, (long)h);

        answer = ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);

        return answer;
    }
    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}