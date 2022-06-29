package PS_2021.프로그래머스.level3.표_편집;

import java.util.Stack;

class Best_Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> removeInfo = new Stack<>();
        int len = n;
        int cursor = k;
        for (int i = 0; i < cmd.length; i++) {
            char operation = cmd[i].charAt(0);
            if (operation == 'D') {
                cursor += Integer.parseInt(cmd[i].substring(2));
            } else if (operation == 'U') {
                cursor -= Integer.parseInt(cmd[i].substring(2));
            } else if (operation == 'C') {
                removeInfo.add(cursor);
                len--;
                if (cursor == len) cursor--;
            } else if (operation == 'Z') {
                if (removeInfo.pop() <= cursor) cursor++;
                len++;
            }
        }

        StringBuilder strBuild = new StringBuilder();
        for (int j = 0; j < len; j++) {
            strBuild.append("O");
        }

        while (!removeInfo.isEmpty()) {
            strBuild.insert(removeInfo.pop().intValue(), "X");
        }

        String answer = strBuild.toString();

//        System.out.println(answer);
        return answer;
    }
}