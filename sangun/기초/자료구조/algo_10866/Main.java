package algo_10866;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> arr = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int value;
        String cmd;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            if (cmd.equals("push_front")){
                value = Integer.parseInt(st.nextToken());
                arr.addFirst(value);
            }else if (cmd.equals("push_back")){
                value = Integer.parseInt(st.nextToken());
                arr.addLast(value);
            }else if (cmd.equals("pop_front")){
                if (arr.isEmpty()){
                    bw.write(-1+"\n");
                }else{
                    bw.write(arr.removeFirst()+"\n");
                }
            }else if (cmd.equals("pop_back")){
                if (arr.isEmpty()){
                    bw.write(-1+"\n");
                }else{
                    bw.write(arr.removeLast()+"\n");
                }
            }else if (cmd.equals("size")){
                bw.write(arr.size()+"\n");
            }else if (cmd.equals("empty")){
                if (arr.isEmpty()){
                    bw.write(1+"\n");
                }else{
                    bw.write(0+"\n");
                }
            }else if (cmd.equals("front")){
                if (arr.isEmpty()){
                    bw.write(-1+"\n");
                }else{
                    bw.write(arr.getFirst()+"\n");
                }
            }else if (cmd.equals("back")){
                if (arr.isEmpty()){
                    bw.write(-1+"\n");
                }else{
                    bw.write(arr.getLast()+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
