package 프로그래머스.level2.나라의_숫자;

 class Solution {
     public String solution(int n) {
         String answer = "";
         String[] base = {"4", "1", "2"};
         int num = n;
         while(num > 0) {
             int mod = num % 3;
             num /= 3;
             if(mod == 0) num--;
             answer = base[mod] + answer;
         }
         return answer;
     }
 }
