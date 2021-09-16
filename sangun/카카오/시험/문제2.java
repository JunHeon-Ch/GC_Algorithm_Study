package 시험;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class 문제2 {
    public static void main(String[] args) {

        int n = 437674;
        int k = 3;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }


        String value = sb.reverse().toString();
        System.out.println(value);
        String[] split = value.replace("0", " ").replace("  ", " ").split(" ");
        ArrayList<Integer> sp = new ArrayList<>();
        for (String spli : split) {
            sp.add(Integer.valueOf(spli));
        }

        int range = 120000000;
        boolean[] prime = new boolean[range + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= range; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= range; j += i) prime[j] = true;
            }
        }


        int answer = 0;
        for (int i = 0; i < sp.size(); i++) {
            split[i] = split[i].replace("0", "");
            if (!prime[sp.get(i)]) answer++;
        }

        System.out.println(answer);


    }

    static boolean valid(Double num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
