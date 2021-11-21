package 릿코드.palindrome;

public class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;

            String number = Integer.toString(x);
            int length = number.length();
            for (int i = 0; i < length / 2; i++) {
                if (number.charAt(i) != number.charAt(length - (i + 1)))
                    return false;

            }

            return true;

        }
}
