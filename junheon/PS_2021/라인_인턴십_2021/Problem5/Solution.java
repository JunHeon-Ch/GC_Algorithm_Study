package PS_2021.라인_인턴십_2021.Problem5;

/*
 * 알고리즘: 문자열, 재귀
 * 문제 파악이 가장 중요한 문제
 * AAB로 시작하는 경우와 BAB로 시작하는 경우를 나눠서 생각해야 함
 * 시간복잡도: O(n*m), n=200(strs 길이), m=200(strs 원소 길이)
 */

class Solution {

    public int ans = 0;

    public int solution(String[] strs) {
        for(String str : strs) {
            solve(str);
        }
        return ans;
    }

    public void solve(String str) {
        if(str.length() == 0) {
            ans++;
            return;
        }
        if(str.startsWith("AAB")) { // AAB~
            int i = 3;
            // AAB, AABB, AABBB, ... 어디서 끊어야 할지 모름
            // 재귀로 확인
            while(i < str.length() && str.charAt(i) == 'B') {
                solve(str.substring(i));
                i++;
            }
            // A가 나온 경우
            solve(str.substring(i));
        } else if(str.startsWith("BAB")) { // BAB~A
            // 무조건 BAB로 시작해서 A로 끝나야 함
            int i = 3;
            // A 찾기
            while(i < str.length() && str.charAt(i) == 'B') i++;
            // B만 계속 있는 경우
            if(i == str.length()) return;
            // A 이후로 다시 시작
            solve(str.substring(i + 1));
        }
    }
}