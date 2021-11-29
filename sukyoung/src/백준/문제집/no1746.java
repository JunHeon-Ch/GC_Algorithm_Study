package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class no1746 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> listen = new HashSet<>();
        Set<String> see = new HashSet<>();
        for(int i=0; i<n; i++)
            listen.add(br.readLine());
        for(int i=0; i<m; i++)
            see.add(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        for(String s: listen){
            if(see.contains(s)){
                list.add(s);
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for(String s: list){
            System.out.println(s);
        }
    }
}
