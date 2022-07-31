package PS_2022.BOJ.Queue.이중_우선순위_큐_7662;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/7662
 * 알고리즘: 우선순위큐
 * 시간복잡도: O(nlogn), n=1,000,000(연산의 개수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (n > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (op.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (op.equals("D") && !map.isEmpty()) {
                    if(num == 1) {
                        int key = map.lastKey();
                        if(map.get(key) == 1) map.remove(key);
                        else map.put(key, map.get(key) - 1);
                    } else if(num == -1) {
                        int key = map.firstKey();
                        if(map.get(key) == 1) map.remove(key);
                        else map.put(key, map.get(key) - 1);
                    }
                }
                n--;
            }
            if (map.isEmpty()) bw.write("EMPTY\n");
            else bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            t--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
