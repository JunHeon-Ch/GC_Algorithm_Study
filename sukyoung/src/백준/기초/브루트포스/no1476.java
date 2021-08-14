package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ESM = br.readLine().split(" ");

        int E = Integer.parseInt(ESM[0]);
        int S = Integer.parseInt(ESM[1]);
        int M = Integer.parseInt(ESM[2]);

        int e = 1;
        int s = 1;
        int m = 1;
        int year = 1;
        while(true){
            if(e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }
            e++;
            s++;
            m++;
            if(e == 16)
                e = 1;
            if(s == 29)
                s = 1;
            if(m == 20)
                m = 1;
            year ++;
        }
    }
}
