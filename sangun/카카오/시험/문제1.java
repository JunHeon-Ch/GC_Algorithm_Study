package 시험;

import javax.swing.*;
import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 문제1 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        Map<String, HashSet<String>> map = new HashMap<>();

        for (String id : id_list) {
            map.put(id, new HashSet<>());
        }

        for (String str : report) {
            String[] split = str.split(" ");
            map.get(split[1]).add(split[0]);

        }
        Map<String, Integer> ans = new HashMap<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() >= k) {
                for (String str : map.get(key)) {
                    if (ans.containsKey(str)) {
                        ans.put(str, ans.get(str) + 1);
                    } else {
                        ans.put(str, 1);
                    }
                }
            }
        }
        System.out.println(ans);
        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            if (ans.containsKey(id_list[i])) {
                answer[i] = ans.get(id_list[i]);
            } else {
                answer[i] = 0;
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
