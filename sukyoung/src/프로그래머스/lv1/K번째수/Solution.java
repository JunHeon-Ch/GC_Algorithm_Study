package 프로그래머스.lv1.K번째수;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> ans;
        for(int i=0; i<commands.length; i++){
            ans = new ArrayList<Integer>();
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                ans.add(array[j]);
            }
            Collections.sort(ans);
            answer[i] = ans.get(commands[i][2]-1);
        }
        return answer;
    }
}
