package Codility.Lessons.Lesson_4_Counting_Elements.FrogRiverOne;

class Solution {
    public int solution(int X, int[] A) {
        boolean[] check = new boolean[X + 1];
        int res = 0, ans = -1;
        for(int i = 0; i < A.length; i++) {
            if(!check[A[i]]) {
                res++;
                check[A[i]] = true;
            }
            if(res == X) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
