package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] student = new boolean[31];

        for(int i=0; i<31; i++)
            student[i] = false;

        for(int i=0; i<28; i++)
            student[Integer.parseInt(br.readLine())] = true;

        for(int i=1; i<31; i++){
            if(!student[i])
                sb.append(i + "\n");
        }
        System.out.print(sb);
    }
}
