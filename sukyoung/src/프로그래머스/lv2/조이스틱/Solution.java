package 프로그래머스.lv2.조이스틱;

class Solution {
    public int solution(String name) {
        int answer = 0;

        int min_move = name.length()-1;
        int half = ((90 - 65) + 1) / 2;
        for(int i=0; i<name.length(); i++){
            int index = (int)name.charAt(i);
            if(index - 65 <= half)
                answer += index - 65;
            else
                answer += (90 - index) + 1;

            int next = i+1;
            while(next<name.length() && name.charAt(next) == 'A')
                next++;

            min_move = Math.min(min_move, i+name.length()-next + i);
        }
        answer += min_move;
        return answer;
    }
}
