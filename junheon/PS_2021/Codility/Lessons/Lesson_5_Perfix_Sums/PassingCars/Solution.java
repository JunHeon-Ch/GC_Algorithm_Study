package PS_2021.Codility.Lessons.Lesson_5_Perfix_Sums.PassingCars;

class Solution {
    public int solution(int[] A) {
        int zero = 0;
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) zero++;
            else if(A[i] == 1) ans += zero;

            if(ans > 1000000000) return -1;
        }
        return ans;
    }
}