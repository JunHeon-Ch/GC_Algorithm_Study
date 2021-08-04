package Codility.Lessons.Lesson_4_Counting_Elements.MaxCounters;

class Solution {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0, base = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == N + 1) {
                base = max;
            } else {
                if(counters[A[i] - 1] < base) counters[A[i] - 1] = base;
                counters[A[i] - 1]++;
                if(max < counters[A[i] - 1]) max = counters[A[i] - 1];
            }
        }
        for(int i = 0; i < N; i++) {
            if(counters[i] < base) counters[i] = base;
        }

        return counters;
    }
}
