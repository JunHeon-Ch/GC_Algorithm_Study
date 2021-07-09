package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no11723 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int bitset = 0;

        while(M-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            if(operation.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                bitset |= (1 << (num - 1));
            }
            else if(operation.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                bitset = bitset & ~(1 << (num - 1));
            }
            else if(operation.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                sb.append((bitset & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
            }
            else if(operation.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                bitset ^= (1 << (num - 1));
            }
            else if(operation.equals("all")){
                bitset |= (~0);
            }
            else if(operation.equals("empty")){
                bitset &= 0;
            }
        }
        System.out.println(sb);
    }
}
