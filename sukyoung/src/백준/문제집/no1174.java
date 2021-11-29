package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class no1174 {
    public static ArrayList<Long> list = new ArrayList<>();
    public static int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        descNum(0, 0);

        Collections.sort(list);
        if(n > 1023)
            System.out.print(-1);
        else
            System.out.print(list.get(n-1));
    }
    public static void descNum(long sum, int idx){
        if(!list.contains(sum))
            list.add(sum);

        if(idx >= 10)
            return;

        descNum((sum*10) + num[idx], idx+1);
        descNum(sum, idx+1);
    }
}
