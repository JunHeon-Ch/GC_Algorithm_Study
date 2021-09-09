import java.util.*;

public class 여행경로 {
    static ArrayList<String> answers;
    static boolean[] visited;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        visited = new boolean[tickets.length];
        answers = new ArrayList<>();
        int count = 0;
        dfs(count, "ICN", "ICN", tickets);
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
//        return answer;
        System.out.println(answers);
        System.out.println(Arrays.toString(answer));
    }

    static void dfs(int count, String present, String answer, String[][] ticktes) {
        if (count == ticktes.length) {
            answers.add(answer);
            return;
        }
        for (int i = 0; i < ticktes.length; i++) {
            if (!visited[i] && ticktes[i][0].equals(present)) {
                visited[i] = true;
                dfs(count + 1, ticktes[i][1], answer + " " + ticktes[i][1], ticktes);
                visited[i] = false;
            }
        }
        return;
    }


}
