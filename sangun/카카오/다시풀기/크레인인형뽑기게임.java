package 다시풀기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};


        Queue<Integer>[] boards = new Queue[board.length];

        for (int i = 0; i < board.length; i++) {
            boards[i] = new LinkedList<>();
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==0)continue;
                boards[j].add(board[i][j]);
            }
        }


        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int num : moves) {
            if (boards[num - 1].isEmpty()) continue;

            int n = boards[num - 1].remove();

            if (stack.isEmpty() || stack.peek() != n) {
                stack.add(n);
            } else {
                answer+=2;
                stack.pop();
            }
        }
        System.out.println(answer);
    }
}
