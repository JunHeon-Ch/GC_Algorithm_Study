package 다시풀기;

import java.util.Arrays;

public class 실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] answer = new int[N];
        node[] fail = new node[N];
        for (int i = 1; i < N + 1; i++) {
            double cnt1 = 0;
            double cnt2 = 0;
            for (int stage : stages) {
                if (i < stage) cnt1++;
                else if (i == stage) cnt2++;
            }
            if (cnt1 + cnt2 == 0) fail[i - 1] = new node(i,0);
            else fail[i - 1] = new node(i,cnt2 / (cnt1 + cnt2));
        }

        Arrays.sort(fail);

        for (int i=0;i<N;i++){
            answer[i]=fail[i].index;
        }

    }

    static class node implements Comparable<node> {
        int index;
        double fail;

        public node(int index, double fail) {
            this.index = index;
            this.fail = fail;
        }

        @Override
        public int compareTo(node o) {

            if (o.fail == this.fail) return this.index - o.index;
            if (o.fail > this.fail) return 1;
            return -1;
        }
    }
}
