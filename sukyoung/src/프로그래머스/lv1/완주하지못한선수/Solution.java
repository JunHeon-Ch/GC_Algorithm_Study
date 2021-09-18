package 프로그래머스.lv1.완주하지못한선수;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        return participant[participant.length-1];
    }
}
