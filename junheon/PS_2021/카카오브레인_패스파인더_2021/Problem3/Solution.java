package PS_2021.카카오브레인_패스파인더_2021.Problem3;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    public static int segment(int x, List<Integer> space) {
        System.out.println("size: " + space.size());
        System.out.println("x: " + x);
        int ans = 0;
        for(int i = 0; i + x <= space.size(); i++) {
            int max = Integer.MAX_VALUE;
            for(int j = i; j < i + x; j++) {
                max = Math.min(max, space.get(j));
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int spaceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> space = IntStream.range(0, spaceCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.segment(x, space);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
