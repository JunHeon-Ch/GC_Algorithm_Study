package PS_2021.중고나라_수채_2022.Solution2;

class Solution {
    public int solution(int[] s) {
        int prev = s[0];
        int answer = 0;
        boolean increment = true;
        for(int i = 1; i < s.length; i++) {
            if(increment) {
                if(prev < s[i]) increment = false;
                else answer++;
            } else {
                if(s[i] < prev) increment = true;
                else answer++;
            }
            prev = s[i];
        }
        return answer;
    }
}