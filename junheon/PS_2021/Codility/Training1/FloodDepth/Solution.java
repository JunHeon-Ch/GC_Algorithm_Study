package PS_2021.Codility.Training1.FloodDepth;

class Solution {
    public int solution(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            if(A[i] > left[i - 1]) left[i] = A[i];
            else left[i] = left[i - 1];
        }
        right[A.length - 1] = A[A.length - 1];
        for(int i = A.length - 2; i >= 0; i--) {
            if(A[i] > right[i + 1]) right[i] = A[i];
            else right[i] = right[i + 1];
        }
        int ans = 0;
        for(int i = 1; i < A.length - 1; i++) {
            if(left[i] != A[i] && right[i] != A[i]) {
                int res = Math.min(left[i], right[i]) - A[i];
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }
}

