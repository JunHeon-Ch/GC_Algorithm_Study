package 프로그래머스.level2.두개_이하로_다른_비트;

class Solution_Bit {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int i = 0;
        for(long n : numbers) {
            int idx = 0;
            while((n & (1l << idx)) != 0) idx++;
            long m = 1l << idx;
            answer[i++] = idx == 0 ? n + 1 : n + (m >> 1);
        }
        return answer;
    }
}