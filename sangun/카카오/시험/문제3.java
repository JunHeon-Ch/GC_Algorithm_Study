package 시험;

import java.util.*;

public class 문제3 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        Arrays.sort(records);
        System.out.println(Arrays.toString(records));
        Map<String, Integer> use_time = new HashMap<>();
        Map<String, String> in_time = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            if (split[2].equals("IN")) {
                in_time.put(split[1], split[0]);
            } else {
                String time = in_time.remove(split[1]);
                int value = cal(time, split[0]);
                if (use_time.containsKey(split[1])) {
                    use_time.put(split[1], value + use_time.get(split[1]));
                } else {
                    use_time.put(split[1], value);
                }
            }
        }

        ArrayList<String> tmp = new ArrayList<>();
            for (String num : in_time.keySet()) {
                String time = in_time.get(num);
                int value = cal(time, "23:59");
                if (use_time.containsKey(num)) {
                    use_time.put(num, value + use_time.get(num));
                } else {
                    use_time.put(num, value);
                }
                tmp.add(num);
            }

        int[] answer = new int[use_time.size()];
        int idx = 0;
        ArrayList<String> str = new ArrayList<>(use_time.keySet());
        str.sort(Comparator.naturalOrder());

        for (String num : use_time.keySet()) {
            answer[idx++] = cal2(use_time.get(num), fees);
        }
        System.out.println(Arrays.toString(answer));


        System.out.println(use_time);
    }

    static int cal(String in, String out) {
        String[] in_str = in.split(":");
        String[] out_str = out.split(":");

        int in_time = Integer.parseInt(in_str[0]) * 60 + Integer.parseInt(in_str[1]);
        int out_time = Integer.parseInt(out_str[0]) * 60 + Integer.parseInt(out_str[1]);

        return out_time - in_time;
    }

    static int cal2(int time, int[] fee) {

        int basic_time = fee[0];
        int basic_fee = fee[1];
        int per_time = fee[2];
        int per_fee = fee[3];
        if (basic_time - time >= 0) return basic_fee;
        int dif = time - basic_time;
        int v = 0;
        if (dif % per_time != 0) {
            v = dif / per_time + 1;
        } else {
            v = dif / per_time;
        }
        System.out.println(v);
        return basic_fee + v * per_fee;

    }
}
