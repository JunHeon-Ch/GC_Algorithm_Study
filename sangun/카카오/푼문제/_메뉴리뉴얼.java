package 푼문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class _메뉴리뉴얼 {
    static HashMap<String, Integer> map;
    static boolean[] visited;

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};


        map = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                if (orders[i].length() < course[j]) continue;
                char[] test = new char[course[j]];
                visited = new boolean[orders[i].length()];
                go(orders[i].toCharArray(), test, 0, 0, course[j]);
                System.out.println("--");
            }
        }
        ArrayList<String>[] temp = new ArrayList[course.length];
        int[] max = new int[course.length];
        ArrayList<String> arr = new ArrayList<>();

        for (String key : map.keySet()) {
            if (map.get(key) == 1) continue;
            System.out.println();

            for (int i = 0; i < course.length; i++) {
                if (key.length() == course[i]) {
                    if (max[i] < map.get(key)) {
                        temp[i] = new ArrayList<>();
                        System.out.println(temp);
                        temp[i].add(key);
                        max[i] = map.get(key);
                    } else if (max[i] == map.get(key)) {
                        temp[i].add(key);
                    }
                }
            }
        }
        for (ArrayList<String> k : temp) {
            if (k != null) {
                arr.addAll(k);
            }
        }
        Collections.sort(arr);
        System.out.println(arr);
        String[] answer = arr.toArray(new String[arr.size()]);

        for (String k : answer) {
            System.out.println(k);
        }


    }

    static void go(char[] s, char[] result, int index, int selected, int size) {
        if (selected == size) {
            char[] a = result.clone();
            Arrays.sort(a);
            String key = String.valueOf(a);

            if (map.containsKey(key)) {
                int cnt = map.get(key) + 1;
                map.put(key, cnt);
            } else {
                map.put(key, 1);
            }
            return;
        }
        if (index >= s.length) return;
        System.out.println(String.valueOf(result));
        result[selected] = s[index];
        go(s, result,index+1,selected+1,size);
        go(s, result,index+1,selected,size);
    }

}
