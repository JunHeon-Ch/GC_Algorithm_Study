package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class no1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> tempA = new HashSet<>();
        Set<Integer> tempB = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++){
            int temp = Integer.parseInt(st.nextToken());
            setA.add(temp);
            tempA.add(temp);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++){
            int temp = Integer.parseInt(st.nextToken());
            setB.add(temp);
            tempB.add(temp);
        }
        tempA.removeAll(setB);
        tempB.removeAll(setA);
        System.out.println(tempA.size() + tempB.size());
    }
}
