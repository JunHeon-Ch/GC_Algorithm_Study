package 프로그래머스.lv2.전화번호목록;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> list = new HashMap<>();
        for(int i=0; i<phone_book.length; i++)
            list.put(phone_book[i],i);

        for(int i=0; i<phone_book.length; i++){
            for(int j=1; j<phone_book[i].length(); j++){
                if(list.containsKey(phone_book[i].substring(0,j)))
                    return false;
            }
        }
        return answer;
    }

}