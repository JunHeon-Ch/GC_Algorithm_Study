package 릿코드.roman_to_int;

public class Solution {
    public int romanToInt(String s) {
        int ans = 0;

        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] value = {1, 5, 10, 50, 100, 500, 1000};

        for(int i=0; i<s.length()-1; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);

            int idx1=0, idx2=0;
            for(int j=0; j<7; j++){
                if(symbol[j] == c1)
                    idx1 = j;
                else if(symbol[j] == c2)
                    idx2 = j;
            }

            if(idx1 < idx2)
                ans -= value[idx1];
            else
                ans += value[idx1];
        }
        for(int j=0; j<7; j++){
            if(symbol[j] == s.charAt(s.length()-1))
                ans += value[j];
        }

        return ans;
    }
}
