package algo_10845;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int back = 0;
        String cmd;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            if (cmd.equals("push")) {
                int data = Integer.parseInt(st.nextToken());
                queue.add(data);
                back = data;
            } else if (cmd.equals("pop")) {
                if (queue.isEmpty()){
                    bw.write(-1+"\n");
                }
                else
                    bw.write(queue.poll()+"\n");
            } else if (cmd.equals("size")) {
                bw.write(queue.size()+"\n");
            } else if (cmd.equals("empty") ) {
                if (queue.isEmpty()){
                    bw.write(1+"\n");
                }else
                    bw.write(0+"\n");
            } else if (cmd.equals("front")) {
                if (queue.isEmpty()) {
                    bw.write(-1+"\n");
                } else {
                    bw.write(queue.peek()+"\n");
                }
            } else if (cmd.equals("back")) {
                if (queue.isEmpty()) {
                    bw.write(-1+"\n");
                } else {
                    bw.write(back+"\n");
                }

            }

        }

        bw.flush();
        bw.close();
    }
}
