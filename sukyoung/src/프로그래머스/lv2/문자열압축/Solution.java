package 프로그래머스.lv2.문자열압축;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i=1; i<=s.length()/2; i++){
            int length = compression(s,i).length();
            answer = Math.min(length, answer);
        }
        return answer;
    }

    public String compression(String str, int idx){
        int count = 1;
        String compression = "";
        String pattern = "";

        for(int j=0; j<=str.length()+idx; j+=idx){
            String temp;
            if(j >= str.length()){
                temp = "";
            } else if(str.length() < j+idx){
                temp = str.substring(j);
            } else {
                temp = str.substring(j, j+idx);
            }

            if(j != 0){
                if (temp.equals(pattern)) {
                    count++;
                } else if (count >= 2) {
                    compression += count + pattern;
                    count = 1;
                } else {
                    compression += pattern;
                }
            }
            pattern = temp;
        }
        return compression;
    }
}
