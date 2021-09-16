package 푼문제;

import java.util.*;

public class 셔틀버스 {
    public static void main(String[] args) {
        int n = 3, t = 1, m = 5;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

        Arrays.sort(timetable);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < timetable.length; i++) {
            q.add(changeToInt(timetable[i]));
        }


        HashMap<Integer, Stack<Integer>> bus = new HashMap<>();
        int[] keys = new int[n];
        // make bus
        for (int i = 0; i < n; i++) {
            bus.put(540 + i * t, new Stack<>());
            keys[i] = 540 + i * t;
        }

        int key_cnt = 0;
        while (key_cnt < n) {
            if (q.isEmpty()) break;

            if (keys[key_cnt] >= q.peek() && bus.get(keys[key_cnt]).size() < m) {
                bus.get(keys[key_cnt]).add(q.remove());
            } else {
                key_cnt++;
            }


        }

        if (bus.get(keys[keys.length - 1]).size() < m) {
            System.out.println(changeToString(keys[keys.length - 1]));
        } else {
            System.out.println(changeToString(bus.get(keys[keys.length - 1]).peek() - 1));
        }

    }

    static int changeToInt(String key) {
        return Integer.parseInt(key.substring(0, 2)) * 60 + Integer.parseInt(key.substring(3));
    }

    static String changeToString(int key) {
        String result = "";
        int h = key / 60;
        int m = key % 60;
        if (h < 10) {
            result += "0";
        }
        result += h + ":";
        if (m < 10) {
            result += "0";
        }
        result += m;
        return result;
    }
}
