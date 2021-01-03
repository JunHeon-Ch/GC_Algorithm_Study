package algo_10824;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder[] value = new StringBuilder[2];
        value[0]=new StringBuilder();
        value[1]=new StringBuilder();

        String[] s = br.readLine().split(" ");

        value[0].append(s[0]);
        value[0].append(s[1]);
        Double a = Double.parseDouble(String.valueOf(value[0]));

        value[1].append(s[2]);
        value[1].append(s[3]);
        Double b = Double.parseDouble(String.valueOf(value[1]));

        bw.write((String.format("%.0f", a+b)+""));
        bw.flush();
        bw.close();



    }
}
