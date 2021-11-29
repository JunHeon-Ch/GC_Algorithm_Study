package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class no10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> card = new HashSet<>();
        for(int i=0; i<n; i++)
            card.add(Integer.parseInt(st.nextToken()));

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(card.contains(temp))
                sb.append(1+" ");
            else
                sb.append(0+" ");
        }
        System.out.print(sb);
    }
}
