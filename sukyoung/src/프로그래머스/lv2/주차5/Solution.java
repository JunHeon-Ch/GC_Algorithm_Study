package 프로그래머스.lv2.주차5;
import java.util.*;

class Solution {
    public boolean[] visit = new boolean[5];
    public String[] ans;
    public String[] alphabet = {"A","E","I","O","U"};

    public ArrayList<String> words = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;

        for(int i=1; i<=5; i++){
            ans = new String[i];
            permutation(0,i);
        }
        Collections.sort(words);
        //System.out.println(words);
        answer = words.indexOf(word) + 1;
        return answer;
    }
    public void permutation(int depth, int length){
        if(depth == length){
            String temp = "";
            for(String s: ans){
                temp += s;
            }
            words.add(temp);

            return;
        }
        for(int i=0; i<5; i++){
            ans[depth] = alphabet[i];
            permutation(depth+1, length);
        }
    }
}
