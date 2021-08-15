import java.util.*;

class Solution {
    public String getRank(double score){
        if(score >= 90.0) return "A";
        else if(score >= 80.0) return "B";
        else if(score >= 70.0) return "C";
        else if(score >= 50.0) return "D";
        else return "F";
    }

    public String solution(int[][] scores) {
        String answer = "";

        int length = scores.length;
        for(int j=0; j<scores.length; j++){

            int selfScore = scores[j][j];

            int cnt = scores.length;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            int sum = 0;
            boolean only = true;

            for(int i=0; i<scores.length; i++){

                int score = scores[i][j];

                if(i != j && selfScore == score){
                    only = false;
                }

                max = Math.max(max, score);
                min = Math.min(min, score);

                sum += score;

            }

            if((selfScore == max || selfScore == min) && only){

                cnt--;
                sum -= selfScore;

            }

            answer += this.getRank((double) sum / (double) cnt);

        }

        return answer;
    }
}