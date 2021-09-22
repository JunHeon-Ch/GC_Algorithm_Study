package 다시풀기;

public class 단체사진찍기 {
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        char[] member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[8];
        answer = 0;
        dfs(data, member, "", 0);

        System.out.println(answer);
    }

    static void dfs(String[] data, char[] member, String result, int index) {
        if (index == 8) {
            if (valid(data, result)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < member.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(data, member, result + member[i], index + 1);
            visited[i] = false;
        }
    }

    static boolean valid(String[] data, String result) {
        for (String str : data) {
            char p1 = str.charAt(0);
            char p2 = str.charAt(2);
            char op = str.charAt(3);
            int value = str.charAt(4) - '0';

            int n1 = result.indexOf(p1);
            int n2 = result.indexOf(p2);
            int dif = Math.abs(n1 - n2) - 1;

            if (op == '=') {
                if (dif != value) return false;
            } else if (op == '<') {
                if (dif >= value) return false;
            } else {
                if (dif <= value) return false;
            }
        }
        return true;
    }
}
