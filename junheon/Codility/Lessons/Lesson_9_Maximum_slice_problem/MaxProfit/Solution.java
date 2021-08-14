package Codility.Lessons.Lesson_9_Maximum_slice_problem.MaxProfit;

class Solution {
    public int solution(int[] A) {
        int ans = 0;
        int now = 0, i = 1;
        while(i < A.length) {
            if(A[now] > A[i]) now = i;
            else if(A[now] < A[i]) ans = Math.max(ans, A[i] - A[now]);
            i++;
        }
        return ans;
    }
}
