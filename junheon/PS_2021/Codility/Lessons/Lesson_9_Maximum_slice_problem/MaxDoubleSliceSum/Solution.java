package PS_2021.Codility.Lessons.Lesson_9_Maximum_slice_problem.MaxDoubleSliceSum;

class Solution {
    public int solution(int[] A) {
        if(A.length == 3) return 0;

        int[] left = new int[A.length];
        int[] right = new int[A.length];
        for(int i = 1; i < A.length - 1; i++) {
            left[i] = Math.max(left[i - 1] + A[i], 0);
        }
        for(int i = A.length - 2; i >= 1; i--) {
            right[i] = Math.max(right[i + 1] + A[i] , 0);
        }
        int ans = 0;
        for(int i = 1; i < A.length - 1; i++) {
            ans = Math.max(left[i - 1] + right[i + 1], ans);
        }
        return ans;
    }
}
