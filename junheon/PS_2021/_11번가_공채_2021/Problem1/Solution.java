package PS_2021._11번가_공채_2021.Problem1;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        int odd = 0, even = 0;
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 0; i--) {
            if(A[i] % 2 == 0 && even == 0) {
                even = A[i];
            } else if(A[i] % 2 != 0 && odd == 0) {
                odd = A[i];
            }
        }
        return odd + even;
    }
}
