package 다시풀기;


import java.util.*;


public class 셔틀버스 {
    public static void main(String[] args) {
        int n = 2, t = 10, m = 2;
        String[] timetable = {"09:10", "09:09", "08:00"};
        ArrayList<Integer> time = new ArrayList<>();
        for (int i = 0; i < timetable.length; i++) {
            time.add(convert(timetable[i]));
        }
        Collections.sort(time);
        int index = 0;
        int tsh = convert("09:00");
        Stack<Integer>[] stack = new Stack[n];
        for (int i = 0; i < n; i++) {
            stack[i] = new Stack<>();
        }

        for (int i = 0; i < n; i++) {
            int tmp = index;
            while (index < tmp + m) {
                if (index >= time.size()) break;
                if (time.get(index) <= tsh) {
                    stack[i].push(time.get(index));
                } else {
                    break;
                }
                index++;
            }
            tsh += t;
        }

        String answer = "";
        if (m > stack[n - 1].size()) {
            answer = reconvert(convert("09:00") + (n-1) * t);
        } else {
            int tmp = stack[n - 1].pop();
            answer = reconvert(tmp - 1);
        }
        System.out.println(answer);
    }

    static int convert(String time) {
        String[] split = time.split(":");

        int h = Integer.parseInt(split[0]) * 60;
        int m = Integer.parseInt(split[1]);
        return h + m;
    }

    static String reconvert(int time) {
        int hi = time / 60;

        String h = String.valueOf(hi);
        int mi = time - hi * 60;
        String m = String.valueOf(mi);
        if (hi < 10) {
            h = "0" + h;
        }
        if (mi < 10) {
            m = "0" + m;
        }
        return h + ":" + m;
    }
}
