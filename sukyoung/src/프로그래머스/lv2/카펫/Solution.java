package 프로그래머스.lv2.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i=1; i<total; i++){
            if(total % i == 0){
                int y = i;
                int x = total / i;

                if((x*2) + (y - 2)*2 == brown){
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }
        return answer;
    }
}
