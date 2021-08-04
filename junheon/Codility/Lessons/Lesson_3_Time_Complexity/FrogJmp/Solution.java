package Codility.Lessons.Lesson_3_Time_Complexity.FrogJmp;

class Solution {
    public int solution(int X, int Y, int D) {
        return (int) Math.ceil((double) (Y - X) / D);
    }
}
