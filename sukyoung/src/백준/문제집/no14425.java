package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class no14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> list = new HashSet<>();
        for(int i=0; i<n; i++)
            list.add(br.readLine());

        int cnt = 0;
        for(int i=0; i<m; i++){
            String str = br.readLine();
            if(list.contains(str))
                cnt++;
        }
        System.out.println(cnt);
    }
}
