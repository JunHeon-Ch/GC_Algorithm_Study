package algo_2290;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        char[] n = str.toCharArray();

        for (int i = 0; i < 2 * s + 3; i++) {
            for (int j = 0; j < n.length; j++) {
                if (i == 0) {
                    if (n[j] == '1' || n[j] == '4') {
                        for (int k = 0; k < s + 2; k++) bw.write(" ");
                    } else {
                        bw.write(" ");
                        for (int k = 0; k < s; k++) bw.write("-");
                        bw.write(" ");
                    }
                } else if (i < s + 1) {
                    if (n[j] == '4' || n[j] == '8' || n[j] == '9' || n[j] == '0') {
                        bw.write("|");
                        for (int k = 0; k < s; k++) bw.write(" ");
                        bw.write("|");
                    } else if (n[j] == '1' || n[j] == '2' || n[j] == '3' || n[j] == '7') {
                        for (int k = 0; k < s + 1; k++) bw.write(" ");
                        bw.write("|");
                    } else if (n[j] == '5' || n[j] == '6') {
                        bw.write("|");
                        for (int k = 0; k < s + 1; k++) bw.write(" ");
                    }
                } else if (i == s + 1) {
                    if (n[j] == '1' || n[j] == '7' || n[j] == '0') {
                        for (int k = 0; k < s + 2; k++) bw.write(" ");
                    } else {
                        bw.write(" ");
                        for (int k = 0; k < s; k++) bw.write("-");
                        bw.write(" ");
                    }
                } else if (i == 2 * s + 2) {
                    if (n[j] == '1' || n[j] == '4' || n[j] == '7') {
                        for (int k = 0; k < s + 2; k++) bw.write(" ");
                    } else {
                        bw.write(" ");
                        for (int k = 0; k < s; k++) bw.write("-");
                        bw.write(" ");
                    }
                } else if (i > s + 1) {
                    if (n[j] == '6' || n[j] == '8' || n[j] == '0') {
                        bw.write("|");
                        for (int k = 0; k < s; k++) bw.write(" ");
                        bw.write("|");
                    } else if (n[j] == '1' || n[j] == '4' || n[j] == '3' || n[j] == '7' || n[j] == '5' || n[j] == '9') {
                        for (int k = 0; k < s + 1; k++) bw.write(" ");
                        bw.write("|");
                    } else if (n[j] == '2') {
                        bw.write("|");
                        for (int k = 0; k < s + 1; k++) bw.write(" ");
                    }
                }
                bw.write(" ");

            }
            bw.write("\n");
        }
        bw.close();

    }

}
