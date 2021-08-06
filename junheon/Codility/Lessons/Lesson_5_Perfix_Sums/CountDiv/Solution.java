package Codility.Lessons.Lesson_5_Perfix_Sums.CountDiv;

class Solution {
    public int solution(int A, int B, int K) {
        int ans = B / K - A / K;
        if(A % K == 0) ans++;
        return ans;
    }
}