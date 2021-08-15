package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2290 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int height = 2 * s + 3;
        int width = s + 2;
        int howlong = (int) (Math.log10(n) + 1);
        if (n < 10)
            howlong = 1;

        String number = String.valueOf(n);
        char[] num = number.toCharArray();
        char[][] digits = new char[height][howlong * width + howlong - 1];
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits[0].length; j++) {
                digits[i][j] = ' ';
            }
        }
        int blank = -1;
        for(int i=0; i<howlong; i++) {
            //우상 세로선
            if(num[i] != '5' && num[i] != '6') {
                for(int j=1; j<height/2; j++)
                    digits[j][width * (i+1) + blank] = '|';
            }
            //우하 세로선
            if(num[i] != '2') {
                for(int j=height/2+1; j<height-1; j++)
                    digits[j][width * (i+1) + blank] = '|';
            }
            //좌상 세로선
            if(num[i] == '4' || num[i] == '5' || num[i] == '6' || num[i] == '8' || num[i] == '9' || num[i] == '0') {
                for(int j=1; j<height/2; j++)
                    digits[j][width * (i+1) + blank - (width-1)] = '|';
            }
            //좌하 세로선
            if(num[i] == '2' || num[i] == '6' || num[i] == '8' || num[i] == '0') {
                for(int j=height/2+1; j<height-1; j++)
                    digits[j][width * (i+1) + blank - (width-1)] = '|';
            }
            //가로선
            if(num[i] != '1') {
                for(int j=0; j<height; j++) {
                    if(j == 0 && num[i] != '4') {
                        for(int k=1; k<=s; k++)
                            digits[j][width * (i+1) + blank - k] = '-';
                    }
                    if(j == height/2 &&num[i] != '7' && num[i] != '0')
                        for(int k=1; k<=s; k++)
                            digits[j][width * (i+1) + blank - k] = '-';
                    if(j == height-1 && num[i] != '4' && num[i] != '7')
                        for(int k=1; k<=s; k++)
                            digits[j][width * (i+1) + blank - k] = '-';
                }
            }
            blank++;
        }

        for(int i=0; i<digits.length; i++) {
            for(int j=0; j<digits[0].length; j++) {
                System.out.print(digits[i][j]);
            }
            System.out.println();
        }

    }
}
