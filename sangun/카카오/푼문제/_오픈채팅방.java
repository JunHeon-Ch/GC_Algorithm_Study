package 푼문제;

import java.util.ArrayList;
import java.util.HashMap;

public class _오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        ArrayList<String> ans = new ArrayList<>();

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        HashMap<String, String> last = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            if (str[0].equals("Enter")) {
                ans.add(cnt, str[2] + "님이 들어왔습니다.");
                last.put(str[1], str[2]);
            } else if (str[0].equals("Leave")) {
                ans.add(cnt, str[1] + "님이 나갔습니다.");
            } else {
                last.put(str[1], str[2]);
                continue;
            }


            if (map.containsKey(str[1])) {
                map.get(str[1]).add(cnt);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(cnt);
                map.put(str[1], arr);
            }
            cnt++;

        }

        for (String uid : last.keySet()) {
            ArrayList<Integer> arr = map.get(uid);
            String name = last.get(uid);
            for (int index : arr) {
                String[] temp = ans.get(index).split(" ");
                ans.remove(index);
                ans.add(index, name + "님이 " + temp[1]);
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
        String a = "asdasd";
        char[] b= a.toCharArray();

        System.out.println(String.valueOf(b));


    }
}
