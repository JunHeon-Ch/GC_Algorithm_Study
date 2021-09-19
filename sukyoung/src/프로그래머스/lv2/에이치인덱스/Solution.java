package 프로그래머스.lv2.에이치인덱스;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        int n = citations.length;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int cnt = citations.length - i;
            if(citations[i] >= cnt){
                answer = cnt;
                break;
            }
        }
        return answer;
    }
}
