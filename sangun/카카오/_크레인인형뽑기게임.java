import java.util.Stack;

public class _크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] board = {{3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        Stack<Integer> bucket = new Stack<>();
        Stack<Integer>[] b = new Stack[board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            b[i] = new Stack<>();
        }

        for (int i = 0; i < board[0].length; i++) {
            int j = board.length - 1;
            while (board[j][i] != 0) {
                b[i].add(board[j][i]);
                j--;
                if (j < 0) break;
            }
        }

        int answer = 0;
        for (int i = 0; i < moves.length; i++) {
            if (b[moves[i] - 1].isEmpty()) continue;
            int k = b[moves[i] - 1].pop();
            if (bucket.isEmpty()) {
                bucket.add(k);
            } else {
                if (bucket.peek() == k) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.add(k);
                }
            }
        }
        System.out.println(answer);
    }
}
