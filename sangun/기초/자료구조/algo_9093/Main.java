package algo_9093;

import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String sentence = sc.nextLine();

        for (int i = 0; i < n; i++) {
            sentence = sc.nextLine();
            System.out.println(flip(sentence));

        }
    }

    public static String flip(String s) {
        String[] split = s.split(" ");
        char[] temp;
        String result="";
        char tempChar;

        for (int i = 0; i < split.length; i++) {
            temp = split[i].toCharArray();
            for (int j = 0; j < temp.length / 2; j++) {
                tempChar=temp[j];
                temp[j]=temp[temp.length-j-1];
                temp[temp.length-j-1]=tempChar;
            }

            result+=String.valueOf(temp)+" ";

        }


        return result;
    }
}
