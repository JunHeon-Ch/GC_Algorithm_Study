package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());

        long sum = 0;
        long result = 1;
        while(true){
            sum += result;
            if(sum > s)
                break;
            result++;
        }
        System.out.print(--result);

    }
}
