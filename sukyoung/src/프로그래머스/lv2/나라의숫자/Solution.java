package 프로그래머스.lv2.나라의숫자;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        int num = n;
        while (num > 0){
            int mod = num % 3;
            num = num / 3;

            if(mod == 0) num--;

            answer = numbers[mod] + answer;
        }
        return answer;
    }

}
