package PS_2022.Programmers.level2._124_나라의_숫자;

/*
https://programmers.co.kr/learn/courses/30/lessons/12899
 * 알고리즘: 수학
 * 시간복잡도: O(n), n=500,000,000
 */
class Solution {
    public String solution(int n) {
        String answer = "";
        String[] base = {"4", "1", "2"};
        while(n > 0) {
            int mod = n % 3;
            n /= 3;
            if(mod == 0) n--;
            answer = base[mod] + answer;
        }
        return answer;
    }
}