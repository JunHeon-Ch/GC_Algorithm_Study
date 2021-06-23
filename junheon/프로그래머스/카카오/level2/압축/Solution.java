package 프로그래머스.카카오.level2.압축;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    public int[] solution(String msg) {
        HashMap<String, Integer> dict = new HashMap<>();
        int i;
        for (i = 0; i < 26; i++) {
            String key = Character.toString((char) ('A' + i));
            dict.put(key, i + 1);
        }

        ArrayList<Integer> index = new ArrayList<>();
        int j = 0;
        while (j < msg.length()) {
            int n = 1;
            String key = new String();
            while (j + n <= msg.length() && dict.containsKey(msg.substring(j, j + n))) {
                key = msg.substring(j, j + n);
                n++;
            }
            index.add(dict.get(key));
            if (j + n <= msg.length()) dict.put(msg.substring(j, j + n), ++i);
            j += n - 1;
        }

        int[] answer = new int[index.size()];
        for (i = 0; i < index.size(); i++) answer[i] = index.get(i);
        return answer;
    }
}