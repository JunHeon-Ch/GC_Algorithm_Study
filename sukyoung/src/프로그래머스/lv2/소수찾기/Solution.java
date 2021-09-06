package 프로그래머스.lv2.소수찾기;

import java.util.*;

class Solution {
    public int answer = 0;
    public boolean[] visit = new boolean[10];
    public ArrayList<Integer> list = new ArrayList<>();

    public int solution(String numbers) {
        String tmp = "";

        for(int i=0; i<numbers.length(); i++){
            getCombi(numbers, tmp, i+1);
        }
        for(int i=0; i<list.size(); i++){
            is_prime(list.get(i));
        }
        return answer;
    }
    public void getCombi(String str, String tmp, int length){
        if(tmp.length() == length){
            int num = Integer.parseInt(tmp);
            if(!list.contains(num))
                list.add(num);

            return;
        }
        for(int i=0; i<str.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                tmp += str.charAt(i);
                getCombi(str, tmp, length);
                visit[i] = false;
                tmp = tmp.substring(0, tmp.length()-1);
            }
        }
    }
    public void is_prime(int n){
        if(n==0 || n==1) return;
        for(int i=2; i<n ; i++){
            if(n % i == 0) return;
        }
        answer++;
    }
}