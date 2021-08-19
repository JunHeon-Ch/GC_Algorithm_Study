import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class 보석쇼핑 {
    public static void main(String[] args) {
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        LinkedList<String> q = new LinkedList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < gems.length; i++) {
            if (!q.isEmpty() && q.peek().equals(gems[i])) {
                q.remove(0);
                start++;
            }
            q.add(gems[i]);
            end++;
            while (q.size() > 1 && q.peek().equals(q.get(1))) {
                q.remove(0);
                start++;
            }
            boolean valid = false;
            for (String k : set) {
                if (!q.contains(k)) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                System.out.println(start+1 + " " + end);
                System.out.println(q);
                return;
            }

        }
    }
}
