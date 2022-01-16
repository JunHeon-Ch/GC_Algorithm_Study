package 프로그래머스.lv3.기둥과보설치;

class Solution {
    public boolean[][] cols, rows; //col : 기둥, row : 보

    public int[][] solution(int n, int[][] build_frame) {

        int count = 0;
        cols = new boolean[n+1][n+1];
        rows = new boolean[n+1][n+1];
        for(int i=0; i<build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int action = build_frame[i][3];

            if(type == 0){ // 기둥
                if(action == 1){ //설치
                    if(checkCol(x,y)){
                        count++;
                        cols[x][y] = true;
                    }
                }
                else{ //제거
                    cols[x][y] = false;
                    if(!canDelete(n))
                        cols[x][y] = true;
                    else
                        count--;
                }
            }
            else{ // 보
                if(action == 1){ //설치
                    if(checkRow(x,y)){
                        count++;
                        rows[x][y] = true;
                    }
                }
                else{ // 제거
                    rows[x][y] = false;
                    if(!canDelete(n))
                        rows[x][y] = true;
                    else
                        count--;
                }
            }
        }

        int[][] answer = new int[count][3];
        int idx = 0;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(cols[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 0;
                }
                if(rows[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 1;
                }
            }
        }

        return answer;
    }

    public boolean canDelete(int n){
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(cols[i][j] && !checkCol(i, j))
                    return false; // 기둥이 해당 위치에 있을 수 없다면 false
                else if(rows[i][j] && !checkRow(i, j))
                    return false; // 바닥이 해당 위치에 있을 수 없다면 false
            }
        }
        return true;
    }

    //기둥
    public boolean checkCol(int x, int y){
        //바닥
        if(y==0)
            return true;
            // 보의 한쪽 끝 부분 위
        else if(x > 0 && rows[x-1][y] || rows[x][y])
            return true;
            //다른 기둥 위에
        else if(y > 0 && cols[x][y-1])
            return true;
        else
            return false;
    }

    //보
    public boolean checkRow(int x, int y){
        //한쪽 끝 부분이 기둥 위
        if(y > 0 && cols[x][y-1] || cols[x+1][y-1])
            return true;
            //양쪽 끝 부분이 다른 보와 동시에 연결
        else if(x > 0 && rows[x-1][y] && rows[x+1][y])
            return true;
        else
            return false;
    }
}
