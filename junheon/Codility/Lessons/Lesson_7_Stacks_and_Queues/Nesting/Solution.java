package Codility.Lessons.Lesson_7_Stacks_and_Queues.Nesting;

class Solution {
    public int solution(String S) {
        if(S.length() % 2 == 1) return 0;

        int cnt = 0;
        for(char c : S.toCharArray()) {
            if(c == '(') cnt++;
            else cnt--;
            if(cnt < 0) return 0;
        }
        if(cnt == 0) return 1;
        else return 0;
    }
}

