package Codility.Lessons.Lesson_5_Perfix_Sums.MinAvgTwoSlice;

class Solution {
    public int solution(int[] A) {
        float min = (A[0] + A[1]) / 2f;
        int ans = 0;
        for(int i = 2; i < A.length; i++) {
            float two = (A[i] + A[i - 1]) / 2f;
            if(two < min) {
                min = two;
                ans = i - 1;
            }
            float three = (A[i] + A[i - 1] + A[i - 2]) / 3f;
            if(three < min) {
                min = three;
                ans = i - 2;
            }
        }
        return ans;
    }
}

