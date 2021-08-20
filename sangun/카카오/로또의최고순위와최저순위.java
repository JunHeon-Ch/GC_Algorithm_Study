import java.util.Arrays;
import java.util.HashSet;

public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {


        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};


        int[] answer = new int[2];


        int cnt = 0;
        int cnt0 = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) cnt0++;
            for (int j = 0; j < win_nums.length; j++) {
                if (win_nums[j] == lottos[i]) {
                    cnt++;

                }
            }
        }
        answer[1] = 6 - cnt + 1;
        if (answer[1] == 7) answer[1] = 6;
        answer[0] = 6 - (cnt + cnt0) + 1;


        System.out.println(Arrays.toString(answer));


    }


}
