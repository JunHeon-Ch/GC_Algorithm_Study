package PS_2021.카카오브레인_패스파인더_2021.Problem1;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result {

    public static int countSubstrings(String str) {
        List<Integer> digit = new ArrayList<>();
        for(char c : str.toCharArray()) {
            if(c <= 'b') digit.add(1);
            else if(c > 'b' && c <= 'e') digit.add(2);
            else if(c > 'e' && c <= 'h') digit.add(3);
            else if(c > 'h' && c <= 'k') digit.add(4);
            else if(c > 'k' && c <= 'n') digit.add(5);
            else if(c > 'n' && c <= 'q') digit.add(6);
            else if(c > 'q' && c <= 't') digit.add(7);
            else if(c > 't' && c <= 'w') digit.add(8);
            else if(c > 'w' && c <= 'z') digit.add(9);
        }
        int ans = 0;
        for(int k = 1; k <= str.length(); k++) {
            for(int i = 0; i + k <= str.length(); i++) {
                int sum = 0;
                for(int j = i; j < i + k; j++) {
                    sum += digit.get(j);
                }
                if(sum % k == 0) ans++;
            }
        }
        return ans;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String input_str = bufferedReader.readLine();

        int result = Result.countSubstrings(input_str);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
