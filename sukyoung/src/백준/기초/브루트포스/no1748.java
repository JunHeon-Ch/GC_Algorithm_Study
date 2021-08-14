package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int origin_length = (int) (Math.log10(n)+1);

        int cnt = 0;
        int temp_length = origin_length;
        while(temp_length > 0){
            if(temp_length == origin_length){
                cnt += (n - Math.pow(10, temp_length-1) + 1) * temp_length;
                temp_length --;
            }
            else{
                int max = (int) (Math.pow(10,temp_length) -1);
                int min = (int) (Math.pow(10,temp_length-1));
                cnt += (max - min + 1) * temp_length;
                temp_length --;
            }
        }
        System.out.println(cnt);
    }
}
