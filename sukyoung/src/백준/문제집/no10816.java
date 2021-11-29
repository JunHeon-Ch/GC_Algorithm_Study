package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class no10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> card = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(card.containsKey(num)){
                int cnt = card.get(num) + 1;
                card.put(num, cnt);
            }
            else{
                card.put(num, 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int want = Integer.parseInt(st.nextToken());

            if(!card.containsKey(want))
                sb.append("0 ");
            else{
                int cnt = card.get(want);
                sb.append(cnt + " ");
            }

        }
        System.out.println(sb);
    }
}
