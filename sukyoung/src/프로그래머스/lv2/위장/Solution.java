package 프로그래머스.lv2.위장;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> disguise = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            if(disguise.containsKey(clothes[i][1])){
                int cnt = disguise.get(clothes[i][1]) + 1;
                disguise.put(clothes[i][1], cnt);
            }
            else{
                disguise.put(clothes[i][1], 1);
            }
        }
        System.out.println(disguise);

        for(String key : disguise.keySet()){
            answer *= disguise.get(key) + 1;
        }
        return answer-1;
    }
}
