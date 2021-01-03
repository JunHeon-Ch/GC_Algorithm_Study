package algo_17413;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        char[] arr = s.toCharArray();
        int start = 0;
        boolean tag = false;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '<') {
                tag = true;
                arr = flip(arr, start, i - 1);
                continue;
            }
            if (tag) {
                if (arr[i] == '>') {
                    tag = false;
                    start = i + 1;
                    continue;
                }
            }
            if (!tag&&arr[i] == ' ') {
                arr=flip(arr, start, i - 1);
                start = i + 1;
            }else if(!tag&& i==arr.length-1){
                arr=flip(arr, start, i);
                break;
            }


        }
        bw.write(String.valueOf(arr));
        bw.flush();
        bw.close();

    }

    public static char[] flip(char[] s, int start, int last) {
        char temp;
        for (int i = 0; i < (last - start + 1) / 2; i++) {
            temp = s[start + i];
            s[start + i] = s[last - i];
            s[last - i] = temp;
        }
        return s;
    }

}
