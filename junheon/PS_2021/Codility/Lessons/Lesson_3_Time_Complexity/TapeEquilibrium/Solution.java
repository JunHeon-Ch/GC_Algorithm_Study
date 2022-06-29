package PS_2021.Codility.Lessons.Lesson_3_Time_Complexity.TapeEquilibrium;

class Solution {
    public int solution(int[] A) {
        int n = A.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += A[i];
            leftSum[i] = sum;
        }
        sum = 0;
        for(int i = n - 1; i >= 0; i--) {
            sum += A[i];
            rightSum[i] = sum;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++) {
            int res = Math.abs(leftSum[i] - rightSum[i + 1]);
            ans = Math.min(ans, res);
        }
        return ans;
    }
}
