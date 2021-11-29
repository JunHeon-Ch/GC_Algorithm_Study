package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class no11478 {
    private static boolean[] visit;
    public static Set<String> ans = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        visit = new boolean[str.length()];
        for(int i=1; i<=str.length(); i++){
            for(int j=0; j<i; j++){
                String temp = str.substring(j, i);
                if(ans.contains(temp))
                    continue;
                else
                    ans.add(temp);
            }
        }
        System.out.println(ans.size());
    }
}
