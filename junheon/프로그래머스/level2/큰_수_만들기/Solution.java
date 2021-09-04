package 프로그래머스.level2.큰_수_만들기;

// class Solution {
//     public String solution(String number, int k) {
//         StringBuilder ans = new StringBuilder();
//         char[] num = number.toCharArray();
//         for(int t = 1, idx = -1; t <= number.length() - k; t++) {
//             char max = '0';
//             for(int i = idx + 1; i < t + k; i++) {
//                 if(max < num[i]) {
//                     idx = i;
//                     max = num[i];
//                 }
//             }
//             ans.append(max);
//         }
//         return ans.toString();
//     }
// }


import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}