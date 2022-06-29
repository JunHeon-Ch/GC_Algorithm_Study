package PS_2021.신한카드_공채_2021.모의테스트.문제_선정하기;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        while(st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        if(set.size() >= 3) System.out.println("YES");
        else System.out.println("NO");
    }
}