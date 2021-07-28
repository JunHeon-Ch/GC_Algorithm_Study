package 브루트포스;

import java.io.*;

public class 차량번판1 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String type = br.readLine();


        go(0, type, new char[type.length()]);

        bw.write(answer + "");
        bw.close();
    }

    static void go(int index, String type, char[] ans) {
        if (type.length() == index) {
            answer++;
            return;
        }
        if (type.charAt(index) == 'd') {
            if (index == 0) {
                for (char i = '0'; i <= '9'; i++) {
                    ans[index] = i;
                    go(index + 1, type, ans);
                }

            } else {
                for (char i = '0'; i <= '9'; i++) {
                    if (ans[index - 1] == i) continue;
                    ans[index] = i;
                    go(index + 1, type, ans);
                }
            }
        } else {
            if (index == 0) {
                for (char i = 'a'; i <= 'z'; i++) {
                    ans[index] = i;
                    go(index + 1, type, ans);
                }

            } else {
                for (char i = 'a'; i <= 'z'; i++) {
                    if (ans[index - 1] == i) continue;
                    ans[index] = i;
                    go(index + 1, type, ans);
                }
            }
        }
    }
}
