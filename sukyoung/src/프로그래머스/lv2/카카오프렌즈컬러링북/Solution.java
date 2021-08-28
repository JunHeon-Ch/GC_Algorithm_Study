package 프로그래머스.lv2.카카오프렌즈컬러링북;

class Solution {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static boolean[][] visit;
    public static int area;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visit = new boolean[m][n];

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j] != 0 && !visit[i][j]){
                    numberOfArea++;
                    dfs(i,j,picture);
                }
                if(area > maxSizeOfOneArea)
                    maxSizeOfOneArea = area;
                area = 0;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public void dfs(int x, int y, int[][] picture){
        if(visit[x][y]){
            return;
        }

        visit[x][y] = true;
        area++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=picture.length || ny<0 || ny>=picture[0].length)
                continue;

            if(picture[x][y] == picture[nx][ny] && !visit[nx][ny]){
                dfs(nx,ny,picture);
            }
        }
    }
}