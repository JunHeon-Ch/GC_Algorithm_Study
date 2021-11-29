package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class no1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> pocketmon = new HashMap<>();
        for(int i=0; i<n; i++){
            String name = br.readLine();
            pocketmon.put(String.valueOf(i+1), name);
            pocketmon.put(name, String.valueOf(i+1));
        }

        for(int i=0; i<m; i++){
            String quest = br.readLine();
            sb.append(pocketmon.get(quest));
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
