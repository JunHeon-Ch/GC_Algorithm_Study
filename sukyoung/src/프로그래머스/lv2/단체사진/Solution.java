package 프로그래머스.lv2.단체사진;

class Solution {
    public int answer = 0;
    public String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public int solution(int n, String[] data) {
        boolean[] visit = new boolean[8];
        dfs("", visit, data);

        return answer;
    }
    public void dfs(String names, boolean[] visit, String[] datas){
        if(names.length() == 7){
            if(avaliability(names, datas)){
                answer++;
            }
            return;
        }

        for(int i=0; i<8; i++){
            if(!visit[i]){
                visit[i] = true;
                String name = names + friends[i];
                dfs(name, visit, datas);
                visit[i] = false;
            }
        }
    }
    public boolean avaliability(String names, String[] datas){
        for (String data : datas) {
            int position1 = names.indexOf(data.charAt(0)); // 프렌즈 포지션1
            int position2 = names.indexOf(data.charAt(2)); // 프렌즈 포지션2
            char op = data.charAt(3); // 수식
            int index = data.charAt(4) -'0'; // 간격
            if (op == '=') {
                if (!(Math.abs(position1 - position2) == index+1)) return false;
            } else if (op == '>') {
                if (!(Math.abs(position1 - position2) > index+1)) return false;
            } else if (op == '<') {
                if (!(Math.abs(position1 - position2) < index+1)) return false;
            }
        }
        return true;
    }
}