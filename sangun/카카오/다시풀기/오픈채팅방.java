package 다시풀기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        ArrayList<String> seq = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (String r : record) {
            String[] split = r.split(" ");
            String command = split[0];
            String uid = split[1];

            if (command.equals("Enter")) {
                String name = split[2];
                map.put(uid, name);
                seq.add(0 + uid);
            } else if (command.equals("Change")) {
                String name = split[2];
                map.put(uid, name);
            } else {
                seq.add(1 + uid);
            }
        }
        String[] answer = new String[seq.size()];

        int idx = 0;
        for (String str : seq) {
            if (str.charAt(0) == '1') {
                answer[idx++] = map.get(str.substring(1)) + "님이 나갔습니다.";
            } else {
                answer[idx++] = map.get(str.substring(1)) + "님이 들어왔습니다.";
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
