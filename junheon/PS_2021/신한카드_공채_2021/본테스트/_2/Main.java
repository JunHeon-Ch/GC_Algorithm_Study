package PS_2021.신한카드_공채_2021.본테스트._2;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < line.length; i++) {
            set.add(line[i]);
        }

        int[] count = new int[2];
        for (char c : set) {
            count[(c - 'a') % 2]++;
        }

        char prev = line[0];
        set = new HashSet<>();
        set.add(line[0]);
        for (int i = 0; i < line.length; i++) {
            if (prev != line[i]) {
                if(set.contains(line[i])) {
                    count[(line[i] - 'a') % 2]--;
                } else {
                    set.add(line[i]);
                }
                prev = line[i];
            }
        }
        if(count[0] != count[1]) {
            System.out.println(count[0] > count[1] ? "W" : "B");
        }
        br.close();
    }
}