package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        int diff = b.length() - a.length();

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=diff; i++){

            int cnt = 0;
            for(int j=0; j<a.length(); j++){
                if(a.charAt(j) != b.charAt(j+i))
                    cnt++;
            }
            min = Math.min(cnt, min);
        }
        System.out.println(min);
    }
}
