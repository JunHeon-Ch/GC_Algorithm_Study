package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class no1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Set<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++)
            aSet.add(Integer.parseInt(st.nextToken()));

        Set<Integer> bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++)
            bSet.add(Integer.parseInt(st.nextToken()));

        aSet.removeAll(bSet);
        if(aSet.size() == 0)
            System.out.println("0");
        else{
            System.out.println(aSet.size());
            for(int i: aSet)
                System.out.print(i + " ");
        }
    }
}
