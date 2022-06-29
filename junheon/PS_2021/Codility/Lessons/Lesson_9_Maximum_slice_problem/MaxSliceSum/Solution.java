package PS_2021.Codility.Lessons.Lesson_9_Maximum_slice_problem.MaxSliceSum;

class Solution {
    public int solution(int[] A) {
        int ans = A[0];
        int res = A[0], prev = A[0];
        for(int i = 1; i < A.length; i++) {
            res += A[i];
            if(res < prev) res = A[i];
            else ans = Math.max(ans, res);
            prev = res;
        }
        return ans;
    }
}
