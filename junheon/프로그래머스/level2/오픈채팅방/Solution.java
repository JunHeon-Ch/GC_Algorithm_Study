package 프로그래머스.level2.오픈채팅방;

import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();

        int cnt = 0;
        for(int i = record.length - 1; i >= 0; i--) {
            String r = record[i];
            String flag = r.substring(0, r.indexOf(" "));
            if(flag.equals("Enter") || flag.equals("Change")) {
                String key = r.substring(r.indexOf(" ") + 1, r.lastIndexOf(" "));
                String value = r.substring(r.lastIndexOf(" ") + 1);
                if(!map.containsKey(key)) {
                    map.put(key, value);
                }
            }
            if(flag.equals("Enter") || flag.equals("Leave")) {
                cnt++;
            }
        }

        String[] answer = new String[cnt];
        int i = 0;
        for(String r : record) {
            String flag = r.substring(0, r.indexOf(" "));
            if (flag.equals("Enter")) {
                String key = r.substring(r.indexOf(" ") + 1, r.lastIndexOf(" "));
                String res = map.get(key) + "님이 들어왔습니다.";
                answer[i++] = res;
            }
            else if(flag.equals("Leave")) {
                String key = r.substring(r.indexOf(" ") + 1);
                String res = map.get(key) + "님이 나갔습니다.";
                answer[i++] = res;
            }
        }

        return answer;
    }
}
