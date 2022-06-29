package PS_2021.프로그래머스.level2.예상_대진표;

class Solution {
    public int solution(int n, int a, int b) {
        int A, B;
        if(a < b) {
            A = a;
            B = b;
        } else {
            A = b;
            B = a;
        }
        int answer = 0;
        while(A != B) {
            A = (int) Math.ceil((double) A / 2);
            B = (int) Math.ceil((double) B / 2);
            answer++;
        }
        return answer;
    }
}