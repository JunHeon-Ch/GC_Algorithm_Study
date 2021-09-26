package 다시풀기;

import java.util.ArrayList;

public class 추석트래픽 {
    public static void main(String[] args) {
        String[] lines = {"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"};

        ArrayList<Pair> times = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(" ");
            int[] tmp = convert(split[1], (int) (Double.parseDouble(split[2].replace("s", "")) * 1000));
            times.add(new Pair(tmp[0], tmp[1]));
        }


        int answer = 0;
        for (int i = 0; i < times.size(); i++) {

            int start = times.get(i).start;
            int end = start + 1000;
            int cnt = 0;
            for (int j = 0; j < times.size(); j++) {
                if (start <= times.get(j).end && times.get(j).end < end) {
                    cnt++;
                } else if (start <= times.get(j).start && times.get(j).start < end) {
                    cnt++;
                } else if (times.get(j).start <= start && end <= times.get(j).end) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);

            start = times.get(i).end;
            end = start + 1000;
            cnt = 0;
            for (int j = 0; j < times.size(); j++) {
                if (start <= times.get(j).end && times.get(j).end < end) {
                    cnt++;
                } else if (start <= times.get(j).start && times.get(j).start < end) {
                    cnt++;
                } else if (times.get(j).start <= start && end <= times.get(j).end) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);

        }

        System.out.println(answer);
    }

    static class Pair {
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int[] convert(String str, int time) {
        int[] ans = new int[2];
        String[] t = str.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]) + h * 60;
        double k = Double.parseDouble(t[2]) * 1000;
        int s = (int) k + m * 1000 * 60;

        ans[1] = s;
        ans[0] = s - time + 1;
        return ans;
    }
}
