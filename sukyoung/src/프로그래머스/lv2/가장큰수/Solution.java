package 프로그래머스.lv2.가장큰수;

import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        String answer = "";

        String str_numbers[] = new String[numbers.length];
        for(int i=0; i<str_numbers.length; i++) {
            str_numbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str_numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if(str_numbers[0].startsWith("0")) {
            answer += "0";
        } else {
            for(int j=0; j<str_numbers.length; j++) {
                answer += str_numbers[j];
            }
        }

        return answer;
    }

}
