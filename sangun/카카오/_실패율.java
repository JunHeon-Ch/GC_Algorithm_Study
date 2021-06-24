import java.util.Arrays;
import java.util.Comparator;

public class _실패율 {
    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int arr[] = new int[n + 2];
        node[] failRate = new node[n + 1];
        Arrays.fill(arr, 0);
        for (int i = 0; i < stages.length; i++) {
            arr[stages[i]]++;
        }
        int total = stages.length;
        failRate[0] = new node(0, -1.0);
        for (int i = 1; i < n + 1; i++) {
            if (total != 0) {
                failRate[i] = new node(i, (double) arr[i] / total);
                total -= arr[i];
            } else {
                failRate[i] = new node(i, 0);
            }
        }
        Comparator<node> f = new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                if (o1.failRate == o2.failRate) {
                    return Integer.compare(o1.idx, o2.idx);
                }
                return -Double.compare(o1.failRate, o2.failRate);
            }
        };
        Arrays.sort(failRate, f);
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = failRate[i].idx;
        }

//        return answer;
    }
}

class node {
    int idx;
    double failRate;

    public node(int cnt, double failRate) {
        this.idx = cnt;
        this.failRate = failRate;
    }
}