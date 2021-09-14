package 푼문제;

import java.util.ArrayList;
import java.util.HashMap;

public class _방금그곡 {

    public static void main(String[] args) {
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        String answer = "";

        String[] sharp = {"C#", "D#", "E#", "F#", "G#", "A#"};
        String[] lowercase = {"c", "d", "e", "f", "g", "a"};
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> seq = new ArrayList<>();

        for (int j = 0; j < 6; j++) {
            m = m.replace(sharp[j], lowercase[j]);
        }
        for (int i = 0; i < musicinfos.length; i++) {
            musicinfos[i] = musicinfos[i].replace("C#", "c");
            for (int j = 0; j < 6; j++) {
                musicinfos[i] = musicinfos[i].replace(sharp[j], lowercase[j]);
            }

            String[] split = musicinfos[i].split(",");
            seq.add(split[2]);
            int len = dif(split[0], split[1]);
            String value = make_len(split[3], len);
            hashMap.put(split[2], value);

        }

        System.out.println(hashMap);
        for (String k : hashMap.keySet()) {
            if (hashMap.get(k).contains(m)) {
                if (answer.equals("")){
                    answer=k;
                }
                else if (hashMap.get(answer).length() < hashMap.get(k).length()) {
                    answer = k;
                }
                else if (hashMap.get(answer).length() == hashMap.get(k).length()) {
                    int a = seq.indexOf(answer);
                    int b = seq.indexOf(k);
                    if (a > b) answer = k;
                }
            }
        }

        if (answer.equals("")) {
            System.out.println(answer);
        }
        System.out.println(answer);
    }

    static String make_len(String k, int n) {
        if (k.length() < n) {
            while (true) {
                k = k.concat(k);
                if (k.length() == n) {
                    return k;
                } else if (k.length() > n) {
                    return k.substring(0, n);
                }
            }

        } else if (k.length() == n) {
            return k;
        } else {
            return k.substring(0, n);
        }
    }

    static int dif(String a, String b) {
        int runningTime = 0;

        String[] front = a.split(":");
        String[] behind = b.split(":");


        int front_h = Integer.parseInt(front[0]);
        int front_m = Integer.parseInt(front[1]);
        int behind_h = Integer.parseInt(behind[0]);
        int behind_m = Integer.parseInt(behind[1]);

        runningTime = (behind_h - front_h) * 60 + (behind_m - front_m);

        return runningTime;

    }
}
