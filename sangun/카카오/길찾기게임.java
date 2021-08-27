import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 길찾기게임 {
    static int index = 0;

    public static void main(String[] args) {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};

        int[][] answer = new int[2][nodeinfo.length];

        ArrayList<Pair> node = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            node.add(new Pair(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        node.sort(comparator);

        // 루트 노드
        Pair root = node.get(0);

        // 노드 연결
        for (int i = 1; i < node.size(); i++) {
            Pair child = node.get(i);
            connectNode(root, child);
        }

        // 전위 순회
        preorder(root, answer);
        index = 0;
        // 후위 순회
        postorder(root, answer);
        System.out.println(Arrays.deepToString(answer));


    }

    // 전위
    static void preorder(Pair node, int[][] answer) {
        if (node != null) {
            answer[0][index++] = node.num;
            if (node.left != null) preorder(node.left, answer);
            if (node.right != null) preorder(node.right, answer);

        }
    }

    // 전위
    static void postorder(Pair node, int[][] answer) {
        if (node != null) {
            if (node.left != null) postorder(node.left, answer);
            if (node.right != null) postorder(node.right, answer);
            answer[1][index++] = node.num;
        }
    }


    // 노드 연결
    static void connectNode(Pair parent, Pair child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                connectNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                connectNode(parent.right, child);
            }
        }
    }

    static class Pair {
        int x, y, num;
        Pair left, right;

        public Pair(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static Comparator<Pair> comparator = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o2.y - o1.y;
        }
    };
}
