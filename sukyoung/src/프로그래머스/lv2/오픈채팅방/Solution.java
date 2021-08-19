package 프로그래머스.lv2.오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        HashMap<String, String> userInfo = new HashMap<>();
        ArrayList<String> chatLog = new ArrayList<>();

        for(int i=0; i<record.length; i++){
            String[] info = record[i].split(" ");

            if(info[0].equals("Enter")){
                userInfo.put(info[1], info[2]);
                chatLog.add(info[1] + "님이 들어왔습니다.");
            }else if(info[0].equals("Leave")){
                chatLog.add(info[1] + "님이 나갔습니다.");
            }else{
                userInfo.put(info[1], info[2]);
            }
        }

        String[] answer = new String[chatLog.size()];
        int logIdx = 0;

        for(String str : chatLog){
            int endOfId = str.indexOf("님");
            String userId = str.substring(0, endOfId);

            answer[logIdx++] = str.replace(userId, userInfo.get(userId));
        }

        return answer;
    }
}