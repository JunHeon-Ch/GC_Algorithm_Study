package Codility.Training1.LongestPassword;

import java.util.StringTokenizer;

class Solution {
    public int solution(String S) {
        StringTokenizer st = new StringTokenizer(S);
        int ans = -1;
        while(st.hasMoreElements()) {
            String password = st.nextToken();
            int alpha = 0, digit = 0, size = password.length();
            for(char c : password.toCharArray()) {
                if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) alpha++;
                else if(c >= '0' && c <= '9') digit++;
                else break;
            }
            if(alpha + digit != size) continue;
            if(alpha % 2 != 0) continue;
            if(digit % 2 == 0) continue;
            if(ans == -1 || ans < size) ans = size;
        }
        return ans;
    }
}