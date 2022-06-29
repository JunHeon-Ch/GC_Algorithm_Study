package PS_2021.NHN커머스_공채_2021._1;

import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] logs = new String[n]; // 송수신 기록
        for (int i = 0; i < n; i++) {
            logs[i] = br.readLine();
        }

        List<String> ans = new ArrayList<>();
        String prev = logs[0];
        int cnt = 1;
        for(int i = 1; i < n; i++) {
            if(prev.equals(logs[i])) {
                cnt++;
            } else {
                if(cnt == 1) {
                    ans.add(prev);
                } else {
                    ans.add(prev + " (" + cnt + ")");
                }
                prev = logs[i];
                cnt = 1;
            }
        }
        if(cnt == 1) {
            ans.add(prev);
        } else {
            ans.add(prev + " (" + cnt + ")");
        }

        System.out.println(ans.size());
        for(String res : ans) {
            System.out.println(res);
        }
    }
}
