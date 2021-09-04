package 프로그래머스.lv2.거리두기확인하기;

class Solution {
    public String[][] seats = new String[5][5];
    public int[] dx = {1, 1, -1, -1, 2, -2, 0, 0};
    public int[] dy = {1, -1, 1, -1, 0, 0, 2, -2};

    public int[] obstacle_x = {1, -1, 0, 0};
    public int[] obstacle_y = {0, 0, 1, -1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i=0; i<5; i++){
            //요만큼이 한 대기실
            for(int j=0; j<5; j++){
                String[] temp = places[i][j].split("");
                for(int k=0; k<5; k++){
                    seats[j][k] = temp[k];
                }

            }
            if(check())
                answer[i] = 1;
            else
                answer[i] = 0;
        }

        return answer;
    }

    public boolean check(){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(seats[i][j].equals("P")){
                    if(!keepDistance(i, j))
                        return false;
                }
            }
        }
        return true;

    }

    public boolean keepDistance(int start_x, int start_y){
        for(int i=0; i<8; i++){
            int next_x = start_x + dx[i];
            int next_y = start_y + dy[i];

            if(next_x < 0 || next_x >= 5 || next_y < 0 || next_y >= 5)
                continue;

            if(seats[next_x][next_y].equals("P")){
                if(dx[i] == 2 || dx[i] == -2 || dy[i] == 2 || dy[i] == -2){
                    if(!seats[start_x + (dx[i]/2)][start_y + (dy[i]/2)].equals("X"))
                        return false;
                }
                else{
                    if(!seats[start_x + dx[i]][start_y].equals("X")
                            || !seats[start_x][start_y + dy[i]].equals("X"))
                        return false;
                }
            }
        }

        for(int i = 0; i < 4;i++){
            int nx = start_x + obstacle_x[i];
            int ny = start_y + obstacle_y[i];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if(seats[nx][ny].equals("P")) return false;
        }

        return true;
    }
}