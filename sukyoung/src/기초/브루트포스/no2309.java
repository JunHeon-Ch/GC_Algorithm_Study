package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarfs = new int[9];
        int height = 0;
        for(int i=0; i<9; i++){
            dwarfs[i] = Integer.parseInt(br.readLine());
            height += dwarfs[i];
        }
        Arrays.sort(dwarfs);

        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                if(height - dwarfs[i] - dwarfs[j] == 100){
                    num1 = i;
                    num2 = j;

                    break;
                }
            }
        }
        for(int i=0; i<9; i++) {
            if (i == num1 | i == num2)
                continue;
            System.out.println(dwarfs[i]);
        }
    }
}
