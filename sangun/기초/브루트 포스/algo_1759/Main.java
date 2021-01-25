package algo_1759;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[] arr = new char[c];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            arr[i] = str[i].charAt(0);
        }
        Arrays.sort(arr);
        String pwd = "";
        go(0, pwd, l, arr);
        bw.close();

    }

    static void go(int index, String pwd, int n, char[] alpha) throws IOException {
        if (pwd.length() == n) {
            if (check(pwd)) {
                bw.write(pwd + "\n");
            }
            return;
        }
        if (index >= alpha.length) return;
        go(index + 1, pwd + alpha[index], n, alpha);
        go(index + 1, pwd, n, alpha);
    }

    static boolean check(String str) {
        ArrayList<Character> coll = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (coll.contains(str.charAt(i))) cnt1++;
            else cnt2++;
        }
        if (cnt1 < 1 || cnt2 < 2) {
            return false;
        } else
            return true;
    }
}